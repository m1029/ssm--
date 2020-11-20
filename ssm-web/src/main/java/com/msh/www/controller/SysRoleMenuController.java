package com.msh.www.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.www.entity.SysRoleMenu;
import com.msh.www.http.AxiosResult;
import com.msh.www.service.ISysRoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * <p>
 * 角色和菜单关联表 前端控制器
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
@RestController
@RequestMapping("roleMenu")
public class SysRoleMenuController {

    @Resource
    private ISysRoleMenuService iSysRoleMenuService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public AxiosResult findAll() {
        return AxiosResult.success(iSysRoleMenuService.findAll());
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
        Page<SysRoleMenu> page = new Page<>(currentPage,pageSize);


        return AxiosResult.success(iSysRoleMenuService.pageList(page));
    }

    /**
     * 添加功能
     * @param sysRoleMenu
     * @return
     */
    @PostMapping
    public AxiosResult add(@RequestBody SysRoleMenu sysRoleMenu){
        iSysRoleMenuService.add(sysRoleMenu);
        return AxiosResult.success();
    }

    /**
     * 修改功能
     * @param sysRoleMenu
     * @return
     */
    @PutMapping
    public AxiosResult update(@RequestBody SysRoleMenu sysRoleMenu){
        iSysRoleMenuService.update(sysRoleMenu);
        return AxiosResult.success();
    }

    /**
     * 删除功能
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public AxiosResult deleteById(@PathVariable Serializable id){
        iSysRoleMenuService.deleteById(id);
        return AxiosResult.success();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public AxiosResult findById(@PathVariable Serializable id){
        return AxiosResult.success(iSysRoleMenuService.findById(id));
    }
}
