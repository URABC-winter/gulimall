package com.gulimall.ware.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.ware.mapper.WmsPurchaseDetailMapper;
import com.gulimall.ware.domain.WmsPurchaseDetail;
import com.gulimall.ware.service.IWmsPurchaseDetailService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class WmsPurchaseDetailServiceImpl implements IWmsPurchaseDetailService 
{
    @Autowired
    private WmsPurchaseDetailMapper wmsPurchaseDetailMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public WmsPurchaseDetail selectWmsPurchaseDetailById(Long id)
    {
        return wmsPurchaseDetailMapper.selectWmsPurchaseDetailById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param wmsPurchaseDetail 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WmsPurchaseDetail> selectWmsPurchaseDetailList(WmsPurchaseDetail wmsPurchaseDetail)
    {
        return wmsPurchaseDetailMapper.selectWmsPurchaseDetailList(wmsPurchaseDetail);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param wmsPurchaseDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail)
    {
        return wmsPurchaseDetailMapper.insertWmsPurchaseDetail(wmsPurchaseDetail);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param wmsPurchaseDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail)
    {
        return wmsPurchaseDetailMapper.updateWmsPurchaseDetail(wmsPurchaseDetail);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteWmsPurchaseDetailByIds(Long[] ids)
    {
        return wmsPurchaseDetailMapper.deleteWmsPurchaseDetailByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteWmsPurchaseDetailById(Long id)
    {
        return wmsPurchaseDetailMapper.deleteWmsPurchaseDetailById(id);
    }
}
