package com.ruoyi.info.service;

import java.util.List;
import com.ruoyi.info.domain.PmsProductAttributeValue;

/**
 * 商品属性值Service接口
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public interface IPmsProductAttributeValueService 
{
    /**
     * 查询商品属性值
     * 
     * @param id 商品属性值主键
     * @return 商品属性值
     */
    public PmsProductAttributeValue selectPmsProductAttributeValueById(Long id);

    /**
     * 查询商品属性值列表
     * 
     * @param pmsProductAttributeValue 商品属性值
     * @return 商品属性值集合
     */
    public List<PmsProductAttributeValue> selectPmsProductAttributeValueList(PmsProductAttributeValue pmsProductAttributeValue);

    /**
     * 新增商品属性值
     * 
     * @param pmsProductAttributeValue 商品属性值
     * @return 结果
     */
    public int insertPmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue);

    /**
     * 修改商品属性值
     * 
     * @param pmsProductAttributeValue 商品属性值
     * @return 结果
     */
    public int updatePmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue);

    /**
     * 批量删除商品属性值
     * 
     * @param ids 需要删除的商品属性值主键集合
     * @return 结果
     */
    public int deletePmsProductAttributeValueByIds(Long[] ids);

    /**
     * 删除商品属性值信息
     * 
     * @param id 商品属性值主键
     * @return 结果
     */
    public int deletePmsProductAttributeValueById(Long id);
}
