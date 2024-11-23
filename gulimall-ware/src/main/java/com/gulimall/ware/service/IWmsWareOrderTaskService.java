package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.WmsWareOrderTask;

/**
 * 库存工作单Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IWmsWareOrderTaskService 
{
    /**
     * 查询库存工作单
     * 
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    public WmsWareOrderTask selectWmsWareOrderTaskById(Long id);

    /**
     * 查询库存工作单列表
     * 
     * @param wmsWareOrderTask 库存工作单
     * @return 库存工作单集合
     */
    public List<WmsWareOrderTask> selectWmsWareOrderTaskList(WmsWareOrderTask wmsWareOrderTask);

    /**
     * 新增库存工作单
     * 
     * @param wmsWareOrderTask 库存工作单
     * @return 结果
     */
    public int insertWmsWareOrderTask(WmsWareOrderTask wmsWareOrderTask);

    /**
     * 修改库存工作单
     * 
     * @param wmsWareOrderTask 库存工作单
     * @return 结果
     */
    public int updateWmsWareOrderTask(WmsWareOrderTask wmsWareOrderTask);

    /**
     * 批量删除库存工作单
     * 
     * @param ids 需要删除的库存工作单主键集合
     * @return 结果
     */
    public int deleteWmsWareOrderTaskByIds(Long[] ids);

    /**
     * 删除库存工作单信息
     * 
     * @param id 库存工作单主键
     * @return 结果
     */
    public int deleteWmsWareOrderTaskById(Long id);
}
