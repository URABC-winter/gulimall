package com.gulimall.coupou.service;

import java.util.List;
import com.gulimall.coupou.domain.SmsHomeAdv;

/**
 * 首页轮播广告Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface ISmsHomeAdvService 
{
    /**
     * 查询首页轮播广告
     * 
     * @param id 首页轮播广告主键
     * @return 首页轮播广告
     */
    public SmsHomeAdv selectSmsHomeAdvById(Long id);

    /**
     * 查询首页轮播广告列表
     * 
     * @param smsHomeAdv 首页轮播广告
     * @return 首页轮播广告集合
     */
    public List<SmsHomeAdv> selectSmsHomeAdvList(SmsHomeAdv smsHomeAdv);

    /**
     * 新增首页轮播广告
     * 
     * @param smsHomeAdv 首页轮播广告
     * @return 结果
     */
    public int insertSmsHomeAdv(SmsHomeAdv smsHomeAdv);

    /**
     * 修改首页轮播广告
     * 
     * @param smsHomeAdv 首页轮播广告
     * @return 结果
     */
    public int updateSmsHomeAdv(SmsHomeAdv smsHomeAdv);

    /**
     * 批量删除首页轮播广告
     * 
     * @param ids 需要删除的首页轮播广告主键集合
     * @return 结果
     */
    public int deleteSmsHomeAdvByIds(Long[] ids);

    /**
     * 删除首页轮播广告信息
     * 
     * @param id 首页轮播广告主键
     * @return 结果
     */
    public int deleteSmsHomeAdvById(Long id);
}
