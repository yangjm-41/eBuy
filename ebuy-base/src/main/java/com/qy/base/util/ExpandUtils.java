package com.qy.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

 /*
 * @Description  扩展字段操作工具类,扩展字段只开放新增禁止新值替换旧值
 * @Date 18:55 2020/3/26
 * @Param
 * @return
 **/
@Slf4j
public class ExpandUtils {

    /**
     * @Description 检查扩展内容是否正确
     * @Date 14:06 2020/3/27
     * @Param [expand]
     * @return java.lang.String
     **/
    public static boolean checkExpand(String  expand){
        try {
            JSONObject jsonObject = JSON.parseObject(expand);
            return true;
        }catch (Exception e){
            log.error("解析expand错误"+e.getMessage());
            return false;
        }
    }


    /**
     * @Description  更新扩展字段，新扩展包含旧的key值则覆盖，不包含则保留旧的key
     * @Date 14:48 2019/11/25
     * @param oldExpand  更新前对象旧扩展json
     * @param newExpand  准备更新扩展新json
     * @return 组装好的json
     **/
    public static String replaceExpand(String  oldExpand, String  newExpand){
        JSONObject comnoExpand = new JSONObject();
        //旧json
        comonPoJson(comnoExpand,oldExpand);
        //新json
        comonPoJson(comnoExpand,newExpand);
        oldExpand = comnoExpand.toJSONString();
        return oldExpand;
    }


    private static JSONObject comonPoJson(JSONObject jsonObject , String  expand){
        try {
            JSONObject newObject = JSON.parseObject(expand);
            if(newObject != null){
                Set<String> newKey = newObject.keySet();
                newKey.forEach(e -> {
                    jsonObject.put(e,newObject.get(e));
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

}
