package com.msh.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.SysRoleMenu;
import com.msh.www.http.PageResult;
import com.msh.www.mapper.SysRoleMenuMapper;
import com.msh.www.service.ISysRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
@Service
public class SysRoleMenuServiceImpl implements ISysRoleMenuService {

   @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;



    @Override
    public List<SysRoleMenu> findAll() {
        return sysRoleMenuMapper.selectList(null);
    }

    @Override
    public PageResult pageList(IPage<SysRoleMenu> page) {
        IPage<SysRoleMenu> sysRoleMenuIPage = sysRoleMenuMapper.selectPage(page, null);
        return PageResult.instance(sysRoleMenuIPage.getRecords(),sysRoleMenuIPage.getTotal());
    }

    @Override
    public SysRoleMenu findById(Serializable id) {
        return sysRoleMenuMapper.selectById(id);
    }

    @Override
    public void add(SysRoleMenu entity) {
        sysRoleMenuMapper.insert(entity);

    }

    @Override
    public void update(SysRoleMenu entity) {
        sysRoleMenuMapper.updateById(entity);

    }

    @Override
    public void deleteById(Serializable id) {
        sysRoleMenuMapper.deleteById(id);
    }

    @Override
    public List<SysRoleMenu> findRoleMenu(Serializable id) {
        QueryWrapper<SysRoleMenu> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysRoleMenu::getRoleId,id);
        List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectList(wrapper);
        return sysRoleMenus;
    }

    @Override
    public void deleteByRoleId(Serializable id) {
        QueryWrapper<SysRoleMenu> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysRoleMenu::getRoleId,id);
        sysRoleMenuMapper.delete(wrapper);
    }

}
