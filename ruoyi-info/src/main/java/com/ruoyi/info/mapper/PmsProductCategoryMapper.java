package com.ruoyi.info.mapper;

import java.util.List;
import com.ruoyi.info.domain.PmsProductCategory;

/**
 * 商品分类Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public interface PmsProductCategoryMapper 
{
    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    public PmsProductCategory selectPmsProductCategoryById(Long id);

    /**
     * 查询商品分类列表
     * 
     * @param pmsProductCategory 商品分类
     * @return 商品分类集合
     */
    public List<PmsProductCategory> selectPmsProductCategoryList(PmsProductCategory pmsProductCategory);

    /**
     * 新增商品分类
     * 
     * @param pmsProductCategory 商品分类
     * @return 结果
     */
    public int insertPmsProductCategory(PmsProductCategory pmsProductCategory);

    /**
     * 修改商品分类
     * 
     * @param pmsProductCategory 商品分类
     * @return 结果
     */
    public int updatePmsProductCategory(PmsProductCategory pmsProductCategory);

    /**
     * 删除商品分类
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deletePmsProductCategoryById(Long id);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsProductCategoryByIds(Long[] ids);
}
