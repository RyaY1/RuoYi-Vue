package com.ruoyi.info.service;

import java.util.List;
import com.ruoyi.info.domain.PmsProductAttributeCategory;

/**
 * 商品属性分类Service接口
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public interface IPmsProductAttributeCategoryService 
{
    /**
     * 查询商品属性分类
     * 
     * @param id 商品属性分类主键
     * @return 商品属性分类
     */
    public PmsProductAttributeCategory selectPmsProductAttributeCategoryById(Long id);

    /**
     * 查询商品属性分类列表
     * 
     * @param pmsProductAttributeCategory 商品属性分类
     * @return 商品属性分类集合
     */
    public List<PmsProductAttributeCategory> selectPmsProductAttributeCategoryList(PmsProductAttributeCategory pmsProductAttributeCategory);

    /**
     * 新增商品属性分类
     * 
     * @param pmsProductAttributeCategory 商品属性分类
     * @return 结果
     */
    public int insertPmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory);

    /**
     * 修改商品属性分类
     * 
     * @param pmsProductAttributeCategory 商品属性分类
     * @return 结果
     */
    public int updatePmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory);

    /**
     * 批量删除商品属性分类
     * 
     * @param ids 需要删除的商品属性分类主键集合
     * @return 结果
     */
    public int deletePmsProductAttributeCategoryByIds(Long[] ids);

    /**
     * 删除商品属性分类信息
     * 
     * @param id 商品属性分类主键
     * @return 结果
     */
    public int deletePmsProductAttributeCategoryById(Long id);
}
