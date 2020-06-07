package com.qy.msg.server.controller;

import com.qy.base.controller.MyResult;
import com.qy.msg.client.rpc.IMessageRpc;
import com.qy.msg.server.service.MessageService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.qy.base.util.CheckUtil.check;


@Slf4j
@RestController
public class MessageController implements IMessageRpc {



    @Autowired
    private MessageService service;


    @Override
    public MyResult test(String o) {
        System.out.println("微服务接收到：" + o);
        log.info(o);
        service.addReadNumber("1");
        return new MyResult().ok("hello  rpc");
    }


}
