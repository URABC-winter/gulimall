package com.gulimall.coupou.service;

import java.util.List;
import com.gulimall.coupou.domain.SmsCouponSpuCategoryRelation;

/**
 * 优惠券分类关联Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface ISmsCouponSpuCategoryRelationService 
{
    /**
     * 查询优惠券分类关联
     * 
     * @param id 优惠券分类关联主键
     * @return 优惠券分类关联
     */
    public SmsCouponSpuCategoryRelation selectSmsCouponSpuCategoryRelationById(Long id);

    /**
     * 查询优惠券分类关联列表
     * 
     * @param smsCouponSpuCategoryRelation 优惠券分类关联
     * @return 优惠券分类关联集合
     */
    public List<SmsCouponSpuCategoryRelation> selectSmsCouponSpuCategoryRelationList(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /**
     * 新增优惠券分类关联
     * 
     * @param smsCouponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    public int insertSmsCouponSpuCategoryRelation(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /**
     * 修改优惠券分类关联
     * 
     * @param smsCouponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    public int updateSmsCouponSpuCategoryRelation(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /**
     * 批量删除优惠券分类关联
     * 
     * @param ids 需要删除的优惠券分类关联主键集合
     * @return 结果
     */
    public int deleteSmsCouponSpuCategoryRelationByIds(Long[] ids);

    /**
     * 删除优惠券分类关联信息
     * 
     * @param id 优惠券分类关联主键
     * @return 结果
     */
    public int deleteSmsCouponSpuCategoryRelationById(Long id);
}
