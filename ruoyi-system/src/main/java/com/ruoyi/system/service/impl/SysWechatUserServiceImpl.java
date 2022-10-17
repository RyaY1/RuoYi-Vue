package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysWechatUserMapper;
import com.ruoyi.system.domain.SysWechatUser;
import com.ruoyi.system.service.ISysWechatUserService;

/**
 * 微信用户Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-10
 */
@Service
public class SysWechatUserServiceImpl implements ISysWechatUserService
{
    @Autowired
    private SysWechatUserMapper sysWechatUserMapper;

    /**
     * 查询微信用户
     *
     * @param openId 微信用户主键
     * @return 微信用户
     */
    @Override
    public SysWechatUser selectSysWechatUserByOpenId(String openId)
    {
        return sysWechatUserMapper.selectSysWechatUserByOpenId(openId);
    }

    /**
     * 查询微信用户列表
     *
     * @param sysWechatUser 微信用户
     * @return 微信用户
     */
    @Override
    public List<SysWechatUser> selectSysWechatUserList(SysWechatUser sysWechatUser)
    {
        return sysWechatUserMapper.selectSysWechatUserList(sysWechatUser);
    }

    /**
     * 新增微信用户
     *
     * @param sysWechatUser 微信用户
     * @return 结果
     */
    @Override
    public int insertSysWechatUser(SysWechatUser sysWechatUser)
    {
        return sysWechatUserMapper.insertSysWechatUser(sysWechatUser);
    }

    /**
     * 修改微信用户
     *
     * @param sysWechatUser 微信用户
     * @return 结果
     */
    @Override
    public int updateSysWechatUser(SysWechatUser sysWechatUser)
    {
        return sysWechatUserMapper.updateSysWechatUser(sysWechatUser);
    }

    /**
     * 批量删除微信用户
     *
     * @param openIds 需要删除的微信用户主键
     * @return 结果
     */
    @Override
    public int deleteSysWechatUserByOpenIds(String[] openIds)
    {
        return sysWechatUserMapper.deleteSysWechatUserByOpenIds(openIds);
    }

    /**
     * 删除微信用户信息
     *
     * @param openId 微信用户主键
     * @return 结果
     */
    @Override
    public int deleteSysWechatUserByOpenId(String openId)
    {
        return sysWechatUserMapper.deleteSysWechatUserByOpenId(openId);
    }
}
