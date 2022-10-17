package com.ruoyi.info.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.info.mapper.PmsProductCategoryMapper;
import com.ruoyi.info.domain.PmsProductCategory;
import com.ruoyi.info.service.IPmsProductCategoryService;

/**
 * 商品分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@Service
public class PmsProductCategoryServiceImpl implements IPmsProductCategoryService 
{
    @Autowired
    private PmsProductCategoryMapper pmsProductCategoryMapper;

    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    @Override
    public PmsProductCategory selectPmsProductCategoryById(Long id)
    {
        return pmsProductCategoryMapper.selectPmsProductCategoryById(id);
    }

    /**
     * 查询商品分类列表
     * 
     * @param pmsProductCategory 商品分类
     * @return 商品分类
     */
    @Override
    public List<PmsProductCategory> selectPmsProductCategoryList(PmsProductCategory pmsProductCategory)
    {
        return pmsProductCategoryMapper.selectPmsProductCategoryList(pmsProductCategory);
    }

    /**
     * 新增商品分类
     * 
     * @param pmsProductCategory 商品分类
     * @return 结果
     */
    @Override
    public int insertPmsProductCategory(PmsProductCategory pmsProductCategory)
    {
        return pmsProductCategoryMapper.insertPmsProductCategory(pmsProductCategory);
    }

    /**
     * 修改商品分类
     * 
     * @param pmsProductCategory 商品分类
     * @return 结果
     */
    @Override
    public int updatePmsProductCategory(PmsProductCategory pmsProductCategory)
    {
        return pmsProductCategoryMapper.updatePmsProductCategory(pmsProductCategory);
    }

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deletePmsProductCategoryByIds(Long[] ids)
    {
        return pmsProductCategoryMapper.deletePmsProductCategoryByIds(ids);
    }

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    @Override
    public int deletePmsProductCategoryById(Long id)
    {
        return pmsProductCategoryMapper.deletePmsProductCategoryById(id);
    }
}
