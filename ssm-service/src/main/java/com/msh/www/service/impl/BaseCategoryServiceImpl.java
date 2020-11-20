package com.msh.www.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msh.www.entity.BaseCategory;
import com.msh.www.http.PageResult;
import com.msh.www.mapper.BaseCategoryMapper;
import com.msh.www.service.IBaseCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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
    public PageResult pageList(IPage<BaseCategory> page) {
        IPage<BaseCategory> page1 = baseCategoryMapper.selectPage(page, null);
        List<BaseCategory> records = page1.getRecords();
        long total = page1.getTotal();
        records.forEach(item->{
            Integer pId = item.getPId();
          if(pId.equals(0)){
              item.setPName("一级分类");
          }else {
              if(this.findById(pId)!=null){
                  item.setPName(this.findById(pId).getName());
              }
          }
        });

        return PageResult.instance(records,total);
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

    /**
     * 通过递归获取商品的分类
     * @return
     */
    @Override
    public List<BaseCategory> getCategoryTree() {
//        所有的分类
        List<BaseCategory> all = this.findAll();
//        拿到所有的一级分类
        List<BaseCategory> collect = all.stream().filter(baseCategory -> baseCategory.getPId() == 0).collect(Collectors.toList());
//         调用方法 查到所有的二级分类
        collect.forEach(item->{
            getCategoryChild(item,all);
        });
        return collect;
    }


    /**
     * 找分类的孩子
     * @param baseCategory
     * @param all
     * @return
     */
    public void getCategoryChild(BaseCategory baseCategory,List<BaseCategory> all){

        //查出所有的二级分类
        List<BaseCategory> collect = all.stream().filter(baseCategory1 -> baseCategory1.getPId().equals(baseCategory.getId())).collect(Collectors.toList());

        if(!CollectionUtils.isEmpty(collect)){
            baseCategory.setChildren(collect);
        }

        //判断是否有其它级分类
        collect.forEach(baseCategory2->{
            getCategoryChild(baseCategory2,all);
        });

    }
}
