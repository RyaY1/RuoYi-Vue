package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.WxLoginBody;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.ip.IpUtils;
import com.ruoyi.common.utils.wechat.WechatUtils;
import com.ruoyi.system.domain.SysWechatUser;
import com.ruoyi.system.service.ISysWechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 微信登陆
 * @author yilei
 */
@RestController
@RequestMapping("/wechat")
public class SysWxLoginController {



    @Autowired
    private ISysWechatUserService wechatUserService;

    @PostMapping("/getOpenId")
    public AjaxResult getOpenId(@RequestBody WxLoginBody wxLoginBody){
        String code = wxLoginBody.getCode();
        if(StringUtils.isEmpty(code)){
            return AjaxResult.error("code不能为空!");
        }
        String openId = WechatUtils.getOpenId(code);
        SysWechatUser wechatUser = wechatUserService.selectSysWechatUserByOpenId(openId);
        SysWechatUser sysWechatUser = new SysWechatUser();
        sysWechatUser.setOpenId(openId);
        String ipAddr = IpUtils.getIpAddr(ServletUtils.getRequest());
        sysWechatUser.setLoginDate(new Date());
        sysWechatUser.setLoginIp(ipAddr);
        if(wechatUser != null){
            return AjaxResult.success(sysWechatUser);
        }
        wechatUserService.insertSysWechatUser(sysWechatUser);
        return AjaxResult.success(sysWechatUser);
    }

    @PostMapping("/login")
    public AjaxResult login(@RequestBody WxLoginBody wxLoginBody){
        String openId = wxLoginBody.getOpenId();
        SysWechatUser sysWechatUser = new SysWechatUser();
        BeanUtils.copyBeanProp(sysWechatUser,wxLoginBody);
        String ipAddr = IpUtils.getIpAddr(ServletUtils.getRequest());
        sysWechatUser.setLoginDate(new Date());
        sysWechatUser.setLoginIp(ipAddr);
        SysWechatUser wechatUser = wechatUserService.selectSysWechatUserByOpenId(openId);
        if(wechatUser != null){
            wechatUserService.updateSysWechatUser(sysWechatUser);
        }else {
            wechatUserService.insertSysWechatUser(sysWechatUser);
        }
        return AjaxResult.success(sysWechatUser);
    }
}
