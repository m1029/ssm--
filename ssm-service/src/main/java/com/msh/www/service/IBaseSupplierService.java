package com.msh.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.BaseSupplier;

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
public interface IBaseSupplierService {

    /**
     * 查询所有
     * @return
     */
    List<BaseSupplier> findAll();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<BaseSupplier> pageList(IPage<BaseSupplier> page);

    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    BaseSupplier findById(Serializable id);

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    void add(BaseSupplier entity);

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    void update(BaseSupplier entity);

    /**
     * 通过id删除
     * @param id 数据库的主键
     */
    void deleteById(Serializable id);
}
