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
import com.gulimall.member.domain.UmsMemberStatisticsInfo;
import com.gulimall.member.service.IUmsMemberStatisticsInfoService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 会员统计信息Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/member/info")
public class UmsMemberStatisticsInfoController extends BaseController
{
    @Autowired
    private IUmsMemberStatisticsInfoService umsMemberStatisticsInfoService;

    /**
     * 查询会员统计信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        startPage();
        List<UmsMemberStatisticsInfo> list = umsMemberStatisticsInfoService.selectUmsMemberStatisticsInfoList(umsMemberStatisticsInfo);
        return getDataTable(list);
    }

    /**
     * 导出会员统计信息列表
     */
    @Log(title = "会员统计信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        List<UmsMemberStatisticsInfo> list = umsMemberStatisticsInfoService.selectUmsMemberStatisticsInfoList(umsMemberStatisticsInfo);
        ExcelUtil<UmsMemberStatisticsInfo> util = new ExcelUtil<UmsMemberStatisticsInfo>(UmsMemberStatisticsInfo.class);
        util.exportExcel(response, list, "会员统计信息数据");
    }

    /**
     * 获取会员统计信息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsMemberStatisticsInfoService.selectUmsMemberStatisticsInfoById(id));
    }

    /**
     * 新增会员统计信息
     */
    @Log(title = "会员统计信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        return toAjax(umsMemberStatisticsInfoService.insertUmsMemberStatisticsInfo(umsMemberStatisticsInfo));
    }

    /**
     * 修改会员统计信息
     */
    @Log(title = "会员统计信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        return toAjax(umsMemberStatisticsInfoService.updateUmsMemberStatisticsInfo(umsMemberStatisticsInfo));
    }

    /**
     * 删除会员统计信息
     */
    @Log(title = "会员统计信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsMemberStatisticsInfoService.deleteUmsMemberStatisticsInfoByIds(ids));
    }
}
