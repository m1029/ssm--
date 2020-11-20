package com.msh.www.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.www.entity.BaseCustomer;
import com.msh.www.http.AxiosResult;
import com.msh.www.service.IBaseCustomerService;
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
@RequestMapping("customer")
public class BaseCustomerController {

    @Resource
    private IBaseCustomerService iBaseCustomerService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
     public AxiosResult findById(@PathVariable Serializable id){
        return AxiosResult.success(iBaseCustomerService.findById(id));
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public AxiosResult findAll(){
        return AxiosResult.success(iBaseCustomerService.findAll());
    }

    /**
     * 分页查询
     *  @ RequestParam(defaultValue = "1")  当前端不传值的时候 使用标签给默认值
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public AxiosResult pageList(@RequestParam(defaultValue = "1") int currentPage,@RequestParam(defaultValue = "5") int pageSize){
        Page<BaseCustomer> page = new Page<>(currentPage, pageSize);

        return AxiosResult.success(iBaseCustomerService.pageList(page));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public AxiosResult delete(@PathVariable Serializable id){
        iBaseCustomerService.deleteById(id);
        return AxiosResult.success();
    }

    /**
     * 添加功能
     * @param baseCustomer
     * @return
     */
    @PostMapping
    public AxiosResult add(@RequestBody BaseCustomer baseCustomer){
        iBaseCustomerService.add(baseCustomer);
        return AxiosResult.success();
    }

    /**
     * 修改功能
     * @param baseCustomer
     * @return
     */
    @PutMapping
    public AxiosResult update(@RequestBody BaseCustomer baseCustomer){
        iBaseCustomerService.update(baseCustomer);
        return AxiosResult.success();
    }
}
