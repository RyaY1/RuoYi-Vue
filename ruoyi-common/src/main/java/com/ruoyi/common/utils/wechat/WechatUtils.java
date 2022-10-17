package com.ruoyi.common.utils.wechat;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.WechatConstants;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


/**
 * 微信接口工具类
 * @author yilei
 */
public class WechatUtils {

    private static final Logger log = LoggerFactory.getLogger(WechatUtils.class);

    private static WechatConstants wechatConstants = SpringUtils.getBean(WechatConstants.class);
    private static RedisCache redisCache = SpringUtils.getBean(RedisCache.class);

    private static final String appId = wechatConstants.getAppId();
    private static final String secret  = wechatConstants.getAppSecret();
    public static String getAccessToken(){
        Object accessToken = redisCache.getCacheObject("accessToken");
        if(accessToken !=null){
            return accessToken.toString();
        }
        String accessTokenUrl = wechatConstants.getAccessToken();
        String result = HttpUtils.sendGet(accessTokenUrl
                +"?grant_type=client_credential&appid="+appId
                +"&secret="+secret);
        JSONObject obj = JSON.parseObject(result);
        int errCode = obj.getIntValue("errcode");
        if(errCode !=0){
            String errMsg = obj.getString("errmsg");
            throw new ServiceException(errMsg,errCode);
        }
        String token = obj.getString("access_token");
        redisCache.setCacheObject("accessToken",token,wechatConstants.getTokenOverTime(), TimeUnit.SECONDS);
        return token;
    }

    public static String getOpenId(String code){
        String code2SessionUrl = wechatConstants.getCode2Session();
        String result = HttpUtils.sendGet(code2SessionUrl+"?appid="+appId
                +"&secret="+secret
                +"&js_code="+code+"&grant_type=authorization_code");
        JSONObject obj = JSON.parseObject(result);
        int errCode = obj.getIntValue("errcode");
        if(errCode !=0){
            String errMsg = obj.getString("errmsg");
            throw new ServiceException(errMsg,errCode);
        }
        return obj.getString("openid");
    }
}
