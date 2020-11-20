package com.msh.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.BaseCategory;
import com.msh.www.http.PageResult;

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
public interface IBaseCategoryService{

    /**
     * 查询所有
     * @return
     */
    List<BaseCategory> findAll();

    /**
     * 分页查询
     * @param page 封装成为实体类
     * @return
     */
    PageResult pageList(IPage<BaseCategory> page);

    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    BaseCategory findById(Serializable id);

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    void add(BaseCategory entity);

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    void update(BaseCategory entity);

    /**
     * 通过id删除
     * @param id 数据库的主键
     */
    void deleteById(Serializable id);

    /**
     * 获得分类tree
     * @return
     */
    List<BaseCategory> getCategoryTree();

}
