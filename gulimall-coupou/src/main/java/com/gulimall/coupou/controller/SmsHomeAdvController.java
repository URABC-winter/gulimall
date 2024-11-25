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
import com.gulimall.coupou.domain.SmsHomeAdv;
import com.gulimall.coupou.service.ISmsHomeAdvService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 首页轮播广告Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/coupon/adv")
public class SmsHomeAdvController extends BaseController
{
    @Autowired
    private ISmsHomeAdvService smsHomeAdvService;

    /**
     * 查询首页轮播广告列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsHomeAdv smsHomeAdv)
    {
        startPage();
        List<SmsHomeAdv> list = smsHomeAdvService.selectSmsHomeAdvList(smsHomeAdv);
        return getDataTable(list);
    }

    /**
     * 导出首页轮播广告列表
     */
    @Log(title = "首页轮播广告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsHomeAdv smsHomeAdv)
    {
        List<SmsHomeAdv> list = smsHomeAdvService.selectSmsHomeAdvList(smsHomeAdv);
        ExcelUtil<SmsHomeAdv> util = new ExcelUtil<SmsHomeAdv>(SmsHomeAdv.class);
        util.exportExcel(response, list, "首页轮播广告数据");
    }

    /**
     * 获取首页轮播广告详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsHomeAdvService.selectSmsHomeAdvById(id));
    }

    /**
     * 新增首页轮播广告
     */
    @Log(title = "首页轮播广告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsHomeAdv smsHomeAdv)
    {
        return toAjax(smsHomeAdvService.insertSmsHomeAdv(smsHomeAdv));
    }

    /**
     * 修改首页轮播广告
     */
    @Log(title = "首页轮播广告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsHomeAdv smsHomeAdv)
    {
        return toAjax(smsHomeAdvService.updateSmsHomeAdv(smsHomeAdv));
    }

    /**
     * 删除首页轮播广告
     */
    @Log(title = "首页轮播广告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsHomeAdvService.deleteSmsHomeAdvByIds(ids));
    }
}
