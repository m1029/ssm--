package com.msh.www.exception;

import com.msh.www.http.AxiosResult;
import com.msh.www.http.AxiosStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;

/**
 * 异常处理
 * @author dn26
 */
@RestControllerAdvice
public class CrmExceptionHandler {

    /**
     * 处理表单异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AxiosResult validException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        HashMap<String, String> map = new HashMap<>(16);
        if(bindingResult.hasFieldErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            });
        }
        return AxiosResult.error(AxiosStatus.VALID_FAILURE,map);
    }
}
