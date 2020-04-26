package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shRstart on 2020/4/23.
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Timer：是一个定时器工具，用来执行指定任务
         * TimerTask：是一个抽象类，他的子类可以代表一个被Timer计划的任务
         */
        long L1 = System.currentTimeMillis();
        List<Integer> list =new ArrayList<>();
        for(int i=0;i<20000;i++){
        list.add(i);
            System.out.println(i);
        }
        long L2 = System.currentTimeMillis();
        System.out.println(list.size());
        System.out.println(L2-L1);

    }
}
