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
import com.gulimall.coupou.domain.SmsCouponHistory;
import com.gulimall.coupou.service.ISmsCouponHistoryService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 优惠券领取历史记录Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/coupon/history")
public class SmsCouponHistoryController extends BaseController
{
    @Autowired
    private ISmsCouponHistoryService smsCouponHistoryService;

    /**
     * 查询优惠券领取历史记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsCouponHistory smsCouponHistory)
    {
        startPage();
        List<SmsCouponHistory> list = smsCouponHistoryService.selectSmsCouponHistoryList(smsCouponHistory);
        return getDataTable(list);
    }

    /**
     * 导出优惠券领取历史记录列表
     */
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsCouponHistory smsCouponHistory)
    {
        List<SmsCouponHistory> list = smsCouponHistoryService.selectSmsCouponHistoryList(smsCouponHistory);
        ExcelUtil<SmsCouponHistory> util = new ExcelUtil<SmsCouponHistory>(SmsCouponHistory.class);
        util.exportExcel(response, list, "优惠券领取历史记录数据");
    }

    /**
     * 获取优惠券领取历史记录详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsCouponHistoryService.selectSmsCouponHistoryById(id));
    }

    /**
     * 新增优惠券领取历史记录
     */
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsCouponHistory smsCouponHistory)
    {
        return toAjax(smsCouponHistoryService.insertSmsCouponHistory(smsCouponHistory));
    }

    /**
     * 修改优惠券领取历史记录
     */
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsCouponHistory smsCouponHistory)
    {
        return toAjax(smsCouponHistoryService.updateSmsCouponHistory(smsCouponHistory));
    }

    /**
     * 删除优惠券领取历史记录
     */
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsCouponHistoryService.deleteSmsCouponHistoryByIds(ids));
    }
}
