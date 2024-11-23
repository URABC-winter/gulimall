package com.gulimall.coupou.service;

import java.util.List;
import com.gulimall.coupou.domain.SmsMemberPrice;

/**
 * 商品会员价格Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface ISmsMemberPriceService 
{
    /**
     * 查询商品会员价格
     * 
     * @param id 商品会员价格主键
     * @return 商品会员价格
     */
    public SmsMemberPrice selectSmsMemberPriceById(Long id);

    /**
     * 查询商品会员价格列表
     * 
     * @param smsMemberPrice 商品会员价格
     * @return 商品会员价格集合
     */
    public List<SmsMemberPrice> selectSmsMemberPriceList(SmsMemberPrice smsMemberPrice);

    /**
     * 新增商品会员价格
     * 
     * @param smsMemberPrice 商品会员价格
     * @return 结果
     */
    public int insertSmsMemberPrice(SmsMemberPrice smsMemberPrice);

    /**
     * 修改商品会员价格
     * 
     * @param smsMemberPrice 商品会员价格
     * @return 结果
     */
    public int updateSmsMemberPrice(SmsMemberPrice smsMemberPrice);

    /**
     * 批量删除商品会员价格
     * 
     * @param ids 需要删除的商品会员价格主键集合
     * @return 结果
     */
    public int deleteSmsMemberPriceByIds(Long[] ids);

    /**
     * 删除商品会员价格信息
     * 
     * @param id 商品会员价格主键
     * @return 结果
     */
    public int deleteSmsMemberPriceById(Long id);
}
