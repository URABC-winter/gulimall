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
import com.gulimall.coupou.domain.SmsSeckillSession;
import com.gulimall.coupou.service.ISmsSeckillSessionService;
import com.gulimall.common.utils.poi.ExcelUtil;
import com.gulimall.common.core.page.TableDataInfo;

/**
 * 秒杀活动场次Controller
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@RestController
@RequestMapping("/coupon/session")
public class SmsSeckillSessionController extends BaseController
{
    @Autowired
    private ISmsSeckillSessionService smsSeckillSessionService;

    /**
     * 查询秒杀活动场次列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SmsSeckillSession smsSeckillSession)
    {
        startPage();
        List<SmsSeckillSession> list = smsSeckillSessionService.selectSmsSeckillSessionList(smsSeckillSession);
        return getDataTable(list);
    }

    /**
     * 导出秒杀活动场次列表
     */
    @Log(title = "秒杀活动场次", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSeckillSession smsSeckillSession)
    {
        List<SmsSeckillSession> list = smsSeckillSessionService.selectSmsSeckillSessionList(smsSeckillSession);
        ExcelUtil<SmsSeckillSession> util = new ExcelUtil<SmsSeckillSession>(SmsSeckillSession.class);
        util.exportExcel(response, list, "秒杀活动场次数据");
    }

    /**
     * 获取秒杀活动场次详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSeckillSessionService.selectSmsSeckillSessionById(id));
    }

    /**
     * 新增秒杀活动场次
     */
    @Log(title = "秒杀活动场次", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSeckillSession smsSeckillSession)
    {
        return toAjax(smsSeckillSessionService.insertSmsSeckillSession(smsSeckillSession));
    }

    /**
     * 修改秒杀活动场次
     */
    @Log(title = "秒杀活动场次", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSeckillSession smsSeckillSession)
    {
        return toAjax(smsSeckillSessionService.updateSmsSeckillSession(smsSeckillSession));
    }

    /**
     * 删除秒杀活动场次
     */
    @Log(title = "秒杀活动场次", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSeckillSessionService.deleteSmsSeckillSessionByIds(ids));
    }
}
