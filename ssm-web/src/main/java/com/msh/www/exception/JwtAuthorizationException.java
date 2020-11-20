package com.msh.www.exception;

import com.msh.www.http.AxiosStatus;

/**
 * token认证异常
 * @author dn26
 */
public class JwtAuthorizationException extends RuntimeException {

    private AxiosStatus axiosStatus;

    public AxiosStatus getAxiosStatus()  {
        return axiosStatus;
    }

    public void setAxiosStatus(AxiosStatus axiosStatus) {
        this.axiosStatus = axiosStatus;
    }


    public JwtAuthorizationException(AxiosStatus axiosStatus) {
    }
}
