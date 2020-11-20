package com.msh.www.login;


import com.msh.www.http.AxiosResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 登录管理
 * @author dn26
 */
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("login")
    public AxiosResult login(@RequestBody Map<String,String> map){
       String userName=map.get("userName");
       String password=map.get("password");
        System.out.println(userName+"   "+password);
        AxiosResult dologin = loginService.dologin(userName, password);
        return AxiosResult.success(dologin);
    }
}
