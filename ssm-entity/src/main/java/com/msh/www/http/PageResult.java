package com.msh.www.http;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @ AllArgsConstructor 所有参数的构造函数
 * 分页查询的内容和总数
 */
@Data
@AllArgsConstructor
public class PageResult {

    private Object records;

    private long total;

    /**
     * 定义静态方法  直接返回本身
     * @param records
     * @param total
     * @return
     */
    public static PageResult instance(Object records,long total){
        return new PageResult(records,total);
    }
}
