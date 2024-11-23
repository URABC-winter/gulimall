package com.gulimall.coupou.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupou.mapper.SmsMemberPriceMapper;
import com.gulimall.coupou.domain.SmsMemberPrice;
import com.gulimall.coupou.service.ISmsMemberPriceService;

/**
 * 商品会员价格Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class SmsMemberPriceServiceImpl implements ISmsMemberPriceService 
{
    @Autowired
    private SmsMemberPriceMapper smsMemberPriceMapper;

    /**
     * 查询商品会员价格
     * 
     * @param id 商品会员价格主键
     * @return 商品会员价格
     */
    @Override
    public SmsMemberPrice selectSmsMemberPriceById(Long id)
    {
        return smsMemberPriceMapper.selectSmsMemberPriceById(id);
    }

    /**
     * 查询商品会员价格列表
     * 
     * @param smsMemberPrice 商品会员价格
     * @return 商品会员价格
     */
    @Override
    public List<SmsMemberPrice> selectSmsMemberPriceList(SmsMemberPrice smsMemberPrice)
    {
        return smsMemberPriceMapper.selectSmsMemberPriceList(smsMemberPrice);
    }

    /**
     * 新增商品会员价格
     * 
     * @param smsMemberPrice 商品会员价格
     * @return 结果
     */
    @Override
    public int insertSmsMemberPrice(SmsMemberPrice smsMemberPrice)
    {
        return smsMemberPriceMapper.insertSmsMemberPrice(smsMemberPrice);
    }

    /**
     * 修改商品会员价格
     * 
     * @param smsMemberPrice 商品会员价格
     * @return 结果
     */
    @Override
    public int updateSmsMemberPrice(SmsMemberPrice smsMemberPrice)
    {
        return smsMemberPriceMapper.updateSmsMemberPrice(smsMemberPrice);
    }

    /**
     * 批量删除商品会员价格
     * 
     * @param ids 需要删除的商品会员价格主键
     * @return 结果
     */
    @Override
    public int deleteSmsMemberPriceByIds(Long[] ids)
    {
        return smsMemberPriceMapper.deleteSmsMemberPriceByIds(ids);
    }

    /**
     * 删除商品会员价格信息
     * 
     * @param id 商品会员价格主键
     * @return 结果
     */
    @Override
    public int deleteSmsMemberPriceById(Long id)
    {
        return smsMemberPriceMapper.deleteSmsMemberPriceById(id);
    }
}
