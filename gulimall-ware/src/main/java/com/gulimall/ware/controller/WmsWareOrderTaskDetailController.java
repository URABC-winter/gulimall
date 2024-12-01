package com.gulimall.ware.controller;

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
import com.gulimall.ware.domain.WmsWareOrderTaskDetail;
import com.gulimall.ware.service.IWmsWareOrderTaskDetailService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 库存工作单Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/product/detail")
public class WmsWareOrderTaskDetailController extends BaseController
{
    @Autowired
    private IWmsWareOrderTaskDetailService wmsWareOrderTaskDetailService;

    /**
     * 查询库存工作单列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        startPage();
        List<WmsWareOrderTaskDetail> list = wmsWareOrderTaskDetailService.selectWmsWareOrderTaskDetailList(wmsWareOrderTaskDetail);
        return getDataTable(list);
    }

    /**
     * 导出库存工作单列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:export')")
    @Log(title = "库存工作单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        List<WmsWareOrderTaskDetail> list = wmsWareOrderTaskDetailService.selectWmsWareOrderTaskDetailList(wmsWareOrderTaskDetail);
        ExcelUtil<WmsWareOrderTaskDetail> util = new ExcelUtil<WmsWareOrderTaskDetail>(WmsWareOrderTaskDetail.class);
        util.exportExcel(response, list, "库存工作单数据");
    }

    /**
     * 获取库存工作单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsWareOrderTaskDetailService.selectWmsWareOrderTaskDetailById(id));
    }

    /**
     * 新增库存工作单
     */
    @PreAuthorize("@ss.hasPermi('system:detail:add')")
    @Log(title = "库存工作单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        return toAjax(wmsWareOrderTaskDetailService.insertWmsWareOrderTaskDetail(wmsWareOrderTaskDetail));
    }

    /**
     * 修改库存工作单
     */
    @PreAuthorize("@ss.hasPermi('system:detail:edit')")
    @Log(title = "库存工作单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        return toAjax(wmsWareOrderTaskDetailService.updateWmsWareOrderTaskDetail(wmsWareOrderTaskDetail));
    }

    /**
     * 删除库存工作单
     */
    @PreAuthorize("@ss.hasPermi('system:detail:remove')")
    @Log(title = "库存工作单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsWareOrderTaskDetailService.deleteWmsWareOrderTaskDetailByIds(ids));
    }
}
