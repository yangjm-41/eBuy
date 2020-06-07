package com.qy.msg.server.config;

import com.qy.base.comm.HeadersValueConst;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 覆盖 RequestResponseBodyMethodProcessor supportsParameter 方法使含有FeignClient接口的方法都使用
 * RequestResponseBodyMethodProcessor 的方式解析请求 从而接口可以去除@requestBody

 **/
public class MyRequestResponseBodyMethodProcessor extends RequestResponseBodyMethodProcessor {

    public MyRequestResponseBodyMethodProcessor(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String contentType = request.getContentType();
        if(contentType != null && contentType.contains(HeadersValueConst.APPLICATION_JSON)){
            if(AnnotatedElementUtils.hasAnnotation(parameter.getContainingClass(), FeignClient.class)){
                return true;
            }
        }
        return super.supportsParameter(parameter);
    }
    /**由于底层会对请求方法进行缓存{@link org.springframework.web.method.support.HandlerMethodArgumentResolverComposite}，会出现不同方式请求表单/json进入请求
     在解析时重新判断是否请求为josn（fegin 发起 使用RequestResponseBodyMethodProcessor解析） 不是，则使用 ServletModelAttributeMethodProcessor 处理请求
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        boolean jsonRquest = supportsParameter(parameter);
         if( jsonRquest == false){
             ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor = RequestMappingHandlerAdapterUtils.getServletModelAttributeMethodProcessor();
             return servletModelAttributeMethodProcessor.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
        }
        return super.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
    }
}
