package com.msh.www.service.impl;

import com.msh.www.entity.SysLoginLog;
import com.msh.www.mapper.SysLoginLogMapper;
import com.msh.www.service.ISysLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 系统访问记录 服务实现类
 * </p>
 *
 * @author msh
 * @since 2020-10-29
 */
@Service
public class SysLoginLogServiceImpl implements ISysLoginLogService {

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    @Override
    public void add(SysLoginLog sysLoginLog) {

        sysLoginLogMapper.insert(sysLoginLog);
    }
}
