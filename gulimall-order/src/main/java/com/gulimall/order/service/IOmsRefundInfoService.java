package com.gulimall.order.service;

import java.util.List;
import com.gulimall.order.domain.OmsRefundInfo;

/**
 * 退款信息Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IOmsRefundInfoService 
{
    /**
     * 查询退款信息
     * 
     * @param id 退款信息主键
     * @return 退款信息
     */
    public OmsRefundInfo selectOmsRefundInfoById(Long id);

    /**
     * 查询退款信息列表
     * 
     * @param omsRefundInfo 退款信息
     * @return 退款信息集合
     */
    public List<OmsRefundInfo> selectOmsRefundInfoList(OmsRefundInfo omsRefundInfo);

    /**
     * 新增退款信息
     * 
     * @param omsRefundInfo 退款信息
     * @return 结果
     */
    public int insertOmsRefundInfo(OmsRefundInfo omsRefundInfo);

    /**
     * 修改退款信息
     * 
     * @param omsRefundInfo 退款信息
     * @return 结果
     */
    public int updateOmsRefundInfo(OmsRefundInfo omsRefundInfo);

    /**
     * 批量删除退款信息
     * 
     * @param ids 需要删除的退款信息主键集合
     * @return 结果
     */
    public int deleteOmsRefundInfoByIds(Long[] ids);

    /**
     * 删除退款信息信息
     * 
     * @param id 退款信息主键
     * @return 结果
     */
    public int deleteOmsRefundInfoById(Long id);
}
