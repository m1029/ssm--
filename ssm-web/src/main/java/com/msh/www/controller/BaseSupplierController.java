package com.msh.www.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.www.entity.BaseSupplier;
import com.msh.www.http.AxiosResult;
import com.msh.www.service.IBaseSupplierService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author msh
 * @since 2020-10-17
 */
@RestController
@RequestMapping("supplier")
public class BaseSupplierController {

    @Resource
    private IBaseSupplierService iBaseSupplierService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public AxiosResult findAll() {
        return AxiosResult.success(iBaseSupplierService.findAll());
    }

    /**
     * 分页查询
     *
     *  @ RequestParam(defaultValue = "1")  当前端不传值的时候 使用标签给默认值
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public AxiosResult pageList(@RequestParam(defaultValue = "1") int currentPage,@RequestParam(defaultValue = "5") int pageSize){
        Page<BaseSupplier> page = new Page<>(currentPage,pageSize);
        return AxiosResult.success(iBaseSupplierService.pageList(page));
    }

    /**
     * 添加功能
     * @param baseSupplier
     * @return
     */
    @PostMapping
    public AxiosResult add(@RequestBody BaseSupplier baseSupplier){
        iBaseSupplierService.add(baseSupplier);
        return AxiosResult.success();
    }

    /**
     * 修改功能
     * @param baseSupplier
     * @return
     */
    @PutMapping
    public AxiosResult update(@RequestBody BaseSupplier baseSupplier){
        iBaseSupplierService.update(baseSupplier);
        return AxiosResult.success();
    }

    /**
     * 删除功能
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public AxiosResult deleteById(@PathVariable Serializable id){
        iBaseSupplierService.deleteById(id);
        return AxiosResult.success();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public AxiosResult findById(@PathVariable Serializable id){
        return AxiosResult.success(iBaseSupplierService.findById(id));
    }
}
