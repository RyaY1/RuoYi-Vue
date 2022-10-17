package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 微信用户对象 sys_wechat_user
 *
 * @author ruoyi
 * @date 2022-01-10
 */
public class SysWechatUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private String openId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String avatar;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 登陆ip */
    @Excel(name = "登陆ip")
    private String loginIp;

    /** 最后登陆时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后登陆时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loginDate;

    public void setOpenId(String openId)
    {
        this.openId = openId;
    }

    public String getOpenId()
    {
        return openId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getNickName()
    {
        return nickName;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }
    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public String getLoginIp()
    {
        return loginIp;
    }
    public void setLoginDate(Date loginDate)
    {
        this.loginDate = loginDate;
    }

    public Date getLoginDate()
    {
        return loginDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("openId", getOpenId())
                .append("userName", getUserName())
                .append("nickName", getNickName())
                .append("email", getEmail())
                .append("avatar", getAvatar())
                .append("sex", getSex())
                .append("phonenumber", getPhonenumber())
                .append("loginIp", getLoginIp())
                .append("loginDate", getLoginDate())
                .append("remark", getRemark())
                .toString();
    }
}
