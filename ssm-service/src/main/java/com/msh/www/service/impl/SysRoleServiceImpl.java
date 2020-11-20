package com.msh.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.SysMenu;
import com.msh.www.entity.SysRole;
import com.msh.www.entity.SysRoleMenu;
import com.msh.www.http.PageResult;
import com.msh.www.mapper.SysRoleMapper;
import com.msh.www.service.ISysMenuService;
import com.msh.www.service.ISysRoleMenuService;
import com.msh.www.service.ISysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private ISysRoleMenuService iSysRoleMenuService;

    @Resource
    private ISysMenuService iSysMenuService;

    /**
     * 查询所有  角色为升序排序
     *
     * @return
     */
    @Override
    public List<SysRole> findAll() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByAsc(SysRole::getRoleSort);
        List<SysRole> sysRoles = sysRoleMapper.selectList(queryWrapper);
        return sysRoles;
    }

    @Override
    public PageResult pageList(IPage<SysRole> page) {
        IPage<SysRole> sysRoleIPage = sysRoleMapper.selectPage(page, null);

        return PageResult.instance(sysRoleIPage.getRecords(), sysRoleIPage.getTotal());
    }

    @Override
    public SysRole findById(Serializable id) {
        ArrayList<SysMenu> list = new ArrayList<>();
        ArrayList<Long> menIds = new ArrayList<>();
        SysRole sysRole = sysRoleMapper.selectById(id);
        List<SysRoleMenu> roleMenu = iSysRoleMenuService.findRoleMenu(sysRole.getRoleId());
        roleMenu.forEach(item -> {
            SysMenu byId = iSysMenuService.findById(item);
            list.add(byId);
        });
        //过滤 过滤掉了目录    只有菜单和按钮
        List<SysMenu> collect = list.stream().filter(sysMenu -> !sysMenu.getMenuType().equalsIgnoreCase("M")).collect(Collectors.toList());
        collect.forEach(sysMenu -> {
            if (!getChild(collect, sysMenu)) {
                menIds.add(sysMenu.getMenuId());
            }
        });
        sysRole.setMenuIds(menIds);

        return sysRole;
    }

    /**
     * 判断有没有孩子
     *
     * @param list
     */
    public boolean getChild(List<SysMenu> list, SysMenu sysMenu) {

        boolean match = list.stream().anyMatch(sysMenu1 -> sysMenu1.getParentId().longValue() == sysMenu.getMenuId().longValue());
        return match;
    }

    @Override
    public void add(SysRole entity) {
        sysRoleMapper.insert(entity);
        List<Long> menuIds = entity.getMenuIds();
        if (!CollectionUtils.isEmpty(menuIds)) {
            menuIds.forEach(item -> {
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setMenuId(item);
                sysRoleMenu.setRoleId(entity.getRoleId());
                iSysRoleMenuService.add(sysRoleMenu);
            });
        }
    }

    @Override
    public void update(SysRole entity) {
        sysRoleMapper.updateById(entity);
        iSysRoleMenuService.deleteByRoleId(entity.getRoleId());
        List<Long> menuIds = entity.getMenuIds();
        if(!CollectionUtils.isEmpty(menuIds)){
            menuIds.forEach(item->{
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setMenuId(item);
                sysRoleMenu.setRoleId(entity.getRoleId());
                iSysRoleMenuService.add(sysRoleMenu);
            });


        }
    }

    @Override
    public void deleteById(Serializable id) {

        sysRoleMapper.deleteById(id);
    }

    @Override
    public List<SysRole> getCategoryTree() {
        return null;
    }
}
