package com.gulimall.order.service;

import java.util.List;
import com.gulimall.order.domain.OmsPaymentInfo;

/**
 * 支付信息Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IOmsPaymentInfoService 
{
    /**
     * 查询支付信息
     * 
     * @param id 支付信息主键
     * @return 支付信息
     */
    public OmsPaymentInfo selectOmsPaymentInfoById(Long id);

    /**
     * 查询支付信息列表
     * 
     * @param omsPaymentInfo 支付信息
     * @return 支付信息集合
     */
    public List<OmsPaymentInfo> selectOmsPaymentInfoList(OmsPaymentInfo omsPaymentInfo);

    /**
     * 新增支付信息
     * 
     * @param omsPaymentInfo 支付信息
     * @return 结果
     */
    public int insertOmsPaymentInfo(OmsPaymentInfo omsPaymentInfo);

    /**
     * 修改支付信息
     * 
     * @param omsPaymentInfo 支付信息
     * @return 结果
     */
    public int updateOmsPaymentInfo(OmsPaymentInfo omsPaymentInfo);

    /**
     * 批量删除支付信息
     * 
     * @param ids 需要删除的支付信息主键集合
     * @return 结果
     */
    public int deleteOmsPaymentInfoByIds(Long[] ids);

    /**
     * 删除支付信息信息
     * 
     * @param id 支付信息主键
     * @return 结果
     */
    public int deleteOmsPaymentInfoById(Long id);
}
