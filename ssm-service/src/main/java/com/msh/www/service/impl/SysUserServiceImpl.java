package com.msh.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.SysMenu;
import com.msh.www.entity.SysRoleMenu;
import com.msh.www.entity.SysUser;
import com.msh.www.entity.SysUserRole;
import com.msh.www.http.PageResult;
import com.msh.www.mapper.SysRoleMenuMapper;
import com.msh.www.mapper.SysUserMapper;
import com.msh.www.mapper.SysUserRoleMapper;
import com.msh.www.service.ISysMenuService;
import com.msh.www.service.ISysUserRoleService;
import com.msh.www.service.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private ISysUserRoleService iSysUserRoleService;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Resource
    private ISysMenuService iSysMenuService;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectList(null);
    }

    @Override
    public PageResult pageList(IPage<SysUser> page) {
        IPage<SysUser> sysUserIPage = sysUserMapper.selectPage(page, null);
        return PageResult.instance(sysUserIPage.getRecords(), sysUserIPage.getTotal());
    }

    @Override
    public SysUser findById(Serializable id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public void add(SysUser entity) {
        //添加用户的角色
        sysUserMapper.insert(entity);
        String[] as = entity.getRoleIds().split("A");
        Arrays.asList(as).forEach(item -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(entity.getUserId());
            userRole.setRoleId(Long.parseLong(item));
            iSysUserRoleService.add(userRole);
        });

    }

    /**
     * 添加用户角色
     *
     * @param entity 实体类对象
     */
    @Override
    public void update(SysUser entity) {
        sysUserMapper.updateById(entity);
        //添加之前先删除用户id对应的角色名称
        iSysUserRoleService.deleteRoleByUserId(entity.getUserId());
        String[] as = entity.getRoleIds().split("A");
        Arrays.asList(as).forEach(item -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(entity.getUserId());
            userRole.setRoleId(Long.parseLong(item));
            iSysUserRoleService.add(userRole);
        });
    }

    @Override
    public void deleteById(Serializable id) {

        sysUserMapper.deleteById(id);
    }

    /**
     * 通过用户名查找对应的用户
     * @param userName
     * @return
     */
    @Override
    public SysUser getUser(String userName) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUserName,userName);
        List<SysUser> sysUsers = sysUserMapper.selectList(queryWrapper);
        return sysUsers.get(0);
    }


}
