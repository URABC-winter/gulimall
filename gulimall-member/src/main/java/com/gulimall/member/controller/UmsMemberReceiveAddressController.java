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
import com.gulimall.member.domain.UmsMemberReceiveAddress;
import com.gulimall.member.service.IUmsMemberReceiveAddressService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 会员收货地址Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/member/address")
public class UmsMemberReceiveAddressController extends BaseController
{
    @Autowired
    private IUmsMemberReceiveAddressService umsMemberReceiveAddressService;

    /**
     * 查询会员收货地址列表
     */
    @GetMapping("/list")
    public TableDataInfo list(UmsMemberReceiveAddress umsMemberReceiveAddress)
    {
        startPage();
        List<UmsMemberReceiveAddress> list = umsMemberReceiveAddressService.selectUmsMemberReceiveAddressList(umsMemberReceiveAddress);
        return getDataTable(list);
    }

    /**
     * 导出会员收货地址列表
     */
    @Log(title = "会员收货地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsMemberReceiveAddress umsMemberReceiveAddress)
    {
        List<UmsMemberReceiveAddress> list = umsMemberReceiveAddressService.selectUmsMemberReceiveAddressList(umsMemberReceiveAddress);
        ExcelUtil<UmsMemberReceiveAddress> util = new ExcelUtil<UmsMemberReceiveAddress>(UmsMemberReceiveAddress.class);
        util.exportExcel(response, list, "会员收货地址数据");
    }

    /**
     * 获取会员收货地址详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsMemberReceiveAddressService.selectUmsMemberReceiveAddressById(id));
    }

    /**
     * 新增会员收货地址
     */
    @Log(title = "会员收货地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress)
    {
        return toAjax(umsMemberReceiveAddressService.insertUmsMemberReceiveAddress(umsMemberReceiveAddress));
    }

    /**
     * 修改会员收货地址
     */
    @Log(title = "会员收货地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress)
    {
        return toAjax(umsMemberReceiveAddressService.updateUmsMemberReceiveAddress(umsMemberReceiveAddress));
    }

    /**
     * 删除会员收货地址
     */
    @Log(title = "会员收货地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsMemberReceiveAddressService.deleteUmsMemberReceiveAddressByIds(ids));
    }
}
