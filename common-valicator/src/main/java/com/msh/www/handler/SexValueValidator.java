package com.msh.www.handler;

import com.msh.www.anntation.SexValues;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class SexValueValidator implements ConstraintValidator<SexValues,String> {
    /**
     * 初始化
     * @param constraintAnnotation
     */
    List<String> list;
    @Override
    public void initialize(SexValues constraintAnnotation) {
        // values 表示注解上指定的值
        String[] values = constraintAnnotation.values();

        list=Arrays.asList(values);
    }

    /**
     * 验证
     * @param value
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //value 表示前端传过来的值 进行判读
        return list.contains(value);
    }
}
