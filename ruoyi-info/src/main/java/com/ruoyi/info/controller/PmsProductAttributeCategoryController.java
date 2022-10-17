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
import com.ruoyi.info.domain.PmsProductAttributeCategory;
import com.ruoyi.info.service.IPmsProductAttributeCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品属性分类Controller
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@RestController
@RequestMapping("/info/category/attribute")
public class PmsProductAttributeCategoryController extends BaseController
{
    @Autowired
    private IPmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    /**
     * 查询商品属性分类列表
     */
    @PreAuthorize("@ss.hasPermi('info:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(PmsProductAttributeCategory pmsProductAttributeCategory)
    {
        startPage();
        List<PmsProductAttributeCategory> list = pmsProductAttributeCategoryService.selectPmsProductAttributeCategoryList(pmsProductAttributeCategory);
        return getDataTable(list);
    }

    /**
     * 导出商品属性分类列表
     */
    @PreAuthorize("@ss.hasPermi('info:category:export')")
    @Log(title = "商品属性分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsProductAttributeCategory pmsProductAttributeCategory)
    {
        List<PmsProductAttributeCategory> list = pmsProductAttributeCategoryService.selectPmsProductAttributeCategoryList(pmsProductAttributeCategory);
        ExcelUtil<PmsProductAttributeCategory> util = new ExcelUtil<PmsProductAttributeCategory>(PmsProductAttributeCategory.class);
        util.exportExcel(response, list, "商品属性分类数据");
    }

    /**
     * 获取商品属性分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('info:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pmsProductAttributeCategoryService.selectPmsProductAttributeCategoryById(id));
    }

    /**
     * 新增商品属性分类
     */
    @PreAuthorize("@ss.hasPermi('info:category:add')")
    @Log(title = "商品属性分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsProductAttributeCategory pmsProductAttributeCategory)
    {
        return toAjax(pmsProductAttributeCategoryService.insertPmsProductAttributeCategory(pmsProductAttributeCategory));
    }

    /**
     * 修改商品属性分类
     */
    @PreAuthorize("@ss.hasPermi('info:category:edit')")
    @Log(title = "商品属性分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsProductAttributeCategory pmsProductAttributeCategory)
    {
        return toAjax(pmsProductAttributeCategoryService.updatePmsProductAttributeCategory(pmsProductAttributeCategory));
    }

    /**
     * 删除商品属性分类
     */
    @PreAuthorize("@ss.hasPermi('info:category:remove')")
    @Log(title = "商品属性分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsProductAttributeCategoryService.deletePmsProductAttributeCategoryByIds(ids));
    }
}
