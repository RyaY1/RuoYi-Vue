package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysWechatUser;

/**
 * 微信用户Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-10
 */
public interface SysWechatUserMapper
{
    /**
     * 查询微信用户
     *
     * @param openId 微信用户主键
     * @return 微信用户
     */
    public SysWechatUser selectSysWechatUserByOpenId(String openId);

    /**
     * 查询微信用户列表
     *
     * @param sysWechatUser 微信用户
     * @return 微信用户集合
     */
    public List<SysWechatUser> selectSysWechatUserList(SysWechatUser sysWechatUser);

    /**
     * 新增微信用户
     *
     * @param sysWechatUser 微信用户
     * @return 结果
     */
    public int insertSysWechatUser(SysWechatUser sysWechatUser);

    /**
     * 修改微信用户
     *
     * @param sysWechatUser 微信用户
     * @return 结果
     */
    public int updateSysWechatUser(SysWechatUser sysWechatUser);

    /**
     * 删除微信用户
     *
     * @param openId 微信用户主键
     * @return 结果
     */
    public int deleteSysWechatUserByOpenId(String openId);

    /**
     * 批量删除微信用户
     *
     * @param openIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysWechatUserByOpenIds(String[] openIds);
}
