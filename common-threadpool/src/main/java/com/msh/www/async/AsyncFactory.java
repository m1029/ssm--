package com.msh.www.async;

import com.msh.www.email.EmailService;
import com.msh.www.spring.SpringUtils;

/**
 * 异步任务生产工厂  加载发送邮件的类
 */
public class AsyncFactory {


    public static Runnable executeEmail(String to,String message){
        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                SpringUtils.getBean(EmailService.class).sendMail(to,message);
            }
        };
        return runnable;
    }
}
