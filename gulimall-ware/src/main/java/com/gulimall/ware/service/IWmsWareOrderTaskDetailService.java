package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.WmsWareOrderTaskDetail;

/**
 * 库存工作单Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IWmsWareOrderTaskDetailService 
{
    /**
     * 查询库存工作单
     * 
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    public WmsWareOrderTaskDetail selectWmsWareOrderTaskDetailById(Long id);

    /**
     * 查询库存工作单列表
     * 
     * @param wmsWareOrderTaskDetail 库存工作单
     * @return 库存工作单集合
     */
    public List<WmsWareOrderTaskDetail> selectWmsWareOrderTaskDetailList(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /**
     * 新增库存工作单
     * 
     * @param wmsWareOrderTaskDetail 库存工作单
     * @return 结果
     */
    public int insertWmsWareOrderTaskDetail(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /**
     * 修改库存工作单
     * 
     * @param wmsWareOrderTaskDetail 库存工作单
     * @return 结果
     */
    public int updateWmsWareOrderTaskDetail(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /**
     * 批量删除库存工作单
     * 
     * @param ids 需要删除的库存工作单主键集合
     * @return 结果
     */
    public int deleteWmsWareOrderTaskDetailByIds(Long[] ids);

    /**
     * 删除库存工作单信息
     * 
     * @param id 库存工作单主键
     * @return 结果
     */
    public int deleteWmsWareOrderTaskDetailById(Long id);
}
