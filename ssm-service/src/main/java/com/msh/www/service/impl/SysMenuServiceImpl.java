package com.msh.www.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.SysMenu;
import com.msh.www.http.PageResult;
import com.msh.www.mapper.SysMenuMapper;
import com.msh.www.service.ISysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;
    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<SysMenu> findAll() {
        return sysMenuMapper.selectList(null);
    }

    /**
     * 分页查询
     * @param page 封装成为实体类
     * @return
     */
    @Override
    public PageResult pageList(IPage<SysMenu> page) {
        IPage<SysMenu> sysMenuIPage = sysMenuMapper.selectPage(page, null);

        return PageResult.instance(sysMenuIPage.getRecords(),sysMenuIPage.getTotal());
    }


    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    @Override
    public SysMenu findById(Serializable id) {
        return sysMenuMapper.selectById(id);
    }

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    @Override
    public void add(SysMenu entity) {

        sysMenuMapper.insert(entity);
    }

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    @Override
    public void update(SysMenu entity) {

        sysMenuMapper.updateById(entity);
    }

    /**
     * 删除功能
     * @param id 数据库的主键
     */
    @Override
    public void deleteById(Serializable id) {

        sysMenuMapper.deleteById(id);
    }

    @Override
    public List<SysMenu> getCategoryTree() {
        return null;
    }

    /**
     * 通过递归得出菜单的树形结构
     * @return
     */
    @Override
    public List<SysMenu> getAllMenuTree() {
        List<SysMenu> all = this.findAll();
        //过滤出所有的一级目录和菜单
        List<SysMenu> collect = all.stream().filter(item -> item.getParentId().longValue()==0).collect(Collectors.toList());
        collect.forEach(item->{
            getMenuChild(item,all);
        });

        return collect;
    }


    public void getMenuChild(SysMenu sysMenu,List<SysMenu> all){
        //找到所有的二级菜单
        List<SysMenu> collect = all.stream().filter(item -> item.getParentId().equals(sysMenu.getMenuId())).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(collect)){
            sysMenu.setChildren(collect);
            //找到所有的子集菜单
            collect.forEach(item1->{
                getMenuChild(item1,all);
            });
        }
    }
}
