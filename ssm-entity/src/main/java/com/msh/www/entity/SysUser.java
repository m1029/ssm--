package com.msh.www.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.msh.www.anntation.SexValues;
import com.msh.www.goup.AddGroup;
import com.msh.www.goup.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author msh
 * @since 2020-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  @ Null 当添加的时候不需要传id所以可以为null
     *  @ NotNull 当修改的时候必须通过id去修改
     *
     *  那么就需要进行分组校验 就需要定义一个分组校验的接口 里面为空不要写方法
     *
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    @Null(groups = {AddGroup.class},message = "添加时ID必须为空")
    @NotNull(groups = {UpdateGroup.class},message ="修改时ID不能为空" )
    private Long userId;

    /**
     * 用户账号
     */
    @NotBlank(message = "用户账号不能为空",groups = {AddGroup.class,UpdateGroup.class})
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_]{5,7}",message = "请以字母数字下划线并且以字母开头  长度为 6-8",groups = {AddGroup.class,UpdateGroup.class})
    private String userName;

    /** 表单验证的注解
     *  @ NotNull  不能为null 可以为空字符串
     *  @ NotEmpty  不能为null 不能有空字符串  可以为空白字符
     *  @ NotBlank   不能为null 不能有空字符串  不能为空白字符
     *  @ NotBlank(message = "没有给值") 自己自定义的提示信息  如果不用就会默认系统自带的提示信息
     *
     * 用户昵称
     */
    @NotBlank(message = "昵称不能为空",groups = {AddGroup.class,UpdateGroup.class})
    private String nickName;

    /**
     * 用户邮箱
     */
    @NotBlank(message = "邮箱不能为空",groups = {AddGroup.class,UpdateGroup.class})
    @Email(message = "你输入的必须是个邮箱类型",groups = {AddGroup.class,UpdateGroup.class})
    private String email;

    /**
     * 手机号码
     */
    @Pattern(groups = {AddGroup.class,UpdateGroup.class},regexp = "[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}",message = "输入的必须为手机号码")
    @NotBlank(message = "手机号码不能为空",groups = {AddGroup.class,UpdateGroup.class})
    private String phone;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @SexValues(values = {"0","1"},message = "请输入正确的性别",groups = {AddGroup.class,UpdateGroup.class})
    private String sex;

    /**
     * 头像地址
     */
    @URL(message = "请输入有效的地址",groups = {AddGroup.class,UpdateGroup.class})
    @NotBlank(message = "请上传文件",groups = {AddGroup.class,UpdateGroup.class})
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 帐号状态（1正常 0停用）
     */
    private Boolean status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private Integer delFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户角色的id
     */
    private transient String roleIds;


}
