package com.gulimall.coupou.mapper;

import java.util.List;
import com.gulimall.coupou.domain.SmsSpuBounds;

/**
 * 商品spu积分设置Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface SmsSpuBoundsMapper 
{
    /**
     * 查询商品spu积分设置
     * 
     * @param id 商品spu积分设置主键
     * @return 商品spu积分设置
     */
    public SmsSpuBounds selectSmsSpuBoundsById(Long id);

    /**
     * 查询商品spu积分设置列表
     * 
     * @param smsSpuBounds 商品spu积分设置
     * @return 商品spu积分设置集合
     */
    public List<SmsSpuBounds> selectSmsSpuBoundsList(SmsSpuBounds smsSpuBounds);

    /**
     * 新增商品spu积分设置
     * 
     * @param smsSpuBounds 商品spu积分设置
     * @return 结果
     */
    public int insertSmsSpuBounds(SmsSpuBounds smsSpuBounds);

    /**
     * 修改商品spu积分设置
     * 
     * @param smsSpuBounds 商品spu积分设置
     * @return 结果
     */
    public int updateSmsSpuBounds(SmsSpuBounds smsSpuBounds);

    /**
     * 删除商品spu积分设置
     * 
     * @param id 商品spu积分设置主键
     * @return 结果
     */
    public int deleteSmsSpuBoundsById(Long id);

    /**
     * 批量删除商品spu积分设置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSmsSpuBoundsByIds(Long[] ids);
}
