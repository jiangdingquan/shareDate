package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.Dto.InformationDto;
import com.example.Repository.InformationRepository;
import com.example.thread.MyThread;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author shRstart
 * @date 2020/4/23
 */

@Service
@Scope("prototype")
@Lazy(false)
public class InformationService {
    @Autowired
    RedisTemplate<String, String> redisTemplate;


    @Autowired
    InformationRepository informationRepository;
    /**
     * 数据量：每500毫秒产生2w条布尔类型数据；
     *
     * @return
     */
    public void delayFlag() {
        while (true) {
            for (int i = 0; i < 20000; i++) {
                redisTemplate.opsForList().rightPush("testFlag", String.valueOf(new Random().nextBoolean()));
            }

            //类似于500ms20000条数据
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}
    public void insertInformation(){
        List<InformationDto> informations =new ArrayList<>();

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while(true){

            String testFlag = (String) redisTemplate.opsForList().leftPop("testFlag");
            //如果redis有testFlag数据的话直接数据整合， 如果没有数据递归调用自己
            if(StringUtils.isEmpty(testFlag)){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                insertInformation();
            }else{
                //对象转化为json格式
                InformationDto information = new InformationDto(null, UUID.randomUUID().toString().substring(0, 7), sdf.format(new Date()), Boolean.parseBoolean(testFlag));
                String info = JSON.toJSONString(information);

                redisTemplate.opsForList().rightPush("testInfo",  info);

            }
        }




    }

    /**
     * 数据固化
     */
    public void dataSolidification() {
       while (true){
                String testInfo = redisTemplate.opsForList().rightPop("testInfo");
                if(StringUtils.isEmpty(testInfo)){

                    //使用递归方式可能会OOM
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dataSolidification();
                }else{
                    InformationDto informationDto = JSON.parseObject(testInfo, InformationDto.class);
                    informationRepository.save(informationDto);

                }


       }
    }





    public void insertBathFlag(){
        //线程池方式  多线程进行 固化  springdateJPA
        ExecutorService pool = new ThreadPoolExecutor(6, 12, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.DiscardPolicy());
        pool.execute(new MyThread());

    }





}
