package com.gulimall.order.service;

import java.util.List;
import com.gulimall.order.domain.OmsOrderItem;

/**
 * 订单项信息Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IOmsOrderItemService 
{
    /**
     * 查询订单项信息
     * 
     * @param id 订单项信息主键
     * @return 订单项信息
     */
    public OmsOrderItem selectOmsOrderItemById(Long id);

    /**
     * 查询订单项信息列表
     * 
     * @param omsOrderItem 订单项信息
     * @return 订单项信息集合
     */
    public List<OmsOrderItem> selectOmsOrderItemList(OmsOrderItem omsOrderItem);

    /**
     * 新增订单项信息
     * 
     * @param omsOrderItem 订单项信息
     * @return 结果
     */
    public int insertOmsOrderItem(OmsOrderItem omsOrderItem);

    /**
     * 修改订单项信息
     * 
     * @param omsOrderItem 订单项信息
     * @return 结果
     */
    public int updateOmsOrderItem(OmsOrderItem omsOrderItem);

    /**
     * 批量删除订单项信息
     * 
     * @param ids 需要删除的订单项信息主键集合
     * @return 结果
     */
    public int deleteOmsOrderItemByIds(Long[] ids);

    /**
     * 删除订单项信息信息
     * 
     * @param id 订单项信息主键
     * @return 结果
     */
    public int deleteOmsOrderItemById(Long id);
}
