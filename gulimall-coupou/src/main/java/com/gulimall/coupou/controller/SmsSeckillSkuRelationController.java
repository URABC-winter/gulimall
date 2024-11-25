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
import com.gulimall.coupou.domain.SmsSeckillSkuRelation;
import com.gulimall.coupou.service.ISmsSeckillSkuRelationService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 秒杀活动商品关联Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/coupon/skurelation")
public class SmsSeckillSkuRelationController extends BaseController
{
    @Autowired
    private ISmsSeckillSkuRelationService smsSeckillSkuRelationService;

    /**
     * 查询秒杀活动商品关联列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        startPage();
        List<SmsSeckillSkuRelation> list = smsSeckillSkuRelationService.selectSmsSeckillSkuRelationList(smsSeckillSkuRelation);
        return getDataTable(list);
    }

    /**
     * 导出秒杀活动商品关联列表
     */
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        List<SmsSeckillSkuRelation> list = smsSeckillSkuRelationService.selectSmsSeckillSkuRelationList(smsSeckillSkuRelation);
        ExcelUtil<SmsSeckillSkuRelation> util = new ExcelUtil<SmsSeckillSkuRelation>(SmsSeckillSkuRelation.class);
        util.exportExcel(response, list, "秒杀活动商品关联数据");
    }

    /**
     * 获取秒杀活动商品关联详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSeckillSkuRelationService.selectSmsSeckillSkuRelationById(id));
    }

    /**
     * 新增秒杀活动商品关联
     */
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        return toAjax(smsSeckillSkuRelationService.insertSmsSeckillSkuRelation(smsSeckillSkuRelation));
    }

    /**
     * 修改秒杀活动商品关联
     */
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        return toAjax(smsSeckillSkuRelationService.updateSmsSeckillSkuRelation(smsSeckillSkuRelation));
    }

    /**
     * 删除秒杀活动商品关联
     */
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSeckillSkuRelationService.deleteSmsSeckillSkuRelationByIds(ids));
    }
}
