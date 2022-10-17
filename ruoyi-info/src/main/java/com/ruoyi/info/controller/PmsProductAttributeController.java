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
import com.ruoyi.info.domain.PmsProductAttribute;
import com.ruoyi.info.service.IPmsProductAttributeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品属性Controller
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@RestController
@RequestMapping("/info/attribute")
public class PmsProductAttributeController extends BaseController
{
    @Autowired
    private IPmsProductAttributeService pmsProductAttributeService;

    /**
     * 查询商品属性列表
     */
    @PreAuthorize("@ss.hasPermi('info:attribute:list')")
    @GetMapping("/list")
    public TableDataInfo list(PmsProductAttribute pmsProductAttribute)
    {
        startPage();
        List<PmsProductAttribute> list = pmsProductAttributeService.selectPmsProductAttributeList(pmsProductAttribute);
        return getDataTable(list);
    }

    /**
     * 导出商品属性列表
     */
    @PreAuthorize("@ss.hasPermi('info:attribute:export')")
    @Log(title = "商品属性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsProductAttribute pmsProductAttribute)
    {
        List<PmsProductAttribute> list = pmsProductAttributeService.selectPmsProductAttributeList(pmsProductAttribute);
        ExcelUtil<PmsProductAttribute> util = new ExcelUtil<PmsProductAttribute>(PmsProductAttribute.class);
        util.exportExcel(response, list, "商品属性数据");
    }

    /**
     * 获取商品属性详细信息
     */
    @PreAuthorize("@ss.hasPermi('info:attribute:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pmsProductAttributeService.selectPmsProductAttributeById(id));
    }

    /**
     * 新增商品属性
     */
    @PreAuthorize("@ss.hasPermi('info:attribute:add')")
    @Log(title = "商品属性", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsProductAttribute pmsProductAttribute)
    {
        return toAjax(pmsProductAttributeService.insertPmsProductAttribute(pmsProductAttribute));
    }

    /**
     * 修改商品属性
     */
    @PreAuthorize("@ss.hasPermi('info:attribute:edit')")
    @Log(title = "商品属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsProductAttribute pmsProductAttribute)
    {
        return toAjax(pmsProductAttributeService.updatePmsProductAttribute(pmsProductAttribute));
    }

    /**
     * 删除商品属性
     */
    @PreAuthorize("@ss.hasPermi('info:attribute:remove')")
    @Log(title = "商品属性", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsProductAttributeService.deletePmsProductAttributeByIds(ids));
    }
}
