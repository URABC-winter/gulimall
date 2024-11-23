package com.gulimall.ware.service.impl;

import java.util.List;
import com.gulimall.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.ware.mapper.WmsWareOrderTaskMapper;
import com.gulimall.ware.domain.WmsWareOrderTask;
import com.gulimall.ware.service.IWmsWareOrderTaskService;

/**
 * 库存工作单Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class WmsWareOrderTaskServiceImpl implements IWmsWareOrderTaskService 
{
    @Autowired
    private WmsWareOrderTaskMapper wmsWareOrderTaskMapper;

    /**
     * 查询库存工作单
     * 
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    @Override
    public WmsWareOrderTask selectWmsWareOrderTaskById(Long id)
    {
        return wmsWareOrderTaskMapper.selectWmsWareOrderTaskById(id);
    }

    /**
     * 查询库存工作单列表
     * 
     * @param wmsWareOrderTask 库存工作单
     * @return 库存工作单
     */
    @Override
    public List<WmsWareOrderTask> selectWmsWareOrderTaskList(WmsWareOrderTask wmsWareOrderTask)
    {
        return wmsWareOrderTaskMapper.selectWmsWareOrderTaskList(wmsWareOrderTask);
    }

    /**
     * 新增库存工作单
     * 
     * @param wmsWareOrderTask 库存工作单
     * @return 结果
     */
    @Override
    public int insertWmsWareOrderTask(WmsWareOrderTask wmsWareOrderTask)
    {
        wmsWareOrderTask.setCreateTime(DateUtils.getNowDate());
        return wmsWareOrderTaskMapper.insertWmsWareOrderTask(wmsWareOrderTask);
    }

    /**
     * 修改库存工作单
     * 
     * @param wmsWareOrderTask 库存工作单
     * @return 结果
     */
    @Override
    public int updateWmsWareOrderTask(WmsWareOrderTask wmsWareOrderTask)
    {
        return wmsWareOrderTaskMapper.updateWmsWareOrderTask(wmsWareOrderTask);
    }

    /**
     * 批量删除库存工作单
     * 
     * @param ids 需要删除的库存工作单主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareOrderTaskByIds(Long[] ids)
    {
        return wmsWareOrderTaskMapper.deleteWmsWareOrderTaskByIds(ids);
    }

    /**
     * 删除库存工作单信息
     * 
     * @param id 库存工作单主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareOrderTaskById(Long id)
    {
        return wmsWareOrderTaskMapper.deleteWmsWareOrderTaskById(id);
    }
}
