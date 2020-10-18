package com.msh.www.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.BaseSupplier;
import com.msh.www.mapper.BaseSupplierMapper;
import com.msh.www.service.IBaseSupplierService;
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
 * @since 2020-10-17
 */
@Service

public class BaseSupplierServiceImpl implements IBaseSupplierService {

    @Resource
    private BaseSupplierMapper baseSupplierMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<BaseSupplier> findAll() {
        return baseSupplierMapper.selectList(null);
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @Override
    public IPage<BaseSupplier> pageList(IPage<BaseSupplier> page) {
        return baseSupplierMapper.selectPage(page,null);
    }

    /**
     * 根据id查询
     * @param id 表示数据库的主键
     * @return
     */
    @Override
    public BaseSupplier findById(Serializable id) {
        return baseSupplierMapper.selectById(id);
    }

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    @Override
    public void add(BaseSupplier entity) {

        baseSupplierMapper.insert(entity);
    }

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    @Override
    public void update(BaseSupplier entity) {

        baseSupplierMapper.updateById(entity);
    }

    /**
     * 删除功能
     * @param id 数据库的主键
     */
    @Override
    public void deleteById(Serializable id) {

        baseSupplierMapper.deleteById(id);
    }
}
