package com.gulimall.product.controller;

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
import com.gulimall.common.annotation.Log;
import com.gulimall.common.core.controller.BaseController;
import com.gulimall.common.core.domain.AjaxResult;
import com.gulimall.common.enums.BusinessType;
import com.gulimall.product.domain.PmsCategoryBrandRelation;
import com.gulimall.product.service.IPmsCategoryBrandRelationService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 品牌分类关联Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/product/brandRelation")
public class PmsCategoryBrandRelationController extends BaseController
{
    @Autowired
    private IPmsCategoryBrandRelationService pmsCategoryBrandRelationService;

    /**
     * 查询品牌分类关联列表
     */
    @GetMapping("/list")
    public TableDataInfo list(PmsCategoryBrandRelation pmsCategoryBrandRelation)
    {
        startPage();
        List<PmsCategoryBrandRelation> list = pmsCategoryBrandRelationService.selectPmsCategoryBrandRelationList(pmsCategoryBrandRelation);
        return getDataTable(list);
    }

    /**
     * 导出品牌分类关联列表
     */
    @Log(title = "品牌分类关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsCategoryBrandRelation pmsCategoryBrandRelation)
    {
        List<PmsCategoryBrandRelation> list = pmsCategoryBrandRelationService.selectPmsCategoryBrandRelationList(pmsCategoryBrandRelation);
        ExcelUtil<PmsCategoryBrandRelation> util = new ExcelUtil<PmsCategoryBrandRelation>(PmsCategoryBrandRelation.class);
        util.exportExcel(response, list, "品牌分类关联数据");
    }

    /**
     * 获取品牌分类关联详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pmsCategoryBrandRelationService.selectPmsCategoryBrandRelationById(id));
    }

    /**
     * 新增品牌分类关联
     */
    @Log(title = "品牌分类关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsCategoryBrandRelation pmsCategoryBrandRelation)
    {
        return toAjax(pmsCategoryBrandRelationService.insertPmsCategoryBrandRelation(pmsCategoryBrandRelation));
    }

    /**
     * 修改品牌分类关联
     */
    @Log(title = "品牌分类关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsCategoryBrandRelation pmsCategoryBrandRelation)
    {
        return toAjax(pmsCategoryBrandRelationService.updatePmsCategoryBrandRelation(pmsCategoryBrandRelation));
    }

    /**
     * 删除品牌分类关联
     */
    @Log(title = "品牌分类关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsCategoryBrandRelationService.deletePmsCategoryBrandRelationByIds(ids));
    }
}
