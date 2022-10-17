package com.ruoyi.info.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品属性分类对象 pms_product_attribute_category
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public class PmsProductAttributeCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 属性数量 */
    @Excel(name = "属性数量")
    private Long attributeCount;

    /** 参数数量 */
    @Excel(name = "参数数量")
    private Long paramCount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAttributeCount(Long attributeCount) 
    {
        this.attributeCount = attributeCount;
    }

    public Long getAttributeCount() 
    {
        return attributeCount;
    }
    public void setParamCount(Long paramCount) 
    {
        this.paramCount = paramCount;
    }

    public Long getParamCount() 
    {
        return paramCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("attributeCount", getAttributeCount())
            .append("paramCount", getParamCount())
            .toString();
    }
}
