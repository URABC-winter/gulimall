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
import com.gulimall.coupou.domain.SmsCouponSpuRelation;
import com.gulimall.coupou.service.ISmsCouponSpuRelationService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 优惠券与产品关联Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/coupon/relation")
public class SmsCouponSpuRelationController extends BaseController
{
    @Autowired
    private ISmsCouponSpuRelationService smsCouponSpuRelationService;

    /**
     * 查询优惠券与产品关联列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsCouponSpuRelation smsCouponSpuRelation)
    {
        startPage();
        List<SmsCouponSpuRelation> list = smsCouponSpuRelationService.selectSmsCouponSpuRelationList(smsCouponSpuRelation);
        return getDataTable(list);
    }

    /**
     * 导出优惠券与产品关联列表
     */
    @Log(title = "优惠券与产品关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsCouponSpuRelation smsCouponSpuRelation)
    {
        List<SmsCouponSpuRelation> list = smsCouponSpuRelationService.selectSmsCouponSpuRelationList(smsCouponSpuRelation);
        ExcelUtil<SmsCouponSpuRelation> util = new ExcelUtil<SmsCouponSpuRelation>(SmsCouponSpuRelation.class);
        util.exportExcel(response, list, "优惠券与产品关联数据");
    }

    /**
     * 获取优惠券与产品关联详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsCouponSpuRelationService.selectSmsCouponSpuRelationById(id));
    }

    /**
     * 新增优惠券与产品关联
     */
    @Log(title = "优惠券与产品关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsCouponSpuRelation smsCouponSpuRelation)
    {
        return toAjax(smsCouponSpuRelationService.insertSmsCouponSpuRelation(smsCouponSpuRelation));
    }

    /**
     * 修改优惠券与产品关联
     */
    @Log(title = "优惠券与产品关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsCouponSpuRelation smsCouponSpuRelation)
    {
        return toAjax(smsCouponSpuRelationService.updateSmsCouponSpuRelation(smsCouponSpuRelation));
    }

    /**
     * 删除优惠券与产品关联
     */
    @Log(title = "优惠券与产品关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsCouponSpuRelationService.deleteSmsCouponSpuRelationByIds(ids));
    }
}
