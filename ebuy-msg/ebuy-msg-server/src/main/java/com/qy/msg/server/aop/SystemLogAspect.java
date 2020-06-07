/*
package com.qy.msg.server.aop;
import com.alibaba.fastjson.JSON;
import com.qy.msg.comm.dto.MessageDto;
import com.qy.msg.comm.enumeration.MessageEnum;
import com.qy.msg.server.code.MessageHandler;
import com.qy.base.util.HttpUtils;
import com.qy.base.util.IpUtil;
import com.qy.shiro.utils.JWTUtil;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

*/
/**
 * created by Tang  on 2019/7/30
 * <p>
 * 日志切入点
 * <p>
 * 获取当前执行的方法
 *
 * @param joinPoint  连接点
 * @param methodName 方法名称
 * @return 方法
 * <p>
 * 获取目标类的所有方法，找到当前要执行的方法
 * <p>
 * 日志切入点
 * <p>
 * 获取当前执行的方法
 * @param joinPoint  连接点
 * @param methodName 方法名称
 * @return 方法
 * <p>
 * 获取目标类的所有方法，找到当前要执行的方法
 *//*

@Aspect
@Component
public  class SystemLogAspect {


    @Autowired
    private HttpServletRequest httpRequest;

    @Autowired
    private MessageHandler messageHandler;

    StringBuffer sb = null;

    */
/**
 * 日志切入点
 *//*

    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void logPointCut(){}


    @AfterReturning(pointcut = "logPointCut()")
    public void doAfter(JoinPoint joinpoint){
        String name = joinpoint.getSignature().getName();
        Method method = currentMethod(joinpoint, name);
        ApiOperation annotation = method.getAnnotation(ApiOperation.class);
        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
        Map<String, String[]> parameterMap = httpRequest.getParameterMap();
        String apiOperationValue = annotation.value();
        String[] url = requestMapping.value();
        String ipAddr = IpUtil.getIpAddr(httpRequest);

        MessageDto messageDto = new MessageDto();

        messageDto.setType(MessageEnum.SYSTEM_LOG.getCode());
        sb = new StringBuffer();
        sb.append("ip:");
        sb.append(ipAddr);
        messageDto.setIp(ipAddr);
        sb.append("\r\n");
        sb.append("url:");
        sb.append(Arrays.toString(url));
        messageDto.setUrl(Arrays.toString(url));
        sb.append("\r\n");
        sb.append("name:");
        sb.append(JSON.toJSONString(apiOperationValue));
        messageDto.setMethodNotes(JSON.toJSONString(apiOperationValue));
        sb.append("\r\n");
        sb.append("url:");
        sb.append(Arrays.toString(url));
        messageDto.setUrl(Arrays.toString(url));
        sb.append("\r\n");
        sb.append("参数:");
        sb.append(JSON.toJSONString(parameterMap));
        messageDto.setParameter(JSON.toJSONString(parameterMap));
        sb.append("\r\n");

        String token = HttpUtils.getToken(httpRequest);
        String username = JWTUtil.getUsername(token);
        messageDto.setCreateByName(username);
        messageDto.setCreateBy(username);

        String platformheard = HttpUtils.getPlatformheard(httpRequest);
        messageDto.setPlatform(platformheard);
        messageDto.setNotest(sb.toString());
        messageHandler.setTemplate("rabbitmq");
        messageHandler.sendAndInstance(messageDto);

    }

    */
/**
 * 获取当前执行的方法
 *
 * @param joinPoint  连接点
 * @param methodName 方法名称
 * @return 方法
 *//*

    private Method currentMethod(JoinPoint joinPoint, String methodName) {
        */
/**
 * 获取目标类的所有方法，找到当前要执行的方法
 *//*

        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }



}
*/
