package com.ruoyi.info.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
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
import com.ruoyi.info.domain.PmsBrand;
import com.ruoyi.info.service.IPmsBrandService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品品牌Controller
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@RestController
@RequestMapping("/info/brand")
public class PmsBrandController extends BaseController
{
    @Autowired
    private IPmsBrandService pmsBrandService;

    /**
     * 查询商品品牌列表
     */
    @PreAuthorize("@ss.hasPermi('info:brand:list')")
    @GetMapping("/list")
    public TableDataInfo list(PmsBrand pmsBrand)
    {
        startPage();
        List<PmsBrand> list = pmsBrandService.selectPmsBrandList(pmsBrand);
        return getDataTable(list);
    }

    public static void main(String[] args) {
        List<Map<String,Object>> result = new ArrayList<>(16);
        Map<String,Object> userMap = new HashMap<>(16);
        userMap.put("姓名","姓名");
        userMap.put("ID","ID");
        Map<String,Object> kqMap = new HashMap<>(16);
        kqMap.put("考勤1","考勤1");
        kqMap.put("考勤2","考勤2");
        userMap.put("考勤",kqMap);
        result.add(userMap);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 导出商品品牌列表
     */
    @PreAuthorize("@ss.hasPermi('info:brand:export')")
    @Log(title = "商品品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsBrand pmsBrand)
    {
        List<PmsBrand> list = pmsBrandService.selectPmsBrandList(pmsBrand);
        ExcelUtil<PmsBrand> util = new ExcelUtil<PmsBrand>(PmsBrand.class);
        util.exportExcel(response, list, "商品品牌数据");
    }

    /**
     * 获取商品品牌详细信息
     */
    @PreAuthorize("@ss.hasPermi('info:brand:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pmsBrandService.selectPmsBrandById(id));
    }

    /**
     * 新增商品品牌
     */
    @PreAuthorize("@ss.hasPermi('info:brand:add')")
    @Log(title = "商品品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsBrand pmsBrand)
    {
        return toAjax(pmsBrandService.insertPmsBrand(pmsBrand));
    }

    /**
     * 修改商品品牌
     */
    @PreAuthorize("@ss.hasPermi('info:brand:edit')")
    @Log(title = "商品品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsBrand pmsBrand)
    {
        return toAjax(pmsBrandService.updatePmsBrand(pmsBrand));
    }

    /**
     * 删除商品品牌
     */
    @PreAuthorize("@ss.hasPermi('info:brand:remove')")
    @Log(title = "商品品牌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsBrandService.deletePmsBrandByIds(ids));
    }
}
