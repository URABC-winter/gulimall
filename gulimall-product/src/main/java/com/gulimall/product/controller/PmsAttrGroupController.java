package com.gulimall.product.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gulimall.product.service.IPmsCategoryService;
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
import com.gulimall.product.domain.PmsAttrGroup;
import com.gulimall.product.service.IPmsAttrGroupService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 属性分组Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/product/group")
public class PmsAttrGroupController extends BaseController
{
    @Autowired
    private IPmsAttrGroupService pmsAttrGroupService;

    @Autowired
    private IPmsCategoryService pmsCategoryService;

    /**
     * 查询属性分组列表
     */
    @GetMapping("/list")
    public TableDataInfo list(PmsAttrGroup pmsAttrGroup)
    {
        startPage();
        List<PmsAttrGroup> list = pmsAttrGroupService.selectPmsAttrGroupList(pmsAttrGroup);
        return getDataTable(list);
    }

    /**
     * 导出属性分组列表
     */
    @Log(title = "属性分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsAttrGroup pmsAttrGroup)
    {
        List<PmsAttrGroup> list = pmsAttrGroupService.selectPmsAttrGroupList(pmsAttrGroup);
        ExcelUtil<PmsAttrGroup> util = new ExcelUtil<PmsAttrGroup>(PmsAttrGroup.class);
        util.exportExcel(response, list, "属性分组数据");
    }

    /**
     * 获取属性分组详细信息
     */
    @GetMapping(value = "/{attrGroupId}")
    public AjaxResult getInfo(@PathVariable("attrGroupId") Long attrGroupId)
    {
        PmsAttrGroup pmsAttrGroup = pmsAttrGroupService.selectPmsAttrGroupByAttrGroupId(attrGroupId);
        Long catelogId = pmsAttrGroup.getCatelogId();
        Long[] catlogPath = pmsCategoryService.getCatlogPath(catelogId);
        pmsAttrGroup.setCatelogPath(catlogPath);

        return success(pmsAttrGroup);
    }

    /**
     * 新增属性分组
     */
    @Log(title = "属性分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsAttrGroup pmsAttrGroup)
    {
        return toAjax(pmsAttrGroupService.insertPmsAttrGroup(pmsAttrGroup));
    }

    /**
     * 修改属性分组
     */
    @Log(title = "属性分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsAttrGroup pmsAttrGroup)
    {
        return toAjax(pmsAttrGroupService.updatePmsAttrGroup(pmsAttrGroup));
    }

    /**
     * 删除属性分组
     */
    @Log(title = "属性分组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{attrGroupIds}")
    public AjaxResult remove(@PathVariable Long[] attrGroupIds)
    {
        return toAjax(pmsAttrGroupService.deletePmsAttrGroupByAttrGroupIds(attrGroupIds));
    }
}
