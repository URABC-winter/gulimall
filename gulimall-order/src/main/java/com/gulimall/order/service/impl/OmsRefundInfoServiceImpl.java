package com.gulimall.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.order.mapper.OmsRefundInfoMapper;
import com.gulimall.order.domain.OmsRefundInfo;
import com.gulimall.order.service.IOmsRefundInfoService;

/**
 * 退款信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class OmsRefundInfoServiceImpl implements IOmsRefundInfoService 
{
    @Autowired
    private OmsRefundInfoMapper omsRefundInfoMapper;

    /**
     * 查询退款信息
     * 
     * @param id 退款信息主键
     * @return 退款信息
     */
    @Override
    public OmsRefundInfo selectOmsRefundInfoById(Long id)
    {
        return omsRefundInfoMapper.selectOmsRefundInfoById(id);
    }

    /**
     * 查询退款信息列表
     * 
     * @param omsRefundInfo 退款信息
     * @return 退款信息
     */
    @Override
    public List<OmsRefundInfo> selectOmsRefundInfoList(OmsRefundInfo omsRefundInfo)
    {
        return omsRefundInfoMapper.selectOmsRefundInfoList(omsRefundInfo);
    }

    /**
     * 新增退款信息
     * 
     * @param omsRefundInfo 退款信息
     * @return 结果
     */
    @Override
    public int insertOmsRefundInfo(OmsRefundInfo omsRefundInfo)
    {
        return omsRefundInfoMapper.insertOmsRefundInfo(omsRefundInfo);
    }

    /**
     * 修改退款信息
     * 
     * @param omsRefundInfo 退款信息
     * @return 结果
     */
    @Override
    public int updateOmsRefundInfo(OmsRefundInfo omsRefundInfo)
    {
        return omsRefundInfoMapper.updateOmsRefundInfo(omsRefundInfo);
    }

    /**
     * 批量删除退款信息
     * 
     * @param ids 需要删除的退款信息主键
     * @return 结果
     */
    @Override
    public int deleteOmsRefundInfoByIds(Long[] ids)
    {
        return omsRefundInfoMapper.deleteOmsRefundInfoByIds(ids);
    }

    /**
     * 删除退款信息信息
     * 
     * @param id 退款信息主键
     * @return 结果
     */
    @Override
    public int deleteOmsRefundInfoById(Long id)
    {
        return omsRefundInfoMapper.deleteOmsRefundInfoById(id);
    }
}
