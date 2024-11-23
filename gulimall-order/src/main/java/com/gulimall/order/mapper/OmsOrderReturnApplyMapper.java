package com.gulimall.order.mapper;

import java.util.List;
import com.gulimall.order.domain.OmsOrderReturnApply;

/**
 * 订单退货申请Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface OmsOrderReturnApplyMapper 
{
    /**
     * 查询订单退货申请
     * 
     * @param id 订单退货申请主键
     * @return 订单退货申请
     */
    public OmsOrderReturnApply selectOmsOrderReturnApplyById(Long id);

    /**
     * 查询订单退货申请列表
     * 
     * @param omsOrderReturnApply 订单退货申请
     * @return 订单退货申请集合
     */
    public List<OmsOrderReturnApply> selectOmsOrderReturnApplyList(OmsOrderReturnApply omsOrderReturnApply);

    /**
     * 新增订单退货申请
     * 
     * @param omsOrderReturnApply 订单退货申请
     * @return 结果
     */
    public int insertOmsOrderReturnApply(OmsOrderReturnApply omsOrderReturnApply);

    /**
     * 修改订单退货申请
     * 
     * @param omsOrderReturnApply 订单退货申请
     * @return 结果
     */
    public int updateOmsOrderReturnApply(OmsOrderReturnApply omsOrderReturnApply);

    /**
     * 删除订单退货申请
     * 
     * @param id 订单退货申请主键
     * @return 结果
     */
    public int deleteOmsOrderReturnApplyById(Long id);

    /**
     * 批量删除订单退货申请
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOmsOrderReturnApplyByIds(Long[] ids);
}
