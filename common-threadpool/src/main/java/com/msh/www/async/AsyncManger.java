package com.msh.www.async;

import com.msh.www.spring.SpringUtils;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 全局统一异步管理器
 */
public class AsyncManger {


    private long delay =5;

    /**
     * 构造函数私有化
     */
    private AsyncManger(){}

    /**
     * 拿到容器当中的线程的类  定义一个类专门获取容器当中类
     */
    private ScheduledThreadPoolExecutor executor = SpringUtils.getBean(ScheduledThreadPoolExecutor.class);

    private static  AsyncManger asyncManger=new AsyncManger();

    public static AsyncManger getInstance(){
        return asyncManger;
    }

    public void executeTask(Runnable runnable){
        executor.schedule(runnable,delay,TimeUnit.SECONDS);
    }

    /**
     * 关闭线程池
     */
    public void close(){
        if(!executor.isShutdown()){
            executor.shutdownNow();
        }
    }
}
