package com.qy.msg.client.fallback;

import com.qy.base.controller.MyResult;
import com.qy.msg.client.rpc.IMessageRpc;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class IMssageRpcFallback implements FallbackFactory<IMessageRpc> {


    @Override
    public IMessageRpc create(Throwable cause) {
        return new IMessageRpc() {

            @Override
            public MyResult test(String o) {

                return new MyResult().ok("熔断");
            }


        };
    }


}


