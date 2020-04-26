package com.example.demo;

import com.example.Dto.InformationDto;
import com.example.Repository.InformationRepository;
import com.example.service.InformationService;
import com.example.task.AsyncTask;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@SpringBootTest

class DemoApplicationTests {


    @Autowired
    InformationService informationService;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AsyncTask asyncTask;


    @Autowired
    private InformationRepository  informationRepository;


    /**
     * 生成flag数据测试
     */
    @Test
    public void tesetDelayFlag(){
        informationService.delayFlag();
    }

    /**
     * 生成testInfo数据
     */
    @Test
    public void testinsertInformation(){

        informationService.insertInformation();
    }

    /**
     * 数据固化
     */
    @Test
     public void contextLoads() {
        informationService.dataSolidification();


    }




    @Test
    public void testInsertInformationRepository(){
//    InformationDto student = new InformationDto(null,"张三丰",null,true);
//    informationRepository.save(student);

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String format = sdf.format(new Date());
        InformationDto  informationDto =new InformationDto(null,"123",format,true);

        informationRepository.save(informationDto);
    }
}
