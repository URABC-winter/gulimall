package com.gulimall.coupou.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupou.mapper.SmsSeckillSkuNoticeMapper;
import com.gulimall.coupou.domain.SmsSeckillSkuNotice;
import com.gulimall.coupou.service.ISmsSeckillSkuNoticeService;

/**
 * 秒杀商品通知订阅Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class SmsSeckillSkuNoticeServiceImpl implements ISmsSeckillSkuNoticeService 
{
    @Autowired
    private SmsSeckillSkuNoticeMapper smsSeckillSkuNoticeMapper;

    /**
     * 查询秒杀商品通知订阅
     * 
     * @param id 秒杀商品通知订阅主键
     * @return 秒杀商品通知订阅
     */
    @Override
    public SmsSeckillSkuNotice selectSmsSeckillSkuNoticeById(Long id)
    {
        return smsSeckillSkuNoticeMapper.selectSmsSeckillSkuNoticeById(id);
    }

    /**
     * 查询秒杀商品通知订阅列表
     * 
     * @param smsSeckillSkuNotice 秒杀商品通知订阅
     * @return 秒杀商品通知订阅
     */
    @Override
    public List<SmsSeckillSkuNotice> selectSmsSeckillSkuNoticeList(SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        return smsSeckillSkuNoticeMapper.selectSmsSeckillSkuNoticeList(smsSeckillSkuNotice);
    }

    /**
     * 新增秒杀商品通知订阅
     * 
     * @param smsSeckillSkuNotice 秒杀商品通知订阅
     * @return 结果
     */
    @Override
    public int insertSmsSeckillSkuNotice(SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        return smsSeckillSkuNoticeMapper.insertSmsSeckillSkuNotice(smsSeckillSkuNotice);
    }

    /**
     * 修改秒杀商品通知订阅
     * 
     * @param smsSeckillSkuNotice 秒杀商品通知订阅
     * @return 结果
     */
    @Override
    public int updateSmsSeckillSkuNotice(SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        return smsSeckillSkuNoticeMapper.updateSmsSeckillSkuNotice(smsSeckillSkuNotice);
    }

    /**
     * 批量删除秒杀商品通知订阅
     * 
     * @param ids 需要删除的秒杀商品通知订阅主键
     * @return 结果
     */
    @Override
    public int deleteSmsSeckillSkuNoticeByIds(Long[] ids)
    {
        return smsSeckillSkuNoticeMapper.deleteSmsSeckillSkuNoticeByIds(ids);
    }

    /**
     * 删除秒杀商品通知订阅信息
     * 
     * @param id 秒杀商品通知订阅主键
     * @return 结果
     */
    @Override
    public int deleteSmsSeckillSkuNoticeById(Long id)
    {
        return smsSeckillSkuNoticeMapper.deleteSmsSeckillSkuNoticeById(id);
    }
}
