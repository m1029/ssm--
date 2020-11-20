package com.msh.www.test;

import com.msh.www.service.IBaseCategoryService;
import com.msh.www.service.ISysMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mapper.xml","classpath:applicationContext-service.xml"})
public class Demo {

    /**
     *
     * git提交项目时 需要配置忽略文件
     *
     * 提交时 我们只需要提交有用的代码
     *
     * 设置忽略文件的方式
     *
     * .gitignore
     *
     *  idea设置忽略文件
     *
     *  第一种方式  filtType
     *  第二种方式 fileIgore
     *   第三种方式 .ignore
     */

    @Autowired
    private IBaseCategoryService iBaseCategoryService;

    @Autowired
    private ISysMenuService iSysMenuService;

    @Test
    public void test(){
//
//        Page<BaseCategory> page = new Page<>(1,3);
//        System.out.println(iBaseCategoryService.pageList(page));
        System.out.println(iSysMenuService.getAllMenuTree());
    }

}
