package com.msh.www.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.www.entity.BaseCategory;
import com.msh.www.http.AxiosResult;
import com.msh.www.http.PageResult;
import com.msh.www.service.IBaseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author msh
 * @since 2020-10-17
 */
@RestController
@RequestMapping("Category")
public class BaseCategoryController {

    @Autowired
    private IBaseCategoryService iBaseCategoryService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping
    public AxiosResult findAll() {
        return AxiosResult.success(iBaseCategoryService.findAll());
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public AxiosResult findById(@PathVariable Serializable id) {
        return AxiosResult.success(iBaseCategoryService.findById(id));
    }

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     * @ RequestParam(defaultValue = "1")  当前端不传值的时候 使用标签给默认值
     */
    @GetMapping("page")
    public AxiosResult pageList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize) {
        Page<BaseCategory> page = new Page<>(currentPage, pageSize);
        PageResult pageResult = iBaseCategoryService.pageList(page);
        return AxiosResult.success(pageResult);
    }

    /**
     * 删除功能
     *
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public AxiosResult delete(@PathVariable Serializable id) {
        iBaseCategoryService.deleteById(id);
        return AxiosResult.success();
    }

    /**
     * 添加功能
     *
     * @param baseCategory
     * @return
     */
    @PostMapping
    public AxiosResult add(@RequestBody BaseCategory baseCategory) {
        iBaseCategoryService.add(baseCategory);
        return AxiosResult.success();
    }

    /**
     * 修改功能
     *
     * @param baseCategory
     * @return
     */
    @PutMapping
    public AxiosResult update(@RequestBody BaseCategory baseCategory) {
        iBaseCategoryService.update(baseCategory);
        return AxiosResult.success();
    }

    /**
     * 查询商品所属分类  以递归的方式去获取  通过等级的方式返回给前端
     *
     * @return
     */
    @GetMapping("categoryTree")
    public AxiosResult getCategoryTree() {
        List<BaseCategory> treeList = iBaseCategoryService.getCategoryTree();
        return AxiosResult.success(treeList);
    }


}
