package com.ruoyi.info.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品品牌对象 pms_brand
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public class PmsBrand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 首字母 */
    @Excel(name = "首字母")
    private String firstLetter;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 是否为品牌制造商：0->不是；1->是 */
    @Excel(name = "是否为品牌制造商：0->不是；1->是")
    private Long factoryStatus;

    /** 是否显示 */
    @Excel(name = "是否显示")
    private Long showStatus;

    /** 产品数量 */
    @Excel(name = "产品数量")
    private Long productCount;

    /** 产品评论数量 */
    @Excel(name = "产品评论数量")
    private Long productCommentCount;

    /** 品牌logo */
    @Excel(name = "品牌logo")
    private String logo;

    /** 专区大图 */
    @Excel(name = "专区大图")
    private String bigPic;

    /** 品牌故事 */
    @Excel(name = "品牌故事")
    private String brandStory;

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
    public void setFirstLetter(String firstLetter) 
    {
        this.firstLetter = firstLetter;
    }

    public String getFirstLetter() 
    {
        return firstLetter;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setFactoryStatus(Long factoryStatus) 
    {
        this.factoryStatus = factoryStatus;
    }

    public Long getFactoryStatus() 
    {
        return factoryStatus;
    }
    public void setShowStatus(Long showStatus) 
    {
        this.showStatus = showStatus;
    }

    public Long getShowStatus() 
    {
        return showStatus;
    }
    public void setProductCount(Long productCount) 
    {
        this.productCount = productCount;
    }

    public Long getProductCount() 
    {
        return productCount;
    }
    public void setProductCommentCount(Long productCommentCount) 
    {
        this.productCommentCount = productCommentCount;
    }

    public Long getProductCommentCount() 
    {
        return productCommentCount;
    }
    public void setLogo(String logo) 
    {
        this.logo = logo;
    }

    public String getLogo() 
    {
        return logo;
    }
    public void setBigPic(String bigPic) 
    {
        this.bigPic = bigPic;
    }

    public String getBigPic() 
    {
        return bigPic;
    }
    public void setBrandStory(String brandStory) 
    {
        this.brandStory = brandStory;
    }

    public String getBrandStory() 
    {
        return brandStory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("firstLetter", getFirstLetter())
            .append("sort", getSort())
            .append("factoryStatus", getFactoryStatus())
            .append("showStatus", getShowStatus())
            .append("productCount", getProductCount())
            .append("productCommentCount", getProductCommentCount())
            .append("logo", getLogo())
            .append("bigPic", getBigPic())
            .append("brandStory", getBrandStory())
            .toString();
    }
}
