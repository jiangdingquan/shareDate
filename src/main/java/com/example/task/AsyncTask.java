package com.example.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by shRstart on 2020/4/25.
 */

@Component
public class AsyncTask {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     *  myTaskAsynPool即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
     */

    @Async("myTaskAsyncPool")
    public void doTask1() throws InterruptedException{


    }

}
