package com.qy.msg.server.service;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;


@Service
@Slf4j
@Transactional
public class MessageService {


    /**
     * 循环发送信息线程池
     **/
    private static final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10,
            new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());


    /**
     * 循环更新线程池
     **/
    private static final ScheduledExecutorService updateexecutorService = new ScheduledThreadPoolExecutor(10,
            new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());


    public void addReadNumber(String id) {
        updateexecutorService.execute(() -> {
            try {

                Thread.sleep(1000);

                log.info("hello world");
            } catch (Exception e) {
                log.info("hello world2222");
            }

            //通知
        });

    }
}
