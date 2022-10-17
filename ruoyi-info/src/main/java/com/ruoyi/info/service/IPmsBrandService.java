package com.ruoyi.info.service;

import java.util.List;
import com.ruoyi.info.domain.PmsBrand;

/**
 * 商品品牌Service接口
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public interface IPmsBrandService 
{
    /**
     * 查询商品品牌
     * 
     * @param id 商品品牌主键
     * @return 商品品牌
     */
    public PmsBrand selectPmsBrandById(Long id);

    /**
     * 查询商品品牌列表
     * 
     * @param pmsBrand 商品品牌
     * @return 商品品牌集合
     */
    public List<PmsBrand> selectPmsBrandList(PmsBrand pmsBrand);

    /**
     * 新增商品品牌
     * 
     * @param pmsBrand 商品品牌
     * @return 结果
     */
    public int insertPmsBrand(PmsBrand pmsBrand);

    /**
     * 修改商品品牌
     * 
     * @param pmsBrand 商品品牌
     * @return 结果
     */
    public int updatePmsBrand(PmsBrand pmsBrand);

    /**
     * 批量删除商品品牌
     * 
     * @param ids 需要删除的商品品牌主键集合
     * @return 结果
     */
    public int deletePmsBrandByIds(Long[] ids);

    /**
     * 删除商品品牌信息
     * 
     * @param id 商品品牌主键
     * @return 结果
     */
    public int deletePmsBrandById(Long id);
}
