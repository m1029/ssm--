package com.msh.www.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.www.email.EmailService;
import com.msh.www.entity.SysRole;
import com.msh.www.entity.SysUser;
import com.msh.www.goup.AddGroup;
import com.msh.www.goup.UpdateGroup;
import com.msh.www.http.AxiosResult;
import com.msh.www.service.ISysUserRoleService;
import com.msh.www.service.ISysUserService;
import freemarker.template.TemplateException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    @Resource
    private ISysUserService iSysUserService;
    /**
     * 动态盐加密
     */
    @Resource
   private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 邮箱发送页面
     */
    @Resource
    private EmailService emailService;
    /**
     * 模板引擎
     */
    @Resource
    private FreeMarkerConfigurer freeMarkerConfigurer;


    @Resource
    private ISysUserRoleService iSysUserRoleService;
//    /**
//     * 查询所有
//     * @return
//     */
//    @GetMapping
//    public AxiosResult findAll() {
//        return AxiosResult.success(iSysUserService.findAll());
//    }
//
//    /**
//     * 分页查询
//     *
//     *  @ RequestParam(defaultValue = "1")  当前端不传值的时候 使用标签给默认值
//     *
//     * @param currentPage
//     * @param pageSize
//     * @return
//     */
//    @GetMapping("page")
//    public AxiosResult pageList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize){
//        Page<SysUser> page = new Page<>(currentPage,pageSize);
//        return AxiosResult.success(iSysUserService.pageList(page));
//    }
//
//    /**
//     *
//     *    动态盐加密
//     * 添加功能
//     * @param sysUser
//     * @return
//     */
//    @PostMapping
//    public AxiosResult add(@Validated(AddGroup.class) @RequestBody SysUser sysUser) throws IOException, TemplateException {
//        sysUser.setPassword(bCryptPasswordEncoder.encode("123456"));
//        iSysUserService.add(sysUser);
//
////        Configuration configuration = freeMarkerConfigurer.getConfiguration();
////        Template template = configuration.getTemplate("user.ftl", "utf-8");
////
////        HashMap<String, String> map = new HashMap<>(16);
//////            使用map集合对模板中需要封装的参数进行封装
////        map.put("userId",sysUser.getUserId()+"");
////        map.put("userName",sysUser.getUserName());
////        map.put("email", sysUser.getEmail());
////        map.put("phone", sysUser.getPhone());
////        map.put("password","123456");
//////            因为freemarker只支持往外读的功能  那么就联想到使用字节内存流
////        StringWriter stringWriter = new StringWriter();
//////            将数据渲染到html(active.ftl)模板
////        template.process(map, stringWriter);
////        AsyncManger.getInstance().executeTask(AsyncFactory.executeEmail(sysUser.getEmail(),stringWriter.toString()));
//        return AxiosResult.success();
//    }
//
//    /**
//     * 修改功能
//     * @param sysUser
//     * @return
//     */
//    @PutMapping
//    public AxiosResult update(@Validated(UpdateGroup.class) @RequestBody SysUser sysUser){
//        System.out.println("==================================="+sysUser);
//        iSysUserService.update(sysUser);
//        return AxiosResult.success();
//    }
//
//    /**
//     * 删除功能
//     * @param id
//     * @return
//     */
//    @DeleteMapping("{id}")
//    public AxiosResult deleteById(@PathVariable Serializable id){
//        iSysUserService.deleteById(id);
//        return AxiosResult.success();
//    }
//
//    /**
//     * 根据id查询
//     * @param id
//     * @return
//     */
//    @GetMapping("{id}")
//    public AxiosResult findById(@PathVariable Serializable id){
//        return AxiosResult.success(iSysUserService.findById(id));
//    }


    /**
     * 根据用户id查找到对应的角色名称返回给前端
     * @param userId
     * @return
     */
    @GetMapping("{userId}/roles")
    public AxiosResult findRoleByUserId(@PathVariable Serializable userId){
        List<SysRole> roleByUserId = iSysUserRoleService.findRoleByUserId(userId);
        return AxiosResult.success(roleByUserId);
    }

    /**
     * 根据用户id和角色id删除对应的角色
     * @param userId
     * @param roleId
     * @return
     */
    @DeleteMapping("{userId}/role/{roleId}")
    public AxiosResult deleteRoleByRoleIdAndUserId(@PathVariable Serializable userId,@PathVariable Serializable roleId){
        iSysUserRoleService.deleteRoleByRoleIdAndUserId(userId, roleId);
        return AxiosResult.success();
    }
}
