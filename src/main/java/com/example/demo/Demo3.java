package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.Dto.InformationDto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shRstart on 2020/4/26.
 */
public class Demo3 {
    public static void main(String[] args) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH");
        InformationDto id =new InformationDto(null,"zs",sdf.format(new Date()),true);
        String s = JSON.toJSONString(id);
        System.out.println(s);
    }
}
