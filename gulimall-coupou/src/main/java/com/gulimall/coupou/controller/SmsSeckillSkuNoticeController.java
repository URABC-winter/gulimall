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
import com.gulimall.coupou.domain.SmsSeckillSkuNotice;
import com.gulimall.coupou.service.ISmsSeckillSkuNoticeService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 秒杀商品通知订阅Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/coupon/notice")
public class SmsSeckillSkuNoticeController extends BaseController
{
    @Autowired
    private ISmsSeckillSkuNoticeService smsSeckillSkuNoticeService;

    /**
     * 查询秒杀商品通知订阅列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        startPage();
        List<SmsSeckillSkuNotice> list = smsSeckillSkuNoticeService.selectSmsSeckillSkuNoticeList(smsSeckillSkuNotice);
        return getDataTable(list);
    }

    /**
     * 导出秒杀商品通知订阅列表
     */
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        List<SmsSeckillSkuNotice> list = smsSeckillSkuNoticeService.selectSmsSeckillSkuNoticeList(smsSeckillSkuNotice);
        ExcelUtil<SmsSeckillSkuNotice> util = new ExcelUtil<SmsSeckillSkuNotice>(SmsSeckillSkuNotice.class);
        util.exportExcel(response, list, "秒杀商品通知订阅数据");
    }

    /**
     * 获取秒杀商品通知订阅详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSeckillSkuNoticeService.selectSmsSeckillSkuNoticeById(id));
    }

    /**
     * 新增秒杀商品通知订阅
     */
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        return toAjax(smsSeckillSkuNoticeService.insertSmsSeckillSkuNotice(smsSeckillSkuNotice));
    }

    /**
     * 修改秒杀商品通知订阅
     */
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        return toAjax(smsSeckillSkuNoticeService.updateSmsSeckillSkuNotice(smsSeckillSkuNotice));
    }

    /**
     * 删除秒杀商品通知订阅
     */
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSeckillSkuNoticeService.deleteSmsSeckillSkuNoticeByIds(ids));
    }
}
