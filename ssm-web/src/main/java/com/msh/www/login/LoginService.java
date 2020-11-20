package com.msh.www.login;

import com.alibaba.druid.util.StringUtils;
import com.msh.www.entity.SysLoginLog;
import com.msh.www.entity.SysUser;
import com.msh.www.http.AxiosResult;
import com.msh.www.http.AxiosStatus;
import com.msh.www.service.ISysLoginLogService;
import com.msh.www.service.ISysUserService;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 登录的逻辑
 *
 * @author dn26
 */
@Component
public class LoginService {

    @Resource
    private ISysUserService iSysUserService;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    private ISysLoginLogService isysLoginLogService;

    public AxiosResult dologin(String userName, String password, HttpServletRequest request) {

        SysLoginLog sysLoginLog = new SysLoginLog();

        sysLoginLog.setUserName(userName);
        sysLoginLog.setLoginTime(LocalDateTime.now());
        //获得ip地址
        sysLoginLog.setIpaddr(request.getRemoteAddr());
        //通过ip地址获取到真正的位置
        sysLoginLog.setLoginLocation();
        //拿到浏览器的请求头  通过库拿到操作系统以及浏览器的类型
        String header = request.getHeader("User-Agent");
        //获取到浏览器类型
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        sysLoginLog.setOs(userAgent.getBrowser().getName());
        //获取到操作系统
        sysLoginLog.getBrowser(userAgent.getOperatingSystem().getName());

        if (StringUtils.isEmpty(userName)) {
            return AxiosResult.error(AxiosStatus.USERENAME_NOT_EMRTY);
        }
        SysUser user = iSysUserService.getUser(userName);
        if (user == null) {
            //用户名不正确
            return AxiosResult.error(AxiosStatus.USERENAME_NOT_SURE);
        }
        boolean matches = bCryptPasswordEncoder.matches(password, user.getPassword());
        if (!matches) {
            //密码不正确
            return AxiosResult.error(AxiosStatus.PASSWORD_NOT_SURE);
        }
        return AxiosResult.success(user);
    }
}
