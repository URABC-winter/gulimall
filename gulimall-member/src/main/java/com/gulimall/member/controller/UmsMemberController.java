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
import com.gulimall.member.domain.UmsMember;
import com.gulimall.member.service.IUmsMemberService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 会员Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/member")
public class UmsMemberController extends BaseController
{
    @Autowired
    private IUmsMemberService umsMemberService;

    /**
     * 查询会员列表
     */
    @GetMapping("/list")
    public TableDataInfo list(UmsMember umsMember)
    {
        startPage();
        List<UmsMember> list = umsMemberService.selectUmsMemberList(umsMember);
        return getDataTable(list);
    }

    /**
     * 导出会员列表
     */
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsMember umsMember)
    {
        List<UmsMember> list = umsMemberService.selectUmsMemberList(umsMember);
        ExcelUtil<UmsMember> util = new ExcelUtil<UmsMember>(UmsMember.class);
        util.exportExcel(response, list, "会员数据");
    }

    /**
     * 获取会员详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsMemberService.selectUmsMemberById(id));
    }

    /**
     * 新增会员
     */
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsMember umsMember)
    {
        return toAjax(umsMemberService.insertUmsMember(umsMember));
    }

    /**
     * 修改会员
     */
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsMember umsMember)
    {
        return toAjax(umsMemberService.updateUmsMember(umsMember));
    }

    /**
     * 删除会员
     */
    @Log(title = "会员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsMemberService.deleteUmsMemberByIds(ids));
    }
}
