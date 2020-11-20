package com.msh.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.SysRole;
import com.msh.www.entity.SysUserRole;
import com.msh.www.http.PageResult;
import com.msh.www.mapper.SysUserRoleMapper;
import com.msh.www.service.ISysRoleService;
import com.msh.www.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private ISysRoleService iSysRoleService;
    @Override
    public List<SysUserRole> findAll() {
        return sysUserRoleMapper.selectList(null);
    }

    @Override
    public PageResult pageList(IPage<SysUserRole> page) {
        IPage<SysUserRole> sysUserRoleIPage = sysUserRoleMapper.selectPage(page, null);

        return PageResult.instance(sysUserRoleIPage.getRecords(),sysUserRoleIPage.getTotal());
    }

    @Override
    public SysUserRole findById(Serializable id) {
        return sysUserRoleMapper.selectById(id);
    }

    @Override
    public void add(SysUserRole entity) {

        sysUserRoleMapper.insert(entity);
    }

    @Override
    public void update(SysUserRole entity) {

        sysUserRoleMapper.updateById(entity);
    }

    @Override
    public void deleteById(Serializable id) {

        sysUserRoleMapper.deleteById(id);
    }

    @Override
    public List<SysUserRole> getCategoryTree() {
        return null;
    }

    /**
     * 根据角色id查找到对应的角色名称
     * @param userId
     * @return
     */
    @Override
    public List<SysRole> findRoleByUserId(Serializable userId) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserRole::getUserId,userId);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(queryWrapper);
        List<SysRole> sysRoles = new ArrayList<>();
        sysUserRoles.forEach(item->{
            SysRole role = iSysRoleService.findById(item.getRoleId());
            sysRoles.add(role);
        });
        return sysRoles;
    }

    /**
     * 根据用户id和角色id删除对应的角色
     * @param userId
     * @param roleId
     */
    @Override
    public void deleteRoleByRoleIdAndUserId(Serializable userId, Serializable roleId) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserRole::getUserId,userId).eq(SysUserRole::getRoleId,roleId);
        sysUserRoleMapper.delete(queryWrapper);
    }

    /**
     * 根据传过来的用户id删除对应的角色
     * @param userId
     */
    @Override
    public void deleteRoleByUserId(Serializable userId) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserRole::getUserId,userId);
        sysUserRoleMapper.delete(queryWrapper);
    }
}
