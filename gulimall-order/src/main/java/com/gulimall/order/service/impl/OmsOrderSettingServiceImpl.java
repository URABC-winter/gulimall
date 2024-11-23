package com.gulimall.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.order.mapper.OmsOrderSettingMapper;
import com.gulimall.order.domain.OmsOrderSetting;
import com.gulimall.order.service.IOmsOrderSettingService;

/**
 * 订单配置信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class OmsOrderSettingServiceImpl implements IOmsOrderSettingService 
{
    @Autowired
    private OmsOrderSettingMapper omsOrderSettingMapper;

    /**
     * 查询订单配置信息
     * 
     * @param id 订单配置信息主键
     * @return 订单配置信息
     */
    @Override
    public OmsOrderSetting selectOmsOrderSettingById(Long id)
    {
        return omsOrderSettingMapper.selectOmsOrderSettingById(id);
    }

    /**
     * 查询订单配置信息列表
     * 
     * @param omsOrderSetting 订单配置信息
     * @return 订单配置信息
     */
    @Override
    public List<OmsOrderSetting> selectOmsOrderSettingList(OmsOrderSetting omsOrderSetting)
    {
        return omsOrderSettingMapper.selectOmsOrderSettingList(omsOrderSetting);
    }

    /**
     * 新增订单配置信息
     * 
     * @param omsOrderSetting 订单配置信息
     * @return 结果
     */
    @Override
    public int insertOmsOrderSetting(OmsOrderSetting omsOrderSetting)
    {
        return omsOrderSettingMapper.insertOmsOrderSetting(omsOrderSetting);
    }

    /**
     * 修改订单配置信息
     * 
     * @param omsOrderSetting 订单配置信息
     * @return 结果
     */
    @Override
    public int updateOmsOrderSetting(OmsOrderSetting omsOrderSetting)
    {
        return omsOrderSettingMapper.updateOmsOrderSetting(omsOrderSetting);
    }

    /**
     * 批量删除订单配置信息
     * 
     * @param ids 需要删除的订单配置信息主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderSettingByIds(Long[] ids)
    {
        return omsOrderSettingMapper.deleteOmsOrderSettingByIds(ids);
    }

    /**
     * 删除订单配置信息信息
     * 
     * @param id 订单配置信息主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderSettingById(Long id)
    {
        return omsOrderSettingMapper.deleteOmsOrderSettingById(id);
    }
}
