package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shRstart on 2020/4/23.
 */
public class Main2 {


    static Object locl =new Object();
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH-mm-ss" );
        String format = sdf.format(date);
        System.out.println(format);
    }
}
