package com.gulimall.coupou.service;

import java.util.List;
import com.gulimall.coupou.domain.SmsSeckillPromotion;

/**
 * 秒杀活动Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface ISmsSeckillPromotionService 
{
    /**
     * 查询秒杀活动
     * 
     * @param id 秒杀活动主键
     * @return 秒杀活动
     */
    public SmsSeckillPromotion selectSmsSeckillPromotionById(Long id);

    /**
     * 查询秒杀活动列表
     * 
     * @param smsSeckillPromotion 秒杀活动
     * @return 秒杀活动集合
     */
    public List<SmsSeckillPromotion> selectSmsSeckillPromotionList(SmsSeckillPromotion smsSeckillPromotion);

    /**
     * 新增秒杀活动
     * 
     * @param smsSeckillPromotion 秒杀活动
     * @return 结果
     */
    public int insertSmsSeckillPromotion(SmsSeckillPromotion smsSeckillPromotion);

    /**
     * 修改秒杀活动
     * 
     * @param smsSeckillPromotion 秒杀活动
     * @return 结果
     */
    public int updateSmsSeckillPromotion(SmsSeckillPromotion smsSeckillPromotion);

    /**
     * 批量删除秒杀活动
     * 
     * @param ids 需要删除的秒杀活动主键集合
     * @return 结果
     */
    public int deleteSmsSeckillPromotionByIds(Long[] ids);

    /**
     * 删除秒杀活动信息
     * 
     * @param id 秒杀活动主键
     * @return 结果
     */
    public int deleteSmsSeckillPromotionById(Long id);
}
