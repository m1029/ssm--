package com.msh.www.service;

import com.msh.www.entity.SysLoginLog;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统访问记录 服务类
 * </p>
 *
 * @author msh
 * @since 2020-10-29
 */
@Service
public interface ISysLoginLogService {


    void add(SysLoginLog sysLoginLog);
}
