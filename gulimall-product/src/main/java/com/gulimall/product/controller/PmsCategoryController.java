package com.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
import com.gulimall.product.domain.PmsCategory;
import com.gulimall.product.service.IPmsCategoryService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 商品三级分类Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/product/category")
public class PmsCategoryController extends BaseController
{
    @Autowired
    private IPmsCategoryService pmsCategoryService;

    /**
     * 查询商品三级分类列表
     */
    @GetMapping("/list")
    public TableDataInfo list(PmsCategory pmsCategory)
    {
        startPage();
        List<PmsCategory> list = pmsCategoryService.selectPmsCategoryList(pmsCategory);
        return getDataTable(list);
    }

    /**
     * 生成树型
     */
    @GetMapping("/list/tree")
    public AjaxResult listTree(PmsCategory pmsCategory)
    {
        List<PmsCategory> list = pmsCategoryService.selectPmsCategoryListTree(pmsCategory);
        return success(list);
    }

    /**
     * 导出商品三级分类列表
     */
    @Log(title = "商品三级分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsCategory pmsCategory)
    {
        List<PmsCategory> list = pmsCategoryService.selectPmsCategoryList(pmsCategory);
        ExcelUtil<PmsCategory> util = new ExcelUtil<PmsCategory>(PmsCategory.class);
        util.exportExcel(response, list, "商品三级分类数据");
    }

    /**
     * 获取商品三级分类详细信息
     */
    @GetMapping(value = "/{catId}")
    public AjaxResult getInfo(@PathVariable("catId") Long catId)
    {
        return success(pmsCategoryService.selectPmsCategoryByCatId(catId));
    }

    /**
     * 新增商品三级分类
     */
    @Log(title = "商品三级分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsCategory pmsCategory)
    {
        return toAjax(pmsCategoryService.insertPmsCategory(pmsCategory));
    }

    /**
     * 修改商品三级分类
     */
    @Log(title = "商品三级分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsCategory pmsCategory)
    {
        return toAjax(pmsCategoryService.updatePmsCategory(pmsCategory));
    }

    @Log(title = "批量商品三级分类", businessType = BusinessType.UPDATE)
    @PutMapping("/update")
    public AjaxResult updates(@RequestBody PmsCategory[] pmsCategories)
    {
        List<PmsCategory> pmsCategory = Arrays.asList(pmsCategories);
        return toAjax(pmsCategoryService.updatePmsCategoryList(pmsCategory));
    }

    /**
     * 删除商品三级分类
     */
    @Log(title = "商品三级分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{catIds}")
    public AjaxResult remove(@PathVariable Long[] catIds)
    {
        return toAjax(pmsCategoryService.deletePmsCategoryByCatIds(catIds));
    }


}
