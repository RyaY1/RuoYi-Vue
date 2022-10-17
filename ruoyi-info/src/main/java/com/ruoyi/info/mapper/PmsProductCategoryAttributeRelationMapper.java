package com.ruoyi.info.mapper;

import java.util.List;
import com.ruoyi.info.domain.PmsProductCategoryAttributeRelation;

/**
 * 商品分类和属性关系Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public interface PmsProductCategoryAttributeRelationMapper 
{
    /**
     * 查询商品分类和属性关系
     * 
     * @param id 商品分类和属性关系主键
     * @return 商品分类和属性关系
     */
    public PmsProductCategoryAttributeRelation selectPmsProductCategoryAttributeRelationById(Long id);

    /**
     * 查询商品分类和属性关系列表
     * 
     * @param pmsProductCategoryAttributeRelation 商品分类和属性关系
     * @return 商品分类和属性关系集合
     */
    public List<PmsProductCategoryAttributeRelation> selectPmsProductCategoryAttributeRelationList(PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation);

    /**
     * 新增商品分类和属性关系
     * 
     * @param pmsProductCategoryAttributeRelation 商品分类和属性关系
     * @return 结果
     */
    public int insertPmsProductCategoryAttributeRelation(PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation);

    /**
     * 修改商品分类和属性关系
     * 
     * @param pmsProductCategoryAttributeRelation 商品分类和属性关系
     * @return 结果
     */
    public int updatePmsProductCategoryAttributeRelation(PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation);

    /**
     * 删除商品分类和属性关系
     * 
     * @param id 商品分类和属性关系主键
     * @return 结果
     */
    public int deletePmsProductCategoryAttributeRelationById(Long id);

    /**
     * 批量删除商品分类和属性关系
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsProductCategoryAttributeRelationByIds(Long[] ids);
}
