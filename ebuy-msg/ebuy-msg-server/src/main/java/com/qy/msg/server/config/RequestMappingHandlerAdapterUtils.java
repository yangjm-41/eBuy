package com.qy.msg.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * created by Tang  on 2019/11/22
 */
@Component
public class RequestMappingHandlerAdapterUtils {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    public  static  RequestMappingHandlerAdapter staticRequestMappingHandlerAdapter;

    @PostConstruct
    void init(){
        staticRequestMappingHandlerAdapter = requestMappingHandlerAdapter;
    }


    public  static  ServletModelAttributeMethodProcessor getServletModelAttributeMethodProcessor(){
        List<HandlerMethodArgumentResolver> argumentResolvers = staticRequestMappingHandlerAdapter.getArgumentResolvers();
        for(HandlerMethodArgumentResolver handlerMethodArgumentResolver : argumentResolvers){
            if( handlerMethodArgumentResolver instanceof  ServletModelAttributeMethodProcessor) {
                return (ServletModelAttributeMethodProcessor)handlerMethodArgumentResolver;
            }
        }
        return null;
    }

}
