package com.msh.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.BaseUnit;

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
public interface IBaseUnitService{

    /**
     * 查询所有
     * @return
     */
    List<BaseUnit> findAll();

    /**
     * 分页查询
     * @param page 封装为一个对象
     * @return
     */
   IPage<BaseUnit> findByPage(IPage<BaseUnit> page);

    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    BaseUnit findById(Serializable id);

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    void add(BaseUnit entity);

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    void update(BaseUnit entity);

    /**
     * 通过id删除
     * @param id 数据库的主键
     */
    void deleteById(Serializable id);
}
