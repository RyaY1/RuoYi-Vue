package com.ruoyi.info.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.info.mapper.PmsProductAttributeMapper;
import com.ruoyi.info.domain.PmsProductAttribute;
import com.ruoyi.info.service.IPmsProductAttributeService;

/**
 * 商品属性Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@Service
public class PmsProductAttributeServiceImpl implements IPmsProductAttributeService 
{
    @Autowired
    private PmsProductAttributeMapper pmsProductAttributeMapper;

    /**
     * 查询商品属性
     * 
     * @param id 商品属性主键
     * @return 商品属性
     */
    @Override
    public PmsProductAttribute selectPmsProductAttributeById(Long id)
    {
        return pmsProductAttributeMapper.selectPmsProductAttributeById(id);
    }

    /**
     * 查询商品属性列表
     * 
     * @param pmsProductAttribute 商品属性
     * @return 商品属性
     */
    @Override
    public List<PmsProductAttribute> selectPmsProductAttributeList(PmsProductAttribute pmsProductAttribute)
    {
        return pmsProductAttributeMapper.selectPmsProductAttributeList(pmsProductAttribute);
    }

    /**
     * 新增商品属性
     * 
     * @param pmsProductAttribute 商品属性
     * @return 结果
     */
    @Override
    public int insertPmsProductAttribute(PmsProductAttribute pmsProductAttribute)
    {
        return pmsProductAttributeMapper.insertPmsProductAttribute(pmsProductAttribute);
    }

    /**
     * 修改商品属性
     * 
     * @param pmsProductAttribute 商品属性
     * @return 结果
     */
    @Override
    public int updatePmsProductAttribute(PmsProductAttribute pmsProductAttribute)
    {
        return pmsProductAttributeMapper.updatePmsProductAttribute(pmsProductAttribute);
    }

    /**
     * 批量删除商品属性
     * 
     * @param ids 需要删除的商品属性主键
     * @return 结果
     */
    @Override
    public int deletePmsProductAttributeByIds(Long[] ids)
    {
        return pmsProductAttributeMapper.deletePmsProductAttributeByIds(ids);
    }

    /**
     * 删除商品属性信息
     * 
     * @param id 商品属性主键
     * @return 结果
     */
    @Override
    public int deletePmsProductAttributeById(Long id)
    {
        return pmsProductAttributeMapper.deletePmsProductAttributeById(id);
    }
}
