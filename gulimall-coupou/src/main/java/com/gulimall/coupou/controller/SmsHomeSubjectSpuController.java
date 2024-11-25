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
import com.gulimall.coupou.domain.SmsHomeSubjectSpu;
import com.gulimall.coupou.service.ISmsHomeSubjectSpuService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 专题商品Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/coupon/spu")
public class SmsHomeSubjectSpuController extends BaseController
{
    @Autowired
    private ISmsHomeSubjectSpuService smsHomeSubjectSpuService;

    /**
     * 查询专题商品列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsHomeSubjectSpu smsHomeSubjectSpu)
    {
        startPage();
        List<SmsHomeSubjectSpu> list = smsHomeSubjectSpuService.selectSmsHomeSubjectSpuList(smsHomeSubjectSpu);
        return getDataTable(list);
    }

    /**
     * 导出专题商品列表
     */
    @Log(title = "专题商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsHomeSubjectSpu smsHomeSubjectSpu)
    {
        List<SmsHomeSubjectSpu> list = smsHomeSubjectSpuService.selectSmsHomeSubjectSpuList(smsHomeSubjectSpu);
        ExcelUtil<SmsHomeSubjectSpu> util = new ExcelUtil<SmsHomeSubjectSpu>(SmsHomeSubjectSpu.class);
        util.exportExcel(response, list, "专题商品数据");
    }

    /**
     * 获取专题商品详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsHomeSubjectSpuService.selectSmsHomeSubjectSpuById(id));
    }

    /**
     * 新增专题商品
     */
    @Log(title = "专题商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsHomeSubjectSpu smsHomeSubjectSpu)
    {
        return toAjax(smsHomeSubjectSpuService.insertSmsHomeSubjectSpu(smsHomeSubjectSpu));
    }

    /**
     * 修改专题商品
     */
    @Log(title = "专题商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsHomeSubjectSpu smsHomeSubjectSpu)
    {
        return toAjax(smsHomeSubjectSpuService.updateSmsHomeSubjectSpu(smsHomeSubjectSpu));
    }

    /**
     * 删除专题商品
     */
    @Log(title = "专题商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsHomeSubjectSpuService.deleteSmsHomeSubjectSpuByIds(ids));
    }
}
