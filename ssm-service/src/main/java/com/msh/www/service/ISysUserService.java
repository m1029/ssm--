package com.msh.www.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.SysMenu;
import com.msh.www.entity.SysUser;
import com.msh.www.http.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
public interface ISysUserService {

    /**
     * 查询所有
     * @return
     */
    List<SysUser> findAll();

    /**
     * 分页查询
     * @param page 封装成为实体类
     * @return
     */
    PageResult pageList(IPage<SysUser> page);

    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    SysUser findById(Serializable id);

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    void add(SysUser entity);

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    void update(SysUser entity);

    /**
     * 通过id删除
     * @param id 数据库的主键
     */
    void deleteById(Serializable id);


    /**
     * 根据用户名查找对应的用户
     * @param userName
     * @return
     */
    SysUser getUser(String userName);
}
