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
import com.gulimall.coupou.domain.SmsSeckillPromotion;
import com.gulimall.coupou.service.ISmsSeckillPromotionService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 秒杀活动Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/coupon/promotion")
public class SmsSeckillPromotionController extends BaseController
{
    @Autowired
    private ISmsSeckillPromotionService smsSeckillPromotionService;

    /**
     * 查询秒杀活动列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsSeckillPromotion smsSeckillPromotion)
    {
        startPage();
        List<SmsSeckillPromotion> list = smsSeckillPromotionService.selectSmsSeckillPromotionList(smsSeckillPromotion);
        return getDataTable(list);
    }

    /**
     * 导出秒杀活动列表
     */
    @Log(title = "秒杀活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSeckillPromotion smsSeckillPromotion)
    {
        List<SmsSeckillPromotion> list = smsSeckillPromotionService.selectSmsSeckillPromotionList(smsSeckillPromotion);
        ExcelUtil<SmsSeckillPromotion> util = new ExcelUtil<SmsSeckillPromotion>(SmsSeckillPromotion.class);
        util.exportExcel(response, list, "秒杀活动数据");
    }

    /**
     * 获取秒杀活动详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSeckillPromotionService.selectSmsSeckillPromotionById(id));
    }

    /**
     * 新增秒杀活动
     */
    @Log(title = "秒杀活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSeckillPromotion smsSeckillPromotion)
    {
        return toAjax(smsSeckillPromotionService.insertSmsSeckillPromotion(smsSeckillPromotion));
    }

    /**
     * 修改秒杀活动
     */
    @Log(title = "秒杀活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSeckillPromotion smsSeckillPromotion)
    {
        return toAjax(smsSeckillPromotionService.updateSmsSeckillPromotion(smsSeckillPromotion));
    }

    /**
     * 删除秒杀活动
     */
    @Log(title = "秒杀活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSeckillPromotionService.deleteSmsSeckillPromotionByIds(ids));
    }
}
