package com.ruoyi.info.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品属性值对象 pms_product_attribute_value
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public class PmsProductAttributeValue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 商品属性id */
    @Excel(name = "商品属性id")
    private Long productAttributeId;

    /** 手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开 */
    @Excel(name = "手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开")
    private String value;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductAttributeId(Long productAttributeId) 
    {
        this.productAttributeId = productAttributeId;
    }

    public Long getProductAttributeId() 
    {
        return productAttributeId;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("productAttributeId", getProductAttributeId())
            .append("value", getValue())
            .toString();
    }
}
