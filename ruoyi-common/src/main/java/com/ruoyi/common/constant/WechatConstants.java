package com.ruoyi.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author yilei
 * 微信服务端常量
 */
@Component
@PropertySource("classpath:wechat-env.properties")
public class WechatConstants {
    @Value("${appId}")
    private String appId;
    @Value("${appSecret}")
    private String appSecret;
    @Value("${accessToken}")
    private String accessToken;
    @Value("${code2Session}")
    private String code2Session;
    @Value("${tokenOverTime}")
    private Integer tokenOverTime;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getCode2Session() {
        return code2Session;
    }

    public void setCode2Session(String code2Session) {
        this.code2Session = code2Session;
    }

    public Integer getTokenOverTime() {
        return tokenOverTime;
    }

    public void setTokenOverTime(Integer tokenOverTime) {
        this.tokenOverTime = tokenOverTime;
    }
}
