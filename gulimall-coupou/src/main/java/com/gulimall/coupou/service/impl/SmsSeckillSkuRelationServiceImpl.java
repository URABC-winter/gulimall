package com.gulimall.coupou.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupou.mapper.SmsSeckillSkuRelationMapper;
import com.gulimall.coupou.domain.SmsSeckillSkuRelation;
import com.gulimall.coupou.service.ISmsSeckillSkuRelationService;

/**
 * 秒杀活动商品关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class SmsSeckillSkuRelationServiceImpl implements ISmsSeckillSkuRelationService 
{
    @Autowired
    private SmsSeckillSkuRelationMapper smsSeckillSkuRelationMapper;

    /**
     * 查询秒杀活动商品关联
     * 
     * @param id 秒杀活动商品关联主键
     * @return 秒杀活动商品关联
     */
    @Override
    public SmsSeckillSkuRelation selectSmsSeckillSkuRelationById(Long id)
    {
        return smsSeckillSkuRelationMapper.selectSmsSeckillSkuRelationById(id);
    }

    /**
     * 查询秒杀活动商品关联列表
     * 
     * @param smsSeckillSkuRelation 秒杀活动商品关联
     * @return 秒杀活动商品关联
     */
    @Override
    public List<SmsSeckillSkuRelation> selectSmsSeckillSkuRelationList(SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        return smsSeckillSkuRelationMapper.selectSmsSeckillSkuRelationList(smsSeckillSkuRelation);
    }

    /**
     * 新增秒杀活动商品关联
     * 
     * @param smsSeckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    @Override
    public int insertSmsSeckillSkuRelation(SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        return smsSeckillSkuRelationMapper.insertSmsSeckillSkuRelation(smsSeckillSkuRelation);
    }

    /**
     * 修改秒杀活动商品关联
     * 
     * @param smsSeckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    @Override
    public int updateSmsSeckillSkuRelation(SmsSeckillSkuRelation smsSeckillSkuRelation)
    {
        return smsSeckillSkuRelationMapper.updateSmsSeckillSkuRelation(smsSeckillSkuRelation);
    }

    /**
     * 批量删除秒杀活动商品关联
     * 
     * @param ids 需要删除的秒杀活动商品关联主键
     * @return 结果
     */
    @Override
    public int deleteSmsSeckillSkuRelationByIds(Long[] ids)
    {
        return smsSeckillSkuRelationMapper.deleteSmsSeckillSkuRelationByIds(ids);
    }

    /**
     * 删除秒杀活动商品关联信息
     * 
     * @param id 秒杀活动商品关联主键
     * @return 结果
     */
    @Override
    public int deleteSmsSeckillSkuRelationById(Long id)
    {
        return smsSeckillSkuRelationMapper.deleteSmsSeckillSkuRelationById(id);
    }
}
