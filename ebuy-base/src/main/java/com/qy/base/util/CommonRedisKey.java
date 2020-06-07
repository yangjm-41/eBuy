package com.qy.base.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: ebuy
 * @Describe: 通用redisKey
 * @Date: Create in 11:26 2019/10/8
 */
public enum CommonRedisKey {

    //
    WX_HOME(":wx:index:", 60L), // 首页数据，首页由于需要细化每一个部分的查询，使用 下面的 WX_HOME_XX来代替首页的查询请求
    WX_HOME_BANNER(":wx:index:banner:", 60L), // 首页ad数据
    WX_HOME_CATEGORY(":wx:index:category:", 60L), // 首页分类数据
    WX_HOME_COUPON(":wx:index:coupon:", 60L), // 首页优惠券数据
    WX_HOME_NEWGOODS(":wx:index:newgoods:", 60L), // 首页新商品数据
    WX_HOME_HOTGOODS(":wx:index:hotgoods:", 60L), // 首页热门商品数据
    WX_HOME_BRAND(":wx:index:brand:", 60L), // 首页品牌数据
    PC_HOME(":pc:index:", 60L), // pc首页数据
    WX_CATALOG(":wx:catalog:", 60L), // 分类
    ZFB_TREE_NAME_CER(":zfb:tree_name:cer:", 15 * 60L), // 支付宝实名认证,15分钟过期
    //
    LOGIN(":code:login:", 30 * 60L), // 登陆用验证码
    LOGIN_TOKEN(":token:login:", 0L), // 登陆用验证码
    BIND(":code:bind:", 60 * 5L), // 绑定手机号用验证码
    MODIFY(":code:modify:", 30 * 60L), // 修改用验证码
    SET_PAY_PASSWORD(":code:pay_password:", 30 * 60L), // 设置支付密码用验证码
    MODIFY_PASSWORD(":code:modify_password:", 30 * 60L),//修改密码用验证码
    SMS_REQUEST_RATIO(":code:ratio:", 120L), // 短信发送频率
    SHIP_INFO(":ship:", 60L * 60 * 2), // 物流信息，2小时缓存
    REGISTER(":code:register", 60 * 5L),//注册用验证码
    REGISTER_AND_LOGIN(":code:registerAndLogin", 60 * 5L),//注册登陆同一验证码
    WX_FACK_LOGIN_BIND_SMS(":code:wxfackelogin:", 60 * 5L),//微信假登录绑定手机号验证码

    // 商品详情
    GOODS_DETAIL_COMMENT(":goods:comment:", 60L),// 商品详情评论，1分钟缓存
    GOODS_DETAIL_COMMENT_TAG(":goods:comment:tag:", 60L),// 商品详情评论标签，1分钟缓存

    GOODS_SECKILL(":seckill:product:", 0L), // 秒杀商品
    GOODS_SECKILL_BUY_LIMIT(":seckill:buy:", 0L), // 秒杀商品一次购买数量限制
    GOODS_SECKILL_OVER(":seckill:over:", 0L), // 秒杀是否结束
    GOODS_SECKILL_MESSAGE(":seckill:message:", 10L * 60), // 秒杀消息 10分钟
    GOODS_SECKILL_SUBMIT_MESSAGE(":seckill:submit:", 10L * 60), // 秒杀订单提交消息 10分钟
    GOODS_SECKILL_USER_LIMIT(":seckill:limit:", 30L), // 秒杀用户限流，30秒
    GOODS_SECKILL_ORDER_LIMIT(":seckill:order:", 10L * 60), // 秒杀是否已经达到限制购买数量,10分钟

    INTEGRAL_GOODS_MESSAGE(":integral:message:", 10L * 60), // 积分兑换商品结算消息 10分钟
    INTEGRAL_GOODS_SUBMIT_MESSAGE(":integral:submit:", 10L * 60), // 积分兑换商品订单提交消息 10分钟

    USER_LOGIN_FAIL(":user:login:fail:", 10L * 60), // 用户登录失败记录次数
    IP_LOGIN_FAIL(":ip:login:fail:", 20L * 60), // ip登录失败记录次数

    RED_PACKAGE(":redpackage:", 60L * 60 * 24), // 红包缓存，默认一天时间

    VIDEO_USER_INFO(":video:user:", 60L * 60 * 24), // 视频/名片/动态用户头像，昵称缓存，默认一天时间
    WX_FACK_LOGIN(":wxfackerlogin:", 60L * 60), //假登录缓存微信数据，默认一小时

    ACTIVE_TICKET(":activeticket:",5L*60),//激活验证
    ;
    /**
     * 超时时间，单位秒
     */
    private Long timeout;

    String key;

    CommonRedisKey(String key, Long timeout) {
        this.timeout = timeout;
        this.key = key;
    }

    public String getKey(String platform) {
        return getKey(platform, "");
    }

    public String getKey(String platform, String suff) {
        if (StringUtils.isNotBlank(suff)) {
            return platform + key + suff;
        }
        return platform + key;
    }

    public String getKey(String platform, String... suff) {
        StringBuilder builder = new StringBuilder();
        builder.append(platform).append(key);
        platform = platform + key;
        for (int i = 0; i < suff.length; i++) {
            builder.append(suff);
        }
        return builder.toString();
    }


    public Long getTimeout() {
        return timeout;
    }

}
