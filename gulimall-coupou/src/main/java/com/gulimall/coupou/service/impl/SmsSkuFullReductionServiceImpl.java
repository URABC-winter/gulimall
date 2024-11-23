package com.gulimall.coupou.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupou.mapper.SmsSkuFullReductionMapper;
import com.gulimall.coupou.domain.SmsSkuFullReduction;
import com.gulimall.coupou.service.ISmsSkuFullReductionService;

/**
 * 商品满减信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class SmsSkuFullReductionServiceImpl implements ISmsSkuFullReductionService 
{
    @Autowired
    private SmsSkuFullReductionMapper smsSkuFullReductionMapper;

    /**
     * 查询商品满减信息
     * 
     * @param id 商品满减信息主键
     * @return 商品满减信息
     */
    @Override
    public SmsSkuFullReduction selectSmsSkuFullReductionById(Long id)
    {
        return smsSkuFullReductionMapper.selectSmsSkuFullReductionById(id);
    }

    /**
     * 查询商品满减信息列表
     * 
     * @param smsSkuFullReduction 商品满减信息
     * @return 商品满减信息
     */
    @Override
    public List<SmsSkuFullReduction> selectSmsSkuFullReductionList(SmsSkuFullReduction smsSkuFullReduction)
    {
        return smsSkuFullReductionMapper.selectSmsSkuFullReductionList(smsSkuFullReduction);
    }

    /**
     * 新增商品满减信息
     * 
     * @param smsSkuFullReduction 商品满减信息
     * @return 结果
     */
    @Override
    public int insertSmsSkuFullReduction(SmsSkuFullReduction smsSkuFullReduction)
    {
        return smsSkuFullReductionMapper.insertSmsSkuFullReduction(smsSkuFullReduction);
    }

    /**
     * 修改商品满减信息
     * 
     * @param smsSkuFullReduction 商品满减信息
     * @return 结果
     */
    @Override
    public int updateSmsSkuFullReduction(SmsSkuFullReduction smsSkuFullReduction)
    {
        return smsSkuFullReductionMapper.updateSmsSkuFullReduction(smsSkuFullReduction);
    }

    /**
     * 批量删除商品满减信息
     * 
     * @param ids 需要删除的商品满减信息主键
     * @return 结果
     */
    @Override
    public int deleteSmsSkuFullReductionByIds(Long[] ids)
    {
        return smsSkuFullReductionMapper.deleteSmsSkuFullReductionByIds(ids);
    }

    /**
     * 删除商品满减信息信息
     * 
     * @param id 商品满减信息主键
     * @return 结果
     */
    @Override
    public int deleteSmsSkuFullReductionById(Long id)
    {
        return smsSkuFullReductionMapper.deleteSmsSkuFullReductionById(id);
    }
}
