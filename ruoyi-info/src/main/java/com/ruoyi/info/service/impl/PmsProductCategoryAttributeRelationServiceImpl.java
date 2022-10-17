package com.ruoyi.info.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.info.mapper.PmsProductCategoryAttributeRelationMapper;
import com.ruoyi.info.domain.PmsProductCategoryAttributeRelation;
import com.ruoyi.info.service.IPmsProductCategoryAttributeRelationService;

/**
 * 商品分类和属性关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@Service
public class PmsProductCategoryAttributeRelationServiceImpl implements IPmsProductCategoryAttributeRelationService 
{
    @Autowired
    private PmsProductCategoryAttributeRelationMapper pmsProductCategoryAttributeRelationMapper;

    /**
     * 查询商品分类和属性关系
     * 
     * @param id 商品分类和属性关系主键
     * @return 商品分类和属性关系
     */
    @Override
    public PmsProductCategoryAttributeRelation selectPmsProductCategoryAttributeRelationById(Long id)
    {
        return pmsProductCategoryAttributeRelationMapper.selectPmsProductCategoryAttributeRelationById(id);
    }

    /**
     * 查询商品分类和属性关系列表
     * 
     * @param pmsProductCategoryAttributeRelation 商品分类和属性关系
     * @return 商品分类和属性关系
     */
    @Override
    public List<PmsProductCategoryAttributeRelation> selectPmsProductCategoryAttributeRelationList(PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation)
    {
        return pmsProductCategoryAttributeRelationMapper.selectPmsProductCategoryAttributeRelationList(pmsProductCategoryAttributeRelation);
    }

    /**
     * 新增商品分类和属性关系
     * 
     * @param pmsProductCategoryAttributeRelation 商品分类和属性关系
     * @return 结果
     */
    @Override
    public int insertPmsProductCategoryAttributeRelation(PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation)
    {
        return pmsProductCategoryAttributeRelationMapper.insertPmsProductCategoryAttributeRelation(pmsProductCategoryAttributeRelation);
    }

    /**
     * 修改商品分类和属性关系
     * 
     * @param pmsProductCategoryAttributeRelation 商品分类和属性关系
     * @return 结果
     */
    @Override
    public int updatePmsProductCategoryAttributeRelation(PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation)
    {
        return pmsProductCategoryAttributeRelationMapper.updatePmsProductCategoryAttributeRelation(pmsProductCategoryAttributeRelation);
    }

    /**
     * 批量删除商品分类和属性关系
     * 
     * @param ids 需要删除的商品分类和属性关系主键
     * @return 结果
     */
    @Override
    public int deletePmsProductCategoryAttributeRelationByIds(Long[] ids)
    {
        return pmsProductCategoryAttributeRelationMapper.deletePmsProductCategoryAttributeRelationByIds(ids);
    }

    /**
     * 删除商品分类和属性关系信息
     * 
     * @param id 商品分类和属性关系主键
     * @return 结果
     */
    @Override
    public int deletePmsProductCategoryAttributeRelationById(Long id)
    {
        return pmsProductCategoryAttributeRelationMapper.deletePmsProductCategoryAttributeRelationById(id);
    }
}
