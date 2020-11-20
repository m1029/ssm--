package com.msh.www.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author msh
 * @since 2020-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型名称
     */
    private String name;

    /**
     * 父级id
     */
    private Integer pId;

    private transient String pName;
    /**
     * 自定义分类的孩子
     */
    private transient List<BaseCategory> children;

}
