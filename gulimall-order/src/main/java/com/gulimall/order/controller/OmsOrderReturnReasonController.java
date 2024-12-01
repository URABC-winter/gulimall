package com.gulimall.order.controller;

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
import com.gulimall.order.domain.OmsOrderReturnReason;
import com.gulimall.order.service.IOmsOrderReturnReasonService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 退货原因Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/product/reason")
public class OmsOrderReturnReasonController extends BaseController
{
    @Autowired
    private IOmsOrderReturnReasonService omsOrderReturnReasonService;

    /**
     * 查询退货原因列表
     */
    @PreAuthorize("@ss.hasPermi('system:reason:list')")
    @GetMapping("/list")
    public TableDataInfo list(OmsOrderReturnReason omsOrderReturnReason)
    {
        startPage();
        List<OmsOrderReturnReason> list = omsOrderReturnReasonService.selectOmsOrderReturnReasonList(omsOrderReturnReason);
        return getDataTable(list);
    }

    /**
     * 导出退货原因列表
     */
    @PreAuthorize("@ss.hasPermi('system:reason:export')")
    @Log(title = "退货原因", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OmsOrderReturnReason omsOrderReturnReason)
    {
        List<OmsOrderReturnReason> list = omsOrderReturnReasonService.selectOmsOrderReturnReasonList(omsOrderReturnReason);
        ExcelUtil<OmsOrderReturnReason> util = new ExcelUtil<OmsOrderReturnReason>(OmsOrderReturnReason.class);
        util.exportExcel(response, list, "退货原因数据");
    }

    /**
     * 获取退货原因详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:reason:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(omsOrderReturnReasonService.selectOmsOrderReturnReasonById(id));
    }

    /**
     * 新增退货原因
     */
    @PreAuthorize("@ss.hasPermi('system:reason:add')")
    @Log(title = "退货原因", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OmsOrderReturnReason omsOrderReturnReason)
    {
        return toAjax(omsOrderReturnReasonService.insertOmsOrderReturnReason(omsOrderReturnReason));
    }

    /**
     * 修改退货原因
     */
    @PreAuthorize("@ss.hasPermi('system:reason:edit')")
    @Log(title = "退货原因", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OmsOrderReturnReason omsOrderReturnReason)
    {
        return toAjax(omsOrderReturnReasonService.updateOmsOrderReturnReason(omsOrderReturnReason));
    }

    /**
     * 删除退货原因
     */
    @PreAuthorize("@ss.hasPermi('system:reason:remove')")
    @Log(title = "退货原因", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(omsOrderReturnReasonService.deleteOmsOrderReturnReasonByIds(ids));
    }
}
