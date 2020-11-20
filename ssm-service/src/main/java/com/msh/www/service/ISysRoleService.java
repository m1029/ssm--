package com.msh.www.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.SysRole;
import com.msh.www.http.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
public interface ISysRoleService {

    /**
     * 查询所有
     * @return
     */
    List<SysRole> findAll();

    /**
     * 分页查询
     * @param page 封装成为实体类
     * @return
     */
    PageResult pageList(IPage<SysRole> page);

    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    SysRole findById(Serializable id);

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    void add(SysRole entity);

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    void update(SysRole entity);

    /**
     * 通过id删除
     * @param id 数据库的主键
     */
    void deleteById(Serializable id);

    /**
     * 获得分类tree
     * @return
     */
    List<SysRole> getCategoryTree();
}
