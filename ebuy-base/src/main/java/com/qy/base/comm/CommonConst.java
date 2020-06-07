package com.qy.base.comm;

import com.qy.base.exception.ParamException;
import com.qy.base.util.CommonRedisKey;

/**
 * @Author: ebuy
 * @Describe: 通用常量配置
 * @Date: Create in 16:20 2019/9/24
 */
public class CommonConst {


    private CommonConst() {

    }


    /**
     * ================发送短信类型===================
     **/
    /**
     * 登录用验证码
     */
    public static final int LOGIN = 1;
    /**
     * 修改用验证码
     */
    public static final int MODIFY = 2;
    /**
     * 绑定手机号用验证码
     */
    public static final int BIND = 3;


    /**
     * 设置支付密码用验证码
     */
    public static final int SET_PAY_PASSWORD = 4;
    /**
     * 修改密码用验证码
     */
    public static final int MODIFY_PASSWORD = 5;

    /**
     * 注册用验证码
     */
    public static final int REGISTER = 6;

    /**
     * 注册登陆同时存在使用类型
     */
    public static final int REGISTER_AND_LOGIN = 7;

    /**
     * 微信假登录绑定手机号
     */
    public static final int WX_FACKLOGIG = 8;

    public static final int ACTIVE_TICKET=9;

    /**
     * ================发送短信类型 end===================
     **/


    public static final String PLATFORM = "common";

    /**
     * ================请求头常量===================
     **/
    public static final String PLATFORMHEARD = "X-Litemall-IdentiFication";

    public static final String PLATFORMHEARD2 = "platform";

    public static final String TOKEN = "token";

    public static final String TOKEN2 = "X-Litemall-Admin-Token";
    /**================请求头常量end===================**/


    /**
     * admin 常量
     */
    public static final String ADMIN = "admin";

    /**
     * unknown 未知参数内容填充,创建者名称等
     */
    public static final String UNKNOWN = "unknown";


    /**
     * 接口安全检查常量时间
     */
    public static final String TIMESTAMP = "Timestamp";


    /**
     * 接口安全检查常量时间
     */
    public static final String SIGN = "Sign";

    /**
     * 查询platform 常量
     */
    public static final String QUERY_PLATFORM = "platform";


    public static CommonRedisKey validateType(Integer type) {
        CommonRedisKey redisPreKey;

        if (type == CommonConst.LOGIN) {
            redisPreKey = CommonRedisKey.LOGIN;
        } else if (type == CommonConst.MODIFY) {
            redisPreKey = CommonRedisKey.MODIFY;
        } else if (type == CommonConst.BIND) {
            redisPreKey = CommonRedisKey.BIND;
        } else if (type == CommonConst.SET_PAY_PASSWORD) {
            redisPreKey = CommonRedisKey.SET_PAY_PASSWORD;
        } else if (type == CommonConst.MODIFY_PASSWORD) {
            redisPreKey = CommonRedisKey.MODIFY_PASSWORD;
        } else if (type == CommonConst.REGISTER) {
            redisPreKey = CommonRedisKey.REGISTER;
        } else if (type == CommonConst.REGISTER_AND_LOGIN) {
            redisPreKey = CommonRedisKey.REGISTER_AND_LOGIN;
        } else if (type == CommonConst.WX_FACKLOGIG) {
            redisPreKey = CommonRedisKey.WX_FACK_LOGIN_BIND_SMS;
        }else if(type== CommonConst.ACTIVE_TICKET){
            redisPreKey=CommonRedisKey.ACTIVE_TICKET;
        }
        else {
            throw new ParamException(ResponseCode.INVALID_PARAMETER.getMsg());
        }

        return redisPreKey;

    }

    /**
     * 校验短信发送类型是否是绑定手机号的类型
     *
     * @param type
     * @return
     */
    public static boolean isBindMobileType(Integer type) {
        if (type == MODIFY) {
            return true;
        }
        if (type == BIND) {
            return true;
        }
        if (type == WX_FACKLOGIG){
            return true;
        }
        return false;
    }
}
