package com.msh.www.anntation;

import com.msh.www.handler.SexValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Target 作用在不同的方法 域 构造方法等等
 *
 * @ Retention(RetentionPolicy.RUNTIME)  此注解的意思是运行时去验证
 *
 * @ Constraint(validatedBy = {}) 验证器
 * 自定义的注解
 * @author dn26
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SexValueValidator.class})
public @interface SexValues {

    String message() default "{javax.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
  //使用自定义注解的时候需要填值的
    String[] values() default {};
}
