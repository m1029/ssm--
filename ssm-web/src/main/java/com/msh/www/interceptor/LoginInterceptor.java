package com.msh.www.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.msh.www.exception.JwtAuthorizationException;
import com.msh.www.http.AxiosStatus;
import com.msh.www.service.token.Tokenservice;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *登录拦截器
 * @author dn26
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        /*
        *   session 的方式进行登录拦截 它是有状态的
        *        缺点：多个服务器 需要共享session
        *              浏览器可以禁用cookie
        *              可以攻击网站
        *              数据不安全
        *              前后端分离需要同时允许cookie
        *
        *
        *    思想：
        *    这种方式是无状态的
        *       每一次请求的时候（除了登录）前端在请求头当中携带一个后台能够识别的内容  携带的内容建议为Token令牌   JWT 任何语言中都有Token
        *
        *   Token有三部分组成： 头部（Header） 载荷(Payload)  签名(Signature)
        *
        *
        * */
        /**
         * 获取前台发过来的 Token指令
         */
        String authorization = request.getHeader("Authorization");
        if(!StringUtils.isEmpty(authorization) && authorization.startsWith("Bearer")){
            //截取前台的发送过来的token
            String s = authorization.split(" ")[1];
            DecodedJWT decodedJWT = Tokenservice.verifierToken(s);
            if(decodedJWT!=null){
                throw new JwtAuthorizationException(AxiosStatus.TOKEN_ERROR);
            }

        }else {
            throw new JwtAuthorizationException(AxiosStatus.TOKEN_ERROR);
        }

        return true;
    }
}
