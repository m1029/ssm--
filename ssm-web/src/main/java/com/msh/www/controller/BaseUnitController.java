package com.msh.www.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.www.entity.BaseUnit;
import com.msh.www.http.AxiosResult;
import com.msh.www.service.IBaseUnitService;
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
@RequestMapping("unit")
public class BaseUnitController {

    @Resource
    private IBaseUnitService iBaseUnitService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public AxiosResult findAll() {
        return AxiosResult.success(iBaseUnitService.findAll());
    }

    /**
     * 分页查询
     *
     *  @ RequestParam(defaultValue = "1")  当前端不传值的时候 使用标签给默认值
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public AxiosResult pageList(@RequestParam(defaultValue = "1") int currentPage,@RequestParam(defaultValue = "5") int pageSize){
        Page<BaseUnit> page = new Page<>(currentPage,pageSize);

        return AxiosResult.success(iBaseUnitService.findByPage(page));
    }

    /**
     * 添加功能
     * @param baseUnit
     * @return
     */
    @PostMapping
    public AxiosResult add(@RequestBody BaseUnit baseUnit){
        iBaseUnitService.add(baseUnit);
        return AxiosResult.success();
    }

    /**
     * 修改功能
     * @param baseUnit
     * @return
     */
    @PutMapping
    public AxiosResult update(@RequestBody BaseUnit baseUnit){
        iBaseUnitService.update(baseUnit);
        return AxiosResult.success();
    }

    /**
     * 删除功能
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public AxiosResult deleteById(@PathVariable Serializable id){
        iBaseUnitService.deleteById(id);
        return AxiosResult.success();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public AxiosResult findById(@PathVariable Serializable id){
        return AxiosResult.success(iBaseUnitService.findById(id));
    }

}
