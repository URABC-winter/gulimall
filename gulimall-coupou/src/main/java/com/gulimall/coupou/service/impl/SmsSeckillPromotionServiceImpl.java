package com.gulimall.coupou.service.impl;

import java.util.List;
import com.gulimall.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupou.mapper.SmsSeckillPromotionMapper;
import com.gulimall.coupou.domain.SmsSeckillPromotion;
import com.gulimall.coupou.service.ISmsSeckillPromotionService;

/**
 * 秒杀活动Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class SmsSeckillPromotionServiceImpl implements ISmsSeckillPromotionService 
{
    @Autowired
    private SmsSeckillPromotionMapper smsSeckillPromotionMapper;

    /**
     * 查询秒杀活动
     * 
     * @param id 秒杀活动主键
     * @return 秒杀活动
     */
    @Override
    public SmsSeckillPromotion selectSmsSeckillPromotionById(Long id)
    {
        return smsSeckillPromotionMapper.selectSmsSeckillPromotionById(id);
    }

    /**
     * 查询秒杀活动列表
     * 
     * @param smsSeckillPromotion 秒杀活动
     * @return 秒杀活动
     */
    @Override
    public List<SmsSeckillPromotion> selectSmsSeckillPromotionList(SmsSeckillPromotion smsSeckillPromotion)
    {
        return smsSeckillPromotionMapper.selectSmsSeckillPromotionList(smsSeckillPromotion);
    }

    /**
     * 新增秒杀活动
     * 
     * @param smsSeckillPromotion 秒杀活动
     * @return 结果
     */
    @Override
    public int insertSmsSeckillPromotion(SmsSeckillPromotion smsSeckillPromotion)
    {
        smsSeckillPromotion.setCreateTime(DateUtils.getNowDate());
        return smsSeckillPromotionMapper.insertSmsSeckillPromotion(smsSeckillPromotion);
    }

    /**
     * 修改秒杀活动
     * 
     * @param smsSeckillPromotion 秒杀活动
     * @return 结果
     */
    @Override
    public int updateSmsSeckillPromotion(SmsSeckillPromotion smsSeckillPromotion)
    {
        return smsSeckillPromotionMapper.updateSmsSeckillPromotion(smsSeckillPromotion);
    }

    /**
     * 批量删除秒杀活动
     * 
     * @param ids 需要删除的秒杀活动主键
     * @return 结果
     */
    @Override
    public int deleteSmsSeckillPromotionByIds(Long[] ids)
    {
        return smsSeckillPromotionMapper.deleteSmsSeckillPromotionByIds(ids);
    }

    /**
     * 删除秒杀活动信息
     * 
     * @param id 秒杀活动主键
     * @return 结果
     */
    @Override
    public int deleteSmsSeckillPromotionById(Long id)
    {
        return smsSeckillPromotionMapper.deleteSmsSeckillPromotionById(id);
    }
}
