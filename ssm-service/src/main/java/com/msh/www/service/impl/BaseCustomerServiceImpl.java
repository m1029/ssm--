package com.msh.www.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.BaseCustomer;
import com.msh.www.http.PageResult;
import com.msh.www.mapper.BaseCustomerMapper;
import com.msh.www.service.IBaseCustomerService;
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
public class BaseCustomerServiceImpl implements IBaseCustomerService {

    @Resource
    private BaseCustomerMapper baseCustomerMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<BaseCustomer> findAll() {
        return baseCustomerMapper.selectList(null);
    }

    /**
     * 分页查询
     * @param page 将currentPage pageSize封装成一个对象
     * @return
     */
    @Override
    public PageResult pageList(IPage<BaseCustomer> page) {
        IPage<BaseCustomer> baseCustomerIPage = baseCustomerMapper.selectPage(page, null);
        return PageResult.instance(baseCustomerIPage.getRecords(),baseCustomerIPage.getTotal());
    }

    /**
     * 根据id查询
     * @param id 表示数据库的主键
     * @return
     */
    @Override
    public BaseCustomer findById(Serializable id) {
        return baseCustomerMapper.selectById(id);
    }

    /**
     * 添加功能
     * @param entity 实体类对象
     */
    @Override
    public void add(BaseCustomer entity) {

        baseCustomerMapper.insert(entity);
    }

    /**
     * 修改功能
     * @param entity 实体类对象
     */
    @Override
    public void update(BaseCustomer entity) {

        baseCustomerMapper.updateById(entity);
    }

    /**
     * 删除功能
     * @param id 数据库的主键
     */
    @Override
    public void deleteById(Serializable id) {

        baseCustomerMapper.deleteById(id);
    }
}
