package com.ruoyi.info.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品分类和属性关系对象 pms_product_category_attribute_relation
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public class PmsProductCategoryAttributeRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 商品分类id */
    @Excel(name = "商品分类id")
    private Long productCategoryId;

    /** 商品属性id */
    @Excel(name = "商品属性id")
    private Long productAttributeId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductCategoryId(Long productCategoryId) 
    {
        this.productCategoryId = productCategoryId;
    }

    public Long getProductCategoryId() 
    {
        return productCategoryId;
    }
    public void setProductAttributeId(Long productAttributeId) 
    {
        this.productAttributeId = productAttributeId;
    }

    public Long getProductAttributeId() 
    {
        return productAttributeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productCategoryId", getProductCategoryId())
            .append("productAttributeId", getProductAttributeId())
            .toString();
    }
}
