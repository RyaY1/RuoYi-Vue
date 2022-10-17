package com.ruoyi.info.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.info.mapper.PmsBrandMapper;
import com.ruoyi.info.domain.PmsBrand;
import com.ruoyi.info.service.IPmsBrandService;

/**
 * 商品品牌Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@Service
public class PmsBrandServiceImpl implements IPmsBrandService 
{
    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    /**
     * 查询商品品牌
     * 
     * @param id 商品品牌主键
     * @return 商品品牌
     */
    @Override
    public PmsBrand selectPmsBrandById(Long id)
    {
        return pmsBrandMapper.selectPmsBrandById(id);
    }

    /**
     * 查询商品品牌列表
     * 
     * @param pmsBrand 商品品牌
     * @return 商品品牌
     */
    @Override
    public List<PmsBrand> selectPmsBrandList(PmsBrand pmsBrand)
    {
        return pmsBrandMapper.selectPmsBrandList(pmsBrand);
    }

    /**
     * 新增商品品牌
     * 
     * @param pmsBrand 商品品牌
     * @return 结果
     */
    @Override
    public int insertPmsBrand(PmsBrand pmsBrand)
    {
        return pmsBrandMapper.insertPmsBrand(pmsBrand);
    }

    /**
     * 修改商品品牌
     * 
     * @param pmsBrand 商品品牌
     * @return 结果
     */
    @Override
    public int updatePmsBrand(PmsBrand pmsBrand)
    {
        return pmsBrandMapper.updatePmsBrand(pmsBrand);
    }

    /**
     * 批量删除商品品牌
     * 
     * @param ids 需要删除的商品品牌主键
     * @return 结果
     */
    @Override
    public int deletePmsBrandByIds(Long[] ids)
    {
        return pmsBrandMapper.deletePmsBrandByIds(ids);
    }

    /**
     * 删除商品品牌信息
     * 
     * @param id 商品品牌主键
     * @return 结果
     */
    @Override
    public int deletePmsBrandById(Long id)
    {
        return pmsBrandMapper.deletePmsBrandById(id);
    }
}
