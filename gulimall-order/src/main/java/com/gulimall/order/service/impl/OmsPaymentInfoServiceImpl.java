package com.gulimall.order.service.impl;

import java.util.List;
import com.gulimall.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.order.mapper.OmsPaymentInfoMapper;
import com.gulimall.order.domain.OmsPaymentInfo;
import com.gulimall.order.service.IOmsPaymentInfoService;

/**
 * 支付信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class OmsPaymentInfoServiceImpl implements IOmsPaymentInfoService 
{
    @Autowired
    private OmsPaymentInfoMapper omsPaymentInfoMapper;

    /**
     * 查询支付信息
     * 
     * @param id 支付信息主键
     * @return 支付信息
     */
    @Override
    public OmsPaymentInfo selectOmsPaymentInfoById(Long id)
    {
        return omsPaymentInfoMapper.selectOmsPaymentInfoById(id);
    }

    /**
     * 查询支付信息列表
     * 
     * @param omsPaymentInfo 支付信息
     * @return 支付信息
     */
    @Override
    public List<OmsPaymentInfo> selectOmsPaymentInfoList(OmsPaymentInfo omsPaymentInfo)
    {
        return omsPaymentInfoMapper.selectOmsPaymentInfoList(omsPaymentInfo);
    }

    /**
     * 新增支付信息
     * 
     * @param omsPaymentInfo 支付信息
     * @return 结果
     */
    @Override
    public int insertOmsPaymentInfo(OmsPaymentInfo omsPaymentInfo)
    {
        omsPaymentInfo.setCreateTime(DateUtils.getNowDate());
        return omsPaymentInfoMapper.insertOmsPaymentInfo(omsPaymentInfo);
    }

    /**
     * 修改支付信息
     * 
     * @param omsPaymentInfo 支付信息
     * @return 结果
     */
    @Override
    public int updateOmsPaymentInfo(OmsPaymentInfo omsPaymentInfo)
    {
        return omsPaymentInfoMapper.updateOmsPaymentInfo(omsPaymentInfo);
    }

    /**
     * 批量删除支付信息
     * 
     * @param ids 需要删除的支付信息主键
     * @return 结果
     */
    @Override
    public int deleteOmsPaymentInfoByIds(Long[] ids)
    {
        return omsPaymentInfoMapper.deleteOmsPaymentInfoByIds(ids);
    }

    /**
     * 删除支付信息信息
     * 
     * @param id 支付信息主键
     * @return 结果
     */
    @Override
    public int deleteOmsPaymentInfoById(Long id)
    {
        return omsPaymentInfoMapper.deleteOmsPaymentInfoById(id);
    }
}
