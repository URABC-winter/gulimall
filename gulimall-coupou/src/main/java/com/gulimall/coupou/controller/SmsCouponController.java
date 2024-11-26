package com.gulimall.coupou.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
import com.gulimall.coupou.domain.SmsCoupon;
import com.gulimall.coupou.service.ISmsCouponService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 优惠券信息Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RefreshScope
@RequestMapping("/coupon")
public class SmsCouponController extends BaseController
{
    @Autowired
    private ISmsCouponService smsCouponService;

    @Value("${config.name}")
    private String name;

    @Value("${config.age}")
    private String age;

    @GetMapping("/test")
    public String print(){
        String str = "name:"+name+" age:"+age;
        return str;
    }

    /**
     * 查询优惠券信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsCoupon smsCoupon)
    {
        startPage();
        List<SmsCoupon> list = smsCouponService.selectSmsCouponList(smsCoupon);
        return getDataTable(list);
    }

    /**
     * 导出优惠券信息列表
     */
    @Log(title = "优惠券信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsCoupon smsCoupon)
    {
        List<SmsCoupon> list = smsCouponService.selectSmsCouponList(smsCoupon);
        ExcelUtil<SmsCoupon> util = new ExcelUtil<SmsCoupon>(SmsCoupon.class);
        util.exportExcel(response, list, "优惠券信息数据");
    }

    /**
     * 获取优惠券信息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsCouponService.selectSmsCouponById(id));
    }

    /**
     * 新增优惠券信息
     */
    @Log(title = "优惠券信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsCoupon smsCoupon)
    {
        return toAjax(smsCouponService.insertSmsCoupon(smsCoupon));
    }

    /**
     * 修改优惠券信息
     */
    @Log(title = "优惠券信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsCoupon smsCoupon)
    {
        return toAjax(smsCouponService.updateSmsCoupon(smsCoupon));
    }

    /**
     * 删除优惠券信息
     */
    @Log(title = "优惠券信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsCouponService.deleteSmsCouponByIds(ids));
    }
}
