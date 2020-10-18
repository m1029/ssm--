package com.msh.www.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.www.entity.BaseCategory;
import com.msh.www.mapper.BaseCategoryMapper;
import com.msh.www.service.IBaseCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author msh
 * @ Log4j 可以记录的是每一条数据的日志打印情况
 * @since 2020-10-17
 */
@Service

public class BaseCategoryServiceImpl implements IBaseCategoryService {


    @Resource
    private BaseCategoryMapper baseCategoryMapper;

    /**
     * 查询所有
     *
     *
     * @return
     */
    @Override
    public List<BaseCategory> findAll() {

        return baseCategoryMapper.selectList(null);
    }

    /**
     * 分页查询
     *
     * @param page 封装成为实体类
     * @return
     */
    @Override
    public IPage<BaseCategory> pageList(IPage<BaseCategory> page) {
        IPage<BaseCategory> page1 = baseCategoryMapper.selectPage(page, null);
        return page1;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public BaseCategory findById(Serializable id) {
        return baseCategoryMapper.selectById(id);
    }

    /**
     * 添加功能
     *
     * @param entity 实体类对象
     */
    @Override
    public void add(BaseCategory entity) {

        baseCategoryMapper.insert(entity);
    }

    /**
     * 修改功能
     *
     * @param entity 实体类对象
     */
    @Override
    public void update(BaseCategory entity) {

        baseCategoryMapper.updateById(entity);
    }

    /**
     * 删除功能
     *
     * @param id 数据库的主键
     */
    @Override
    public void deleteById(Serializable id) {

        baseCategoryMapper.deleteById(id);
    }
}
