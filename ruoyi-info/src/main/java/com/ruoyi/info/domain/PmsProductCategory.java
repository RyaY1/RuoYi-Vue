package com.ruoyi.info.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品分类对象 pms_product_category
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public class PmsProductCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 上级分类的编号：0表示一级分类 */
    @Excel(name = "上级分类的编号：0表示一级分类")
    private Long parentId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 分类级别：0->1级；1->2级 */
    @Excel(name = "分类级别：0->1级；1->2级")
    private Long level;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long productCount;

    /** 商品单位 */
    @Excel(name = "商品单位")
    private String productUnit;

    /** 是否显示在导航栏：0->不显示；1->显示 */
    @Excel(name = "是否显示在导航栏：0->不显示；1->显示")
    private Long navStatus;

    /** 显示状态：0->不显示；1->显示 */
    @Excel(name = "显示状态：0->不显示；1->显示")
    private Long showStatus;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 图标 */
    @Excel(name = "图标")
    private String icon;

    /** 关键字 */
    @Excel(name = "关键字")
    private String keywords;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setLevel(Long level) 
    {
        this.level = level;
    }

    public Long getLevel() 
    {
        return level;
    }
    public void setProductCount(Long productCount) 
    {
        this.productCount = productCount;
    }

    public Long getProductCount() 
    {
        return productCount;
    }
    public void setProductUnit(String productUnit) 
    {
        this.productUnit = productUnit;
    }

    public String getProductUnit() 
    {
        return productUnit;
    }
    public void setNavStatus(Long navStatus) 
    {
        this.navStatus = navStatus;
    }

    public Long getNavStatus() 
    {
        return navStatus;
    }
    public void setShowStatus(Long showStatus) 
    {
        this.showStatus = showStatus;
    }

    public Long getShowStatus() 
    {
        return showStatus;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
    }
    public void setKeywords(String keywords) 
    {
        this.keywords = keywords;
    }

    public String getKeywords() 
    {
        return keywords;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentId", getParentId())
            .append("name", getName())
            .append("level", getLevel())
            .append("productCount", getProductCount())
            .append("productUnit", getProductUnit())
            .append("navStatus", getNavStatus())
            .append("showStatus", getShowStatus())
            .append("sort", getSort())
            .append("icon", getIcon())
            .append("keywords", getKeywords())
            .append("description", getDescription())
            .toString();
    }
}
