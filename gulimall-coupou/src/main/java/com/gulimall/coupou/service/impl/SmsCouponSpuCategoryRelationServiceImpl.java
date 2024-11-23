package com.gulimall.coupou.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupou.mapper.SmsCouponSpuCategoryRelationMapper;
import com.gulimall.coupou.domain.SmsCouponSpuCategoryRelation;
import com.gulimall.coupou.service.ISmsCouponSpuCategoryRelationService;

/**
 * 优惠券分类关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class SmsCouponSpuCategoryRelationServiceImpl implements ISmsCouponSpuCategoryRelationService 
{
    @Autowired
    private SmsCouponSpuCategoryRelationMapper smsCouponSpuCategoryRelationMapper;

    /**
     * 查询优惠券分类关联
     * 
     * @param id 优惠券分类关联主键
     * @return 优惠券分类关联
     */
    @Override
    public SmsCouponSpuCategoryRelation selectSmsCouponSpuCategoryRelationById(Long id)
    {
        return smsCouponSpuCategoryRelationMapper.selectSmsCouponSpuCategoryRelationById(id);
    }

    /**
     * 查询优惠券分类关联列表
     * 
     * @param smsCouponSpuCategoryRelation 优惠券分类关联
     * @return 优惠券分类关联
     */
    @Override
    public List<SmsCouponSpuCategoryRelation> selectSmsCouponSpuCategoryRelationList(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        return smsCouponSpuCategoryRelationMapper.selectSmsCouponSpuCategoryRelationList(smsCouponSpuCategoryRelation);
    }

    /**
     * 新增优惠券分类关联
     * 
     * @param smsCouponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    @Override
    public int insertSmsCouponSpuCategoryRelation(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        return smsCouponSpuCategoryRelationMapper.insertSmsCouponSpuCategoryRelation(smsCouponSpuCategoryRelation);
    }

    /**
     * 修改优惠券分类关联
     * 
     * @param smsCouponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    @Override
    public int updateSmsCouponSpuCategoryRelation(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation)
    {
        return smsCouponSpuCategoryRelationMapper.updateSmsCouponSpuCategoryRelation(smsCouponSpuCategoryRelation);
    }

    /**
     * 批量删除优惠券分类关联
     * 
     * @param ids 需要删除的优惠券分类关联主键
     * @return 结果
     */
    @Override
    public int deleteSmsCouponSpuCategoryRelationByIds(Long[] ids)
    {
        return smsCouponSpuCategoryRelationMapper.deleteSmsCouponSpuCategoryRelationByIds(ids);
    }

    /**
     * 删除优惠券分类关联信息
     * 
     * @param id 优惠券分类关联主键
     * @return 结果
     */
    @Override
    public int deleteSmsCouponSpuCategoryRelationById(Long id)
    {
        return smsCouponSpuCategoryRelationMapper.deleteSmsCouponSpuCategoryRelationById(id);
    }
}
