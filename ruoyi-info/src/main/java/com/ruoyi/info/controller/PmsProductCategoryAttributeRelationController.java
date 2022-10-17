package com.ruoyi.info.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.info.domain.PmsProductCategoryAttributeRelation;
import com.ruoyi.info.service.IPmsProductCategoryAttributeRelationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品分类和属性关系Controller
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@RestController
@RequestMapping("/info/attr/relation")
public class PmsProductCategoryAttributeRelationController extends BaseController
{
    @Autowired
    private IPmsProductCategoryAttributeRelationService pmsProductCategoryAttributeRelationService;

    /**
     * 查询商品分类和属性关系列表
     */
    @PreAuthorize("@ss.hasPermi('info:relation:list')")
    @GetMapping("/list")
    public TableDataInfo list(PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation)
    {
        startPage();
        List<PmsProductCategoryAttributeRelation> list = pmsProductCategoryAttributeRelationService.selectPmsProductCategoryAttributeRelationList(pmsProductCategoryAttributeRelation);
        return getDataTable(list);
    }

    /**
     * 导出商品分类和属性关系列表
     */
    @PreAuthorize("@ss.hasPermi('info:relation:export')")
    @Log(title = "商品分类和属性关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation)
    {
        List<PmsProductCategoryAttributeRelation> list = pmsProductCategoryAttributeRelationService.selectPmsProductCategoryAttributeRelationList(pmsProductCategoryAttributeRelation);
        ExcelUtil<PmsProductCategoryAttributeRelation> util = new ExcelUtil<PmsProductCategoryAttributeRelation>(PmsProductCategoryAttributeRelation.class);
        util.exportExcel(response, list, "商品分类和属性关系数据");
    }

    /**
     * 获取商品分类和属性关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('info:relation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pmsProductCategoryAttributeRelationService.selectPmsProductCategoryAttributeRelationById(id));
    }

    /**
     * 新增商品分类和属性关系
     */
    @PreAuthorize("@ss.hasPermi('info:relation:add')")
    @Log(title = "商品分类和属性关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation)
    {
        return toAjax(pmsProductCategoryAttributeRelationService.insertPmsProductCategoryAttributeRelation(pmsProductCategoryAttributeRelation));
    }

    /**
     * 修改商品分类和属性关系
     */
    @PreAuthorize("@ss.hasPermi('info:relation:edit')")
    @Log(title = "商品分类和属性关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation)
    {
        return toAjax(pmsProductCategoryAttributeRelationService.updatePmsProductCategoryAttributeRelation(pmsProductCategoryAttributeRelation));
    }

    /**
     * 删除商品分类和属性关系
     */
    @PreAuthorize("@ss.hasPermi('info:relation:remove')")
    @Log(title = "商品分类和属性关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsProductCategoryAttributeRelationService.deletePmsProductCategoryAttributeRelationByIds(ids));
    }
}
