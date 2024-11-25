package com.gulimall.coupou.controller;

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
import com.gulimall.coupou.domain.SmsCouponSpuCategoryRelation;
import com.gulimall.coupou.service.ISmsCouponSpuCategoryRelationService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 优惠券分类关联Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/coupon/category")
public class SmsCouponSpuCategoryRelationController extends BaseController
{
    @Autowired
    private ISmsCouponSpuCategoryRelationService smsCouponSpuCategoryRelationService;

    /**
     * 查询优惠券分类关联列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        startPage();
        List<SmsCouponSpuCategoryRelation> list = smsCouponSpuCategoryRelationService.selectSmsCouponSpuCategoryRelationList(smsCouponSpuCategoryRelation);
        return getDataTable(list);
    }

    /**
     * 导出优惠券分类关联列表
     */
    @Log(title = "优惠券分类关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        List<SmsCouponSpuCategoryRelation> list = smsCouponSpuCategoryRelationService.selectSmsCouponSpuCategoryRelationList(smsCouponSpuCategoryRelation);
        ExcelUtil<SmsCouponSpuCategoryRelation> util = new ExcelUtil<SmsCouponSpuCategoryRelation>(SmsCouponSpuCategoryRelation.class);
        util.exportExcel(response, list, "优惠券分类关联数据");
    }

    /**
     * 获取优惠券分类关联详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsCouponSpuCategoryRelationService.selectSmsCouponSpuCategoryRelationById(id));
    }

    /**
     * 新增优惠券分类关联
     */
    @Log(title = "优惠券分类关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        return toAjax(smsCouponSpuCategoryRelationService.insertSmsCouponSpuCategoryRelation(smsCouponSpuCategoryRelation));
    }

    /**
     * 修改优惠券分类关联
     */
    @Log(title = "优惠券分类关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        return toAjax(smsCouponSpuCategoryRelationService.updateSmsCouponSpuCategoryRelation(smsCouponSpuCategoryRelation));
    }

    /**
     * 删除优惠券分类关联
     */
    @Log(title = "优惠券分类关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsCouponSpuCategoryRelationService.deleteSmsCouponSpuCategoryRelationByIds(ids));
    }
}
