package com.msh.www.test;

import org.junit.runner.RunWith;
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
     *
     *
     *
     *
     *
     */
}
