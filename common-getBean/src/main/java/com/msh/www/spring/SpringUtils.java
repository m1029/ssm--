package com.msh.www.spring;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 从容器当中取bean
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    /**
     * 只要容器启动会自动使用这个函数
     * @param applicationContext
     * @throws BeansException
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        SpringUtils.applicationContext =applicationContext;
    }

    /**
     * 使用通配符 让其他的类取调用这个方法 获取到这个spring容器当中的类
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
}
