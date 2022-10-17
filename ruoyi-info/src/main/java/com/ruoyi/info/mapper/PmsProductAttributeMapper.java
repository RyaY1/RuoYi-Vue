package com.ruoyi.info.mapper;

import java.util.List;
import com.ruoyi.info.domain.PmsProductAttribute;

/**
 * 商品属性Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public interface PmsProductAttributeMapper 
{
    /**
     * 查询商品属性
     * 
     * @param id 商品属性主键
     * @return 商品属性
     */
    public PmsProductAttribute selectPmsProductAttributeById(Long id);

    /**
     * 查询商品属性列表
     * 
     * @param pmsProductAttribute 商品属性
     * @return 商品属性集合
     */
    public List<PmsProductAttribute> selectPmsProductAttributeList(PmsProductAttribute pmsProductAttribute);

    /**
     * 新增商品属性
     * 
     * @param pmsProductAttribute 商品属性
     * @return 结果
     */
    public int insertPmsProductAttribute(PmsProductAttribute pmsProductAttribute);

    /**
     * 修改商品属性
     * 
     * @param pmsProductAttribute 商品属性
     * @return 结果
     */
    public int updatePmsProductAttribute(PmsProductAttribute pmsProductAttribute);

    /**
     * 删除商品属性
     * 
     * @param id 商品属性主键
     * @return 结果
     */
    public int deletePmsProductAttributeById(Long id);

    /**
     * 批量删除商品属性
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsProductAttributeByIds(Long[] ids);
}
