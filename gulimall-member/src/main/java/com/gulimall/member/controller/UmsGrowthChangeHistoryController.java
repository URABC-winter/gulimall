package com.gulimall.member.controller;

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
import com.gulimall.member.domain.UmsGrowthChangeHistory;
import com.gulimall.member.service.IUmsGrowthChangeHistoryService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 成长值变化历史记录Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/member/growhistory")
public class UmsGrowthChangeHistoryController extends BaseController
{
    @Autowired
    private IUmsGrowthChangeHistoryService umsGrowthChangeHistoryService;

    /**
     * 查询成长值变化历史记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(UmsGrowthChangeHistory umsGrowthChangeHistory)
    {
        startPage();
        List<UmsGrowthChangeHistory> list = umsGrowthChangeHistoryService.selectUmsGrowthChangeHistoryList(umsGrowthChangeHistory);
        return getDataTable(list);
    }

    /**
     * 导出成长值变化历史记录列表
     */
    @Log(title = "成长值变化历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsGrowthChangeHistory umsGrowthChangeHistory)
    {
        List<UmsGrowthChangeHistory> list = umsGrowthChangeHistoryService.selectUmsGrowthChangeHistoryList(umsGrowthChangeHistory);
        ExcelUtil<UmsGrowthChangeHistory> util = new ExcelUtil<UmsGrowthChangeHistory>(UmsGrowthChangeHistory.class);
        util.exportExcel(response, list, "成长值变化历史记录数据");
    }

    /**
     * 获取成长值变化历史记录详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsGrowthChangeHistoryService.selectUmsGrowthChangeHistoryById(id));
    }

    /**
     * 新增成长值变化历史记录
     */
    @Log(title = "成长值变化历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsGrowthChangeHistory umsGrowthChangeHistory)
    {
        return toAjax(umsGrowthChangeHistoryService.insertUmsGrowthChangeHistory(umsGrowthChangeHistory));
    }

    /**
     * 修改成长值变化历史记录
     */
    @Log(title = "成长值变化历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsGrowthChangeHistory umsGrowthChangeHistory)
    {
        return toAjax(umsGrowthChangeHistoryService.updateUmsGrowthChangeHistory(umsGrowthChangeHistory));
    }

    /**
     * 删除成长值变化历史记录
     */
    @Log(title = "成长值变化历史记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsGrowthChangeHistoryService.deleteUmsGrowthChangeHistoryByIds(ids));
    }
}
