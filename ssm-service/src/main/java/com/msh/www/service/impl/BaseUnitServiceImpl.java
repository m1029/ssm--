package com.msh.www.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.BaseUnit;
import com.msh.www.mapper.BaseUnitMapper;
import com.msh.www.service.IBaseUnitService;
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
public class BaseUnitServiceImpl  implements IBaseUnitService {

    @Resource
    private BaseUnitMapper baseUnitMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<BaseUnit> findAll() {
        return baseUnitMapper.selectList(null);
    }

    /**
     * 分页查询
     * @param page 封装为一个对象
     * @return
     */
    @Override
    public IPage<BaseUnit> findByPage(IPage<BaseUnit> page) {
        return baseUnitMapper.selectPage(page,null);
    }

    /**
     * 通过id查询
     * @param id 表示数据库的主键
     * @return
     */
    @Override
    public BaseUnit findById(Serializable id) {
        return baseUnitMapper.selectById(id);
    }

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    @Override
    public void add(BaseUnit entity) {

        baseUnitMapper.insert(entity);
    }

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    @Override
    public void update(BaseUnit entity) {

        baseUnitMapper.updateById(entity);
    }

    /**
     * 删除功能
     * @param id 数据库的主键
     */
    @Override
    public void deleteById(Serializable id) {

        baseUnitMapper.deleteById(id);
    }
}
