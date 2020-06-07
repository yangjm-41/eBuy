package com.qy.msg.client.rpc;

import com.qy.base.controller.MyResult;
import com.qy.msg.client.fallback.IMssageRpcFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "ebuy-msg", fallbackFactory = IMssageRpcFallback.class)
public interface IMessageRpc {

   @RequestMapping(value = "/message/test", method = {RequestMethod.POST})
    MyResult test(String hello);



}
