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
import com.gulimall.coupou.domain.SmsSpuBounds;
import com.gulimall.coupou.service.ISmsSpuBoundsService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 商品spu积分设置Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/coupon/bounds")
public class SmsSpuBoundsController extends BaseController
{
    @Autowired
    private ISmsSpuBoundsService smsSpuBoundsService;

    /**
     * 查询商品spu积分设置列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsSpuBounds smsSpuBounds)
    {
        startPage();
        List<SmsSpuBounds> list = smsSpuBoundsService.selectSmsSpuBoundsList(smsSpuBounds);
        return getDataTable(list);
    }

    /**
     * 导出商品spu积分设置列表
     */
    @Log(title = "商品spu积分设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSpuBounds smsSpuBounds)
    {
        List<SmsSpuBounds> list = smsSpuBoundsService.selectSmsSpuBoundsList(smsSpuBounds);
        ExcelUtil<SmsSpuBounds> util = new ExcelUtil<SmsSpuBounds>(SmsSpuBounds.class);
        util.exportExcel(response, list, "商品spu积分设置数据");
    }

    /**
     * 获取商品spu积分设置详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSpuBoundsService.selectSmsSpuBoundsById(id));
    }

    /**
     * 新增商品spu积分设置
     */
    @Log(title = "商品spu积分设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSpuBounds smsSpuBounds)
    {
        return toAjax(smsSpuBoundsService.insertSmsSpuBounds(smsSpuBounds));
    }

    /**
     * 修改商品spu积分设置
     */
    @Log(title = "商品spu积分设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSpuBounds smsSpuBounds)
    {
        return toAjax(smsSpuBoundsService.updateSmsSpuBounds(smsSpuBounds));
    }

    /**
     * 删除商品spu积分设置
     */
    @Log(title = "商品spu积分设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSpuBoundsService.deleteSmsSpuBoundsByIds(ids));
    }
}
