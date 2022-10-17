package com.ruoyi.info.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品属性对象 pms_product_attribute
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public class PmsProductAttribute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 商品属性分类id */
    @Excel(name = "商品属性分类id")
    private Long productAttributeCategoryId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 属性选择类型：0->唯一；1->单选；2->多选；对应属性和参数意义不同； */
    @Excel(name = "属性选择类型：0->唯一；1->单选；2->多选；对应属性和参数意义不同；")
    private Long selectType;

    /** 属性录入方式：0->手工录入；1->从列表中选取 */
    @Excel(name = "属性录入方式：0->手工录入；1->从列表中选取")
    private Long inputType;

    /** 可选值列表，以逗号隔开 */
    @Excel(name = "可选值列表，以逗号隔开")
    private String inputList;

    /** 排序字段：最高的可以单独上传图片 */
    @Excel(name = "排序字段：最高的可以单独上传图片")
    private Long sort;

    /** 分类筛选样式：1->普通；1->颜色 */
    @Excel(name = "分类筛选样式：1->普通；1->颜色")
    private Long filterType;

    /** 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索 */
    @Excel(name = "检索类型；0->不需要进行检索；1->关键字检索；2->范围检索")
    private Long searchType;

    /** 相同属性产品是否关联；0->不关联；1->关联 */
    @Excel(name = "相同属性产品是否关联；0->不关联；1->关联")
    private Long relatedStatus;

    /** 是否支持手动新增；0->不支持；1->支持 */
    @Excel(name = "是否支持手动新增；0->不支持；1->支持")
    private Long handAddStatus;

    /** 属性的类型；0->规格；1->参数 */
    @Excel(name = "属性的类型；0->规格；1->参数")
    private Long type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductAttributeCategoryId(Long productAttributeCategoryId) 
    {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public Long getProductAttributeCategoryId() 
    {
        return productAttributeCategoryId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSelectType(Long selectType) 
    {
        this.selectType = selectType;
    }

    public Long getSelectType() 
    {
        return selectType;
    }
    public void setInputType(Long inputType) 
    {
        this.inputType = inputType;
    }

    public Long getInputType() 
    {
        return inputType;
    }
    public void setInputList(String inputList) 
    {
        this.inputList = inputList;
    }

    public String getInputList() 
    {
        return inputList;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setFilterType(Long filterType) 
    {
        this.filterType = filterType;
    }

    public Long getFilterType() 
    {
        return filterType;
    }
    public void setSearchType(Long searchType) 
    {
        this.searchType = searchType;
    }

    public Long getSearchType() 
    {
        return searchType;
    }
    public void setRelatedStatus(Long relatedStatus) 
    {
        this.relatedStatus = relatedStatus;
    }

    public Long getRelatedStatus() 
    {
        return relatedStatus;
    }
    public void setHandAddStatus(Long handAddStatus) 
    {
        this.handAddStatus = handAddStatus;
    }

    public Long getHandAddStatus() 
    {
        return handAddStatus;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productAttributeCategoryId", getProductAttributeCategoryId())
            .append("name", getName())
            .append("selectType", getSelectType())
            .append("inputType", getInputType())
            .append("inputList", getInputList())
            .append("sort", getSort())
            .append("filterType", getFilterType())
            .append("searchType", getSearchType())
            .append("relatedStatus", getRelatedStatus())
            .append("handAddStatus", getHandAddStatus())
            .append("type", getType())
            .toString();
    }
}
