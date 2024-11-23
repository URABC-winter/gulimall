package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.WmsWareSku;

/**
 * 商品库存Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IWmsWareSkuService 
{
    /**
     * 查询商品库存
     * 
     * @param id 商品库存主键
     * @return 商品库存
     */
    public WmsWareSku selectWmsWareSkuById(Long id);

    /**
     * 查询商品库存列表
     * 
     * @param wmsWareSku 商品库存
     * @return 商品库存集合
     */
    public List<WmsWareSku> selectWmsWareSkuList(WmsWareSku wmsWareSku);

    /**
     * 新增商品库存
     * 
     * @param wmsWareSku 商品库存
     * @return 结果
     */
    public int insertWmsWareSku(WmsWareSku wmsWareSku);

    /**
     * 修改商品库存
     * 
     * @param wmsWareSku 商品库存
     * @return 结果
     */
    public int updateWmsWareSku(WmsWareSku wmsWareSku);

    /**
     * 批量删除商品库存
     * 
     * @param ids 需要删除的商品库存主键集合
     * @return 结果
     */
    public int deleteWmsWareSkuByIds(Long[] ids);

    /**
     * 删除商品库存信息
     * 
     * @param id 商品库存主键
     * @return 结果
     */
    public int deleteWmsWareSkuById(Long id);
}
