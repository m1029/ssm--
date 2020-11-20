package com.msh.www.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.www.entity.SysUserRole;
import com.msh.www.http.AxiosResult;
import com.msh.www.service.ISysUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * <p>
 * 用户和角色关联表 前端控制器
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
@RestController
@RequestMapping("userRole")
public class SysUserRoleController {

    @Resource
    private ISysUserRoleService iSysUserRoleService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public AxiosResult findAll() {
        return AxiosResult.success(iSysUserRoleService.findAll());
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
        Page<SysUserRole> page = new Page<>(currentPage,pageSize);
        return AxiosResult.success(iSysUserRoleService.pageList(page));
    }

    /**
     * 添加功能
     * @param sysUserRole
     * @return
     */
    @PostMapping
    public AxiosResult add(@RequestBody SysUserRole sysUserRole){
        iSysUserRoleService.add(sysUserRole);
        return AxiosResult.success();
    }

    /**
     * 修改功能
     * @param sysUserRole
     * @return
     */
    @PutMapping
    public AxiosResult update(@RequestBody SysUserRole sysUserRole){
        iSysUserRoleService.update(sysUserRole);
        return AxiosResult.success();
    }

    /**
     * 删除功能
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public AxiosResult deleteById(@PathVariable Serializable id){
        iSysUserRoleService.deleteById(id);
        return AxiosResult.success();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public AxiosResult findById(@PathVariable Serializable id){
        return AxiosResult.success(iSysUserRoleService.findById(id));
    }
}
