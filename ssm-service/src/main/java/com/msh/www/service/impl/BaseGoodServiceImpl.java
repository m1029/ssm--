package com.msh.www.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.BaseGood;
import com.msh.www.http.PageResult;
import com.msh.www.mapper.BaseGoodMapper;
import com.msh.www.service.IBaseGoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msh
 * @since 2020-10-17
 */
@Service

public class BaseGoodServiceImpl implements IBaseGoodService {

    @Resource
    private BaseGoodMapper baseGoodMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<BaseGood> findAll() {
        return baseGoodMapper.selectList(null);
    }

    /**
     * 分页查询
     * @param page 将currentPage pageSize封装成一个对象
     * @return
     */
    @Override
    public PageResult pageList(IPage<BaseGood> page) {
        IPage<BaseGood> baseGoodIPage = baseGoodMapper.selectPage(page, null);

        return PageResult.instance(baseGoodIPage.getRecords(),baseGoodIPage.getTotal());
    }

    /**
     * 根据id查询
     * @param id 表示数据库的主键
     * @return
     */
    @Override
    public BaseGood findById(Serializable id) {
        return baseGoodMapper.selectById(id);
    }

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    @Override
    public void add(BaseGood entity) {

        baseGoodMapper.insert(entity);
    }

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    @Override
    public void update(BaseGood entity) {

        baseGoodMapper.updateById(entity);
    }

    /**
     * 删除功能
     * @param id 数据库的主键
     */
    @Override
    public void deleteById(Serializable id) {

        baseGoodMapper.deleteById(id);
    }
}
