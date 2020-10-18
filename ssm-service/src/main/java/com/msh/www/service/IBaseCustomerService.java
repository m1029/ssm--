package com.msh.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.BaseCustomer;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msh
 * @since 2020-10-17
 */
public interface IBaseCustomerService{
    
    
    /**
     * 查询所有
     * @return
     */
    List<BaseCustomer> findAll();

    /**
     * 分页查询
     * @param page 将currentPage pageSize封装成一个对象
     * @return
     */
    IPage<BaseCustomer> pageList(IPage<BaseCustomer> page);

    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    BaseCustomer findById(Serializable id);

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    void add(BaseCustomer entity);

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    void update(BaseCustomer entity);

    /**
     * 通过id删除
     * @param id 数据库的主键
     */
    void deleteById(Serializable id);

}
