package com.example.demo;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadExtend_Pool_Custom extends Thread {
    private String name;//线程的名字
    public ThreadExtend_Pool_Custom(String name){
        this.name=name;
    }
    @Override
    public void run(){
        long L1 = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
                System.out.println(i+"--"+Thread.currentThread().getName());

            }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long L2 = System.currentTimeMillis();
        System.out.println(L2-L1);
    }

    public static void main(String args[]){

        //创建等待队列
        BlockingQueue<Runnable> blockingQueue=new ArrayBlockingQueue<Runnable>(20);

        /**
         * 创建一个单线执行任务，它可安排在给定延迟后运行命令或者定期地执行
         * corePoolSize -池中所保存的线程数，包括空闲线程
         * maximumPoolSize -池中允许的最大线程数
         * keepAliveTime -当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间
         * unit -keepAliveTime参数的时间单位
         * orkQueue -执行前用于保持任务的队列。此队列仅保持由execute方法提交的Runnable任务
         */
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5,10,3, TimeUnit.MILLISECONDS,blockingQueue);

        Thread thread1=new ThreadExtend_Pool_Custom("Thread-1");
        Thread thread2=new ThreadExtend_Pool_Custom("Thread-2");
        Thread thread3=new ThreadExtend_Pool_Custom("Thread-3");
        Thread thread4=new ThreadExtend_Pool_Custom("Thread-4");
        Thread thread5=new ThreadExtend_Pool_Custom("Thread-5");

        //将线程放入线程池当中进行执行
        threadPoolExecutor.execute(thread1);
        threadPoolExecutor.execute(thread2);
        threadPoolExecutor.execute(thread3);

        //使用延迟执行的风格的方法
        threadPoolExecutor.execute(thread4);
        threadPoolExecutor.execute(thread5);

        //关闭线程池子
        threadPoolExecutor.shutdown();
    }
}