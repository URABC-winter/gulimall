package com.gulimall.ware.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.ware.mapper.WmsWareOrderTaskDetailMapper;
import com.gulimall.ware.domain.WmsWareOrderTaskDetail;
import com.gulimall.ware.service.IWmsWareOrderTaskDetailService;

/**
 * 库存工作单Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class WmsWareOrderTaskDetailServiceImpl implements IWmsWareOrderTaskDetailService 
{
    @Autowired
    private WmsWareOrderTaskDetailMapper wmsWareOrderTaskDetailMapper;

    /**
     * 查询库存工作单
     * 
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    @Override
    public WmsWareOrderTaskDetail selectWmsWareOrderTaskDetailById(Long id)
    {
        return wmsWareOrderTaskDetailMapper.selectWmsWareOrderTaskDetailById(id);
    }

    /**
     * 查询库存工作单列表
     * 
     * @param wmsWareOrderTaskDetail 库存工作单
     * @return 库存工作单
     */
    @Override
    public List<WmsWareOrderTaskDetail> selectWmsWareOrderTaskDetailList(WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        return wmsWareOrderTaskDetailMapper.selectWmsWareOrderTaskDetailList(wmsWareOrderTaskDetail);
    }

    /**
     * 新增库存工作单
     * 
     * @param wmsWareOrderTaskDetail 库存工作单
     * @return 结果
     */
    @Override
    public int insertWmsWareOrderTaskDetail(WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        return wmsWareOrderTaskDetailMapper.insertWmsWareOrderTaskDetail(wmsWareOrderTaskDetail);
    }

    /**
     * 修改库存工作单
     * 
     * @param wmsWareOrderTaskDetail 库存工作单
     * @return 结果
     */
    @Override
    public int updateWmsWareOrderTaskDetail(WmsWareOrderTaskDetail wmsWareOrderTaskDetail)
    {
        return wmsWareOrderTaskDetailMapper.updateWmsWareOrderTaskDetail(wmsWareOrderTaskDetail);
    }

    /**
     * 批量删除库存工作单
     * 
     * @param ids 需要删除的库存工作单主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareOrderTaskDetailByIds(Long[] ids)
    {
        return wmsWareOrderTaskDetailMapper.deleteWmsWareOrderTaskDetailByIds(ids);
    }

    /**
     * 删除库存工作单信息
     * 
     * @param id 库存工作单主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareOrderTaskDetailById(Long id)
    {
        return wmsWareOrderTaskDetailMapper.deleteWmsWareOrderTaskDetailById(id);
    }
}
