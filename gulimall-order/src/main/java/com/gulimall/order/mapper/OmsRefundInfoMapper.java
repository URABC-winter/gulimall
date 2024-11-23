package com.gulimall.order.mapper;

import java.util.List;
import com.gulimall.order.domain.OmsRefundInfo;

/**
 * 退款信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface OmsRefundInfoMapper 
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
     * 删除退款信息
     * 
     * @param id 退款信息主键
     * @return 结果
     */
    public int deleteOmsRefundInfoById(Long id);

    /**
     * 批量删除退款信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOmsRefundInfoByIds(Long[] ids);
}
