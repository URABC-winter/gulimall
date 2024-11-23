package com.gulimall.coupou.mapper;

import java.util.List;
import com.gulimall.coupou.domain.SmsSeckillSession;

/**
 * 秒杀活动场次Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface SmsSeckillSessionMapper 
{
    /**
     * 查询秒杀活动场次
     * 
     * @param id 秒杀活动场次主键
     * @return 秒杀活动场次
     */
    public SmsSeckillSession selectSmsSeckillSessionById(Long id);

    /**
     * 查询秒杀活动场次列表
     * 
     * @param smsSeckillSession 秒杀活动场次
     * @return 秒杀活动场次集合
     */
    public List<SmsSeckillSession> selectSmsSeckillSessionList(SmsSeckillSession smsSeckillSession);

    /**
     * 新增秒杀活动场次
     * 
     * @param smsSeckillSession 秒杀活动场次
     * @return 结果
     */
    public int insertSmsSeckillSession(SmsSeckillSession smsSeckillSession);

    /**
     * 修改秒杀活动场次
     * 
     * @param smsSeckillSession 秒杀活动场次
     * @return 结果
     */
    public int updateSmsSeckillSession(SmsSeckillSession smsSeckillSession);

    /**
     * 删除秒杀活动场次
     * 
     * @param id 秒杀活动场次主键
     * @return 结果
     */
    public int deleteSmsSeckillSessionById(Long id);

    /**
     * 批量删除秒杀活动场次
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSmsSeckillSessionByIds(Long[] ids);
}
