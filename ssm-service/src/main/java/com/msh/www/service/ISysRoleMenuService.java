package com.msh.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.SysRoleMenu;
import com.msh.www.http.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 服务类
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
public interface ISysRoleMenuService  {

    /**
     * 查询所有
     * @return
     */
    List<SysRoleMenu> findAll();

    /**
     * 分页查询
     * @param page 封装成为实体类
     * @return
     */
    PageResult pageList(IPage<SysRoleMenu> page);

    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    SysRoleMenu findById(Serializable id);

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    void add(SysRoleMenu entity);

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    void update(SysRoleMenu entity);

    /**
     * 通过id删除
     * @param id 数据库的主键
     */
    void deleteById(Serializable id);

    /**
     * 根据role id查找对应的权限
     * @param id
     * @return
     */
    List<SysRoleMenu> findRoleMenu(Serializable id);

    /**
     * 根据角色id删除对应的角色权限
     * @param id
     */
    void deleteByRoleId(Serializable id);

//    /**
//     * 获得分类tree
//     * @return
//     */
//    List<SysRoleMenu> getCategoryTree();
}
