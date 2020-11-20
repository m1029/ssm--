package com.msh.www.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.SysRole;
import com.msh.www.entity.SysUserRole;
import com.msh.www.http.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户和角色关联表 服务类
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
public interface ISysUserRoleService {

    /**
     * 查询所有
     * @return
     */
    List<SysUserRole> findAll();

    /**
     * 分页查询
     * @param page 封装成为实体类
     * @return
     */
    PageResult pageList(IPage<SysUserRole> page);

    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    SysUserRole findById(Serializable id);

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    void add(SysUserRole entity);

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    void update(SysUserRole entity);

    /**
     * 通过id删除
     * @param id 数据库的主键
     */
    void deleteById(Serializable id);

    /**
     * 获得分类tree
     * @return
     */
    List<SysUserRole> getCategoryTree();

    /**
     * 根据用户id获取对应的角色
     * @param userId
     * @return
     */
    List<SysRole> findRoleByUserId(Serializable userId);

    /**
     * 根据用户id和角色id删除对应的角色
     * @param userId
     * @param roleId
     */
    void deleteRoleByRoleIdAndUserId(Serializable userId,Serializable roleId);

    /**
     * 根据用户id删除对应的角色  用来添加角色
     * @param userId
     */
    void deleteRoleByUserId(Serializable userId);
}
