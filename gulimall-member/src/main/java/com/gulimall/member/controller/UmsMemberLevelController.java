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
import com.gulimall.member.domain.UmsMemberLevel;
import com.gulimall.member.service.IUmsMemberLevelService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 会员等级Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/member/level")
public class UmsMemberLevelController extends BaseController
{
    @Autowired
    private IUmsMemberLevelService umsMemberLevelService;

    /**
     * 查询会员等级列表
     */
    @GetMapping("/list")
    public TableDataInfo list(UmsMemberLevel umsMemberLevel)
    {
        startPage();
        List<UmsMemberLevel> list = umsMemberLevelService.selectUmsMemberLevelList(umsMemberLevel);
        return getDataTable(list);
    }

    /**
     * 导出会员等级列表
     */
    @Log(title = "会员等级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsMemberLevel umsMemberLevel)
    {
        List<UmsMemberLevel> list = umsMemberLevelService.selectUmsMemberLevelList(umsMemberLevel);
        ExcelUtil<UmsMemberLevel> util = new ExcelUtil<UmsMemberLevel>(UmsMemberLevel.class);
        util.exportExcel(response, list, "会员等级数据");
    }

    /**
     * 获取会员等级详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsMemberLevelService.selectUmsMemberLevelById(id));
    }

    /**
     * 新增会员等级
     */
    @Log(title = "会员等级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsMemberLevel umsMemberLevel)
    {
        return toAjax(umsMemberLevelService.insertUmsMemberLevel(umsMemberLevel));
    }

    /**
     * 修改会员等级
     */
    @Log(title = "会员等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsMemberLevel umsMemberLevel)
    {
        return toAjax(umsMemberLevelService.updateUmsMemberLevel(umsMemberLevel));
    }

    /**
     * 删除会员等级
     */
    @Log(title = "会员等级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsMemberLevelService.deleteUmsMemberLevelByIds(ids));
    }
}
