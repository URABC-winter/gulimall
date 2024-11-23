package com.gulimall.ware.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.ware.mapper.WmsWareSkuMapper;
import com.gulimall.ware.domain.WmsWareSku;
import com.gulimall.ware.service.IWmsWareSkuService;

/**
 * 商品库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class WmsWareSkuServiceImpl implements IWmsWareSkuService 
{
    @Autowired
    private WmsWareSkuMapper wmsWareSkuMapper;

    /**
     * 查询商品库存
     * 
     * @param id 商品库存主键
     * @return 商品库存
     */
    @Override
    public WmsWareSku selectWmsWareSkuById(Long id)
    {
        return wmsWareSkuMapper.selectWmsWareSkuById(id);
    }

    /**
     * 查询商品库存列表
     * 
     * @param wmsWareSku 商品库存
     * @return 商品库存
     */
    @Override
    public List<WmsWareSku> selectWmsWareSkuList(WmsWareSku wmsWareSku)
    {
        return wmsWareSkuMapper.selectWmsWareSkuList(wmsWareSku);
    }

    /**
     * 新增商品库存
     * 
     * @param wmsWareSku 商品库存
     * @return 结果
     */
    @Override
    public int insertWmsWareSku(WmsWareSku wmsWareSku)
    {
        return wmsWareSkuMapper.insertWmsWareSku(wmsWareSku);
    }

    /**
     * 修改商品库存
     * 
     * @param wmsWareSku 商品库存
     * @return 结果
     */
    @Override
    public int updateWmsWareSku(WmsWareSku wmsWareSku)
    {
        return wmsWareSkuMapper.updateWmsWareSku(wmsWareSku);
    }

    /**
     * 批量删除商品库存
     * 
     * @param ids 需要删除的商品库存主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareSkuByIds(Long[] ids)
    {
        return wmsWareSkuMapper.deleteWmsWareSkuByIds(ids);
    }

    /**
     * 删除商品库存信息
     * 
     * @param id 商品库存主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareSkuById(Long id)
    {
        return wmsWareSkuMapper.deleteWmsWareSkuById(id);
    }
}
