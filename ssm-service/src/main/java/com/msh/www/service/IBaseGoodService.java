package com.msh.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.BaseGood;
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
public interface IBaseGoodService{

    /**
     * 查询所有
     * @return
     */
    List<BaseGood> findAll();

    /**
     * 分页查询
     * @param page 将currentPage pageSize封装成一个对象
     * @return
     */
    PageResult pageList(IPage<BaseGood> page);

    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    BaseGood findById(Serializable id);

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    void add(BaseGood entity);

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    void update(BaseGood entity);

    /**
     * 通过id删除
     * @param id 数据库的主键
     */
    void deleteById(Serializable id);
}
