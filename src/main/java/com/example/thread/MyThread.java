package com.example.thread;

import com.example.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shRstart on 2020/4/24.
 */
public class MyThread implements Runnable {

@Autowired
    InformationService informationService;

    @Override
    public void run() {
    }
}
