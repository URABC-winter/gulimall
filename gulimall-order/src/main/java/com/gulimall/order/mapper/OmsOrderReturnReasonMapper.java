package com.gulimall.order.mapper;

import java.util.List;
import com.gulimall.order.domain.OmsOrderReturnReason;

/**
 * 退货原因Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface OmsOrderReturnReasonMapper 
{
    /**
     * 查询退货原因
     * 
     * @param id 退货原因主键
     * @return 退货原因
     */
    public OmsOrderReturnReason selectOmsOrderReturnReasonById(Long id);

    /**
     * 查询退货原因列表
     * 
     * @param omsOrderReturnReason 退货原因
     * @return 退货原因集合
     */
    public List<OmsOrderReturnReason> selectOmsOrderReturnReasonList(OmsOrderReturnReason omsOrderReturnReason);

    /**
     * 新增退货原因
     * 
     * @param omsOrderReturnReason 退货原因
     * @return 结果
     */
    public int insertOmsOrderReturnReason(OmsOrderReturnReason omsOrderReturnReason);

    /**
     * 修改退货原因
     * 
     * @param omsOrderReturnReason 退货原因
     * @return 结果
     */
    public int updateOmsOrderReturnReason(OmsOrderReturnReason omsOrderReturnReason);

    /**
     * 删除退货原因
     * 
     * @param id 退货原因主键
     * @return 结果
     */
    public int deleteOmsOrderReturnReasonById(Long id);

    /**
     * 批量删除退货原因
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOmsOrderReturnReasonByIds(Long[] ids);
}
