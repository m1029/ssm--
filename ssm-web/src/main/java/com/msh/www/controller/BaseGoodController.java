package com.msh.www.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.www.entity.BaseGood;
import com.msh.www.http.AxiosResult;
import com.msh.www.http.PageResult;
import com.msh.www.service.IBaseGoodService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author msh
 * @since 2020-10-17
 */
@RestController
@RequestMapping("good")
public class BaseGoodController {

    @Resource
    private IBaseGoodService iBaseGoodService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public AxiosResult findAll() {
        return AxiosResult.success(iBaseGoodService.findAll());
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
        Page<BaseGood> page = new Page<>(currentPage,pageSize);
        IPage<BaseGood> iPage = iBaseGoodService.pageList(page);
        return AxiosResult.success(PageResult.instance(iPage.getRecords(),iPage.getTotal()));
    }

    /**
     * 添加功能
     * @param baseGood
     * @return
     */
    @PostMapping
    public AxiosResult add(@RequestBody BaseGood baseGood){
        iBaseGoodService.add(baseGood);
        return AxiosResult.success();
    }

    /**
     * 修改功能
     * @param baseGood
     * @return
     */
    @PutMapping
    public AxiosResult update(@RequestBody BaseGood baseGood){
        iBaseGoodService.update(baseGood);
        return AxiosResult.success();
    }

    /**
     * 删除功能
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public AxiosResult deleteById(@PathVariable Serializable id){
        iBaseGoodService.deleteById(id);
        return AxiosResult.success();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public AxiosResult findById(@PathVariable Serializable id){
        return AxiosResult.success(iBaseGoodService.findById(id));
    }
}
