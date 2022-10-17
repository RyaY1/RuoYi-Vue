package com.ruoyi.info.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.info.mapper.PmsProductAttributeCategoryMapper;
import com.ruoyi.info.domain.PmsProductAttributeCategory;
import com.ruoyi.info.service.IPmsProductAttributeCategoryService;

/**
 * 商品属性分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@Service
public class PmsProductAttributeCategoryServiceImpl implements IPmsProductAttributeCategoryService 
{
    @Autowired
    private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;

    /**
     * 查询商品属性分类
     * 
     * @param id 商品属性分类主键
     * @return 商品属性分类
     */
    @Override
    public PmsProductAttributeCategory selectPmsProductAttributeCategoryById(Long id)
    {
        return pmsProductAttributeCategoryMapper.selectPmsProductAttributeCategoryById(id);
    }

    /**
     * 查询商品属性分类列表
     * 
     * @param pmsProductAttributeCategory 商品属性分类
     * @return 商品属性分类
     */
    @Override
    public List<PmsProductAttributeCategory> selectPmsProductAttributeCategoryList(PmsProductAttributeCategory pmsProductAttributeCategory)
    {
        return pmsProductAttributeCategoryMapper.selectPmsProductAttributeCategoryList(pmsProductAttributeCategory);
    }

    /**
     * 新增商品属性分类
     * 
     * @param pmsProductAttributeCategory 商品属性分类
     * @return 结果
     */
    @Override
    public int insertPmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory)
    {
        return pmsProductAttributeCategoryMapper.insertPmsProductAttributeCategory(pmsProductAttributeCategory);
    }

    /**
     * 修改商品属性分类
     * 
     * @param pmsProductAttributeCategory 商品属性分类
     * @return 结果
     */
    @Override
    public int updatePmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory)
    {
        return pmsProductAttributeCategoryMapper.updatePmsProductAttributeCategory(pmsProductAttributeCategory);
    }

    /**
     * 批量删除商品属性分类
     * 
     * @param ids 需要删除的商品属性分类主键
     * @return 结果
     */
    @Override
    public int deletePmsProductAttributeCategoryByIds(Long[] ids)
    {
        return pmsProductAttributeCategoryMapper.deletePmsProductAttributeCategoryByIds(ids);
    }

    /**
     * 删除商品属性分类信息
     * 
     * @param id 商品属性分类主键
     * @return 结果
     */
    @Override
    public int deletePmsProductAttributeCategoryById(Long id)
    {
        return pmsProductAttributeCategoryMapper.deletePmsProductAttributeCategoryById(id);
    }
}
