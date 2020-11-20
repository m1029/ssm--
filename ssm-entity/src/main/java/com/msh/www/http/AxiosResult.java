package com.msh.www.http;

import java.util.HashMap;

/**
 * 封装返回状态码
 */
public class AxiosResult extends HashMap<String,Object> {

    public static final String STATUS="status";
    public static final String MESSAGE="message";
    public static final String DATA="data";

    public AxiosResult() {
    }

    /**
     * 将枚举类型进行封装
     * @param axiosStatus
     */
    public AxiosResult(AxiosStatus axiosStatus) {
        put(STATUS,axiosStatus.getStatus());
        put(MESSAGE,axiosStatus.getMessage());
    }

    /**
     * 设置成功的函数
     */
    public static AxiosResult success(){
        return new AxiosResult(AxiosStatus.OK);
    }
    /**
     * 定义其他的成功的状态码
     */

    public static AxiosResult success(AxiosStatus axiosStatus){
        return new AxiosResult(axiosStatus);
    }

    /**
     * 带内容的成功的状态码
     */
    public static AxiosResult success(Object obj){
        AxiosResult axiosResult = new AxiosResult(AxiosStatus.OK);
        axiosResult.put(DATA,obj);
        return axiosResult;
    }

    /**
     * 操作错误的状态码
     * @return
     */
    public static AxiosResult error(){
        return new AxiosResult(AxiosStatus.ERROR);
    }
    /**
     * 定义其它类型的错误状态码
     */
    public static AxiosResult error(AxiosStatus axiosStatus){
        return new AxiosResult(axiosStatus);
    }

    /**
     * 返回携带错误信息的状态
     * @param axiosStatus
     * @param obj
     * @return
     */
    public static AxiosResult error(AxiosStatus axiosStatus, Object obj){

        AxiosResult axiosResult = new AxiosResult(axiosStatus);
        axiosResult.put(DATA,obj);
        return axiosResult;
    }

    /**
     * 错误的状态码带有返回值
     */
    public static AxiosResult error(Object obj){
        AxiosResult axiosResult = new AxiosResult(AxiosStatus.ERROR);
        axiosResult.put(DATA,obj);
        return axiosResult;
    }
}
