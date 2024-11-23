package com.gulimall.order.service;

import java.util.List;
import com.gulimall.order.domain.OmsOrderSetting;

/**
 * 订单配置信息Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IOmsOrderSettingService 
{
    /**
     * 查询订单配置信息
     * 
     * @param id 订单配置信息主键
     * @return 订单配置信息
     */
    public OmsOrderSetting selectOmsOrderSettingById(Long id);

    /**
     * 查询订单配置信息列表
     * 
     * @param omsOrderSetting 订单配置信息
     * @return 订单配置信息集合
     */
    public List<OmsOrderSetting> selectOmsOrderSettingList(OmsOrderSetting omsOrderSetting);

    /**
     * 新增订单配置信息
     * 
     * @param omsOrderSetting 订单配置信息
     * @return 结果
     */
    public int insertOmsOrderSetting(OmsOrderSetting omsOrderSetting);

    /**
     * 修改订单配置信息
     * 
     * @param omsOrderSetting 订单配置信息
     * @return 结果
     */
    public int updateOmsOrderSetting(OmsOrderSetting omsOrderSetting);

    /**
     * 批量删除订单配置信息
     * 
     * @param ids 需要删除的订单配置信息主键集合
     * @return 结果
     */
    public int deleteOmsOrderSettingByIds(Long[] ids);

    /**
     * 删除订单配置信息信息
     * 
     * @param id 订单配置信息主键
     * @return 结果
     */
    public int deleteOmsOrderSettingById(Long id);
}
