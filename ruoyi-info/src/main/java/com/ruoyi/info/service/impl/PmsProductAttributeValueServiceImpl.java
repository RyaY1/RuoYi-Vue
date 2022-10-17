package com.ruoyi.info.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.info.mapper.PmsProductAttributeValueMapper;
import com.ruoyi.info.domain.PmsProductAttributeValue;
import com.ruoyi.info.service.IPmsProductAttributeValueService;

/**
 * 商品属性值Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@Service
public class PmsProductAttributeValueServiceImpl implements IPmsProductAttributeValueService 
{
    @Autowired
    private PmsProductAttributeValueMapper pmsProductAttributeValueMapper;

    /**
     * 查询商品属性值
     * 
     * @param id 商品属性值主键
     * @return 商品属性值
     */
    @Override
    public PmsProductAttributeValue selectPmsProductAttributeValueById(Long id)
    {
        return pmsProductAttributeValueMapper.selectPmsProductAttributeValueById(id);
    }

    /**
     * 查询商品属性值列表
     * 
     * @param pmsProductAttributeValue 商品属性值
     * @return 商品属性值
     */
    @Override
    public List<PmsProductAttributeValue> selectPmsProductAttributeValueList(PmsProductAttributeValue pmsProductAttributeValue)
    {
        return pmsProductAttributeValueMapper.selectPmsProductAttributeValueList(pmsProductAttributeValue);
    }

    /**
     * 新增商品属性值
     * 
     * @param pmsProductAttributeValue 商品属性值
     * @return 结果
     */
    @Override
    public int insertPmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue)
    {
        return pmsProductAttributeValueMapper.insertPmsProductAttributeValue(pmsProductAttributeValue);
    }

    /**
     * 修改商品属性值
     * 
     * @param pmsProductAttributeValue 商品属性值
     * @return 结果
     */
    @Override
    public int updatePmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue)
    {
        return pmsProductAttributeValueMapper.updatePmsProductAttributeValue(pmsProductAttributeValue);
    }

    /**
     * 批量删除商品属性值
     * 
     * @param ids 需要删除的商品属性值主键
     * @return 结果
     */
    @Override
    public int deletePmsProductAttributeValueByIds(Long[] ids)
    {
        return pmsProductAttributeValueMapper.deletePmsProductAttributeValueByIds(ids);
    }

    /**
     * 删除商品属性值信息
     * 
     * @param id 商品属性值主键
     * @return 结果
     */
    @Override
    public int deletePmsProductAttributeValueById(Long id)
    {
        return pmsProductAttributeValueMapper.deletePmsProductAttributeValueById(id);
    }
}
