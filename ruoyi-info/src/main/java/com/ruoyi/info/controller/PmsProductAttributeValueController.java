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
import com.ruoyi.info.domain.PmsProductAttributeValue;
import com.ruoyi.info.service.IPmsProductAttributeValueService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品属性值Controller
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@RestController
@RequestMapping("/info/value")
public class PmsProductAttributeValueController extends BaseController
{
    @Autowired
    private IPmsProductAttributeValueService pmsProductAttributeValueService;

    /**
     * 查询商品属性值列表
     */
    @PreAuthorize("@ss.hasPermi('info:value:list')")
    @GetMapping("/list")
    public TableDataInfo list(PmsProductAttributeValue pmsProductAttributeValue)
    {
        startPage();
        List<PmsProductAttributeValue> list = pmsProductAttributeValueService.selectPmsProductAttributeValueList(pmsProductAttributeValue);
        return getDataTable(list);
    }

    /**
     * 导出商品属性值列表
     */
    @PreAuthorize("@ss.hasPermi('info:value:export')")
    @Log(title = "商品属性值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsProductAttributeValue pmsProductAttributeValue)
    {
        List<PmsProductAttributeValue> list = pmsProductAttributeValueService.selectPmsProductAttributeValueList(pmsProductAttributeValue);
        ExcelUtil<PmsProductAttributeValue> util = new ExcelUtil<PmsProductAttributeValue>(PmsProductAttributeValue.class);
        util.exportExcel(response, list, "商品属性值数据");
    }

    /**
     * 获取商品属性值详细信息
     */
    @PreAuthorize("@ss.hasPermi('info:value:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pmsProductAttributeValueService.selectPmsProductAttributeValueById(id));
    }

    /**
     * 新增商品属性值
     */
    @PreAuthorize("@ss.hasPermi('info:value:add')")
    @Log(title = "商品属性值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsProductAttributeValue pmsProductAttributeValue)
    {
        return toAjax(pmsProductAttributeValueService.insertPmsProductAttributeValue(pmsProductAttributeValue));
    }

    /**
     * 修改商品属性值
     */
    @PreAuthorize("@ss.hasPermi('info:value:edit')")
    @Log(title = "商品属性值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsProductAttributeValue pmsProductAttributeValue)
    {
        return toAjax(pmsProductAttributeValueService.updatePmsProductAttributeValue(pmsProductAttributeValue));
    }

    /**
     * 删除商品属性值
     */
    @PreAuthorize("@ss.hasPermi('info:value:remove')")
    @Log(title = "商品属性值", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsProductAttributeValueService.deletePmsProductAttributeValueByIds(ids));
    }
}
