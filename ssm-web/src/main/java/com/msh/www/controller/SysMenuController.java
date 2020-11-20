package com.msh.www.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.www.entity.SysMenu;
import com.msh.www.http.AxiosResult;
import com.msh.www.service.ISysMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Resource
    private ISysMenuService iSysMenuService;

    /**
     * 查询所有菜单
     * @return
     */
    @GetMapping("menuTree")
    public AxiosResult findAll() {
        return AxiosResult.success(iSysMenuService.getAllMenuTree());
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
    public AxiosResult pageList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize){
        Page<SysMenu> page = new Page<>(currentPage,pageSize);

        return AxiosResult.success(iSysMenuService.pageList(page));
    }

    /**
     * 添加功能
     * @param sysMenu
     * @return
     */
    @PostMapping
    public AxiosResult add(@RequestBody SysMenu sysMenu){
        iSysMenuService.add(sysMenu);
        return AxiosResult.success();
    }

    /**
     * 修改功能
     * @param sysMenu
     * @return
     */
    @PutMapping
    public AxiosResult update(@RequestBody SysMenu sysMenu){
        iSysMenuService.update(sysMenu);
        return AxiosResult.success();
    }

    /**
     * 删除功能
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public AxiosResult deleteById(@PathVariable Serializable id){
        iSysMenuService.deleteById(id);
        return AxiosResult.success();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public AxiosResult findById(@PathVariable Serializable id){
        return AxiosResult.success(iSysMenuService.findById(id));
    }
}
