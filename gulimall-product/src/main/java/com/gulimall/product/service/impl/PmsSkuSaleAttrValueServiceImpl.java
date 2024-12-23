package com.gulimall.product.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.PmsSkuSaleAttrValueMapper;
import com.gulimall.product.domain.PmsSkuSaleAttrValue;
import com.gulimall.product.service.IPmsSkuSaleAttrValueService;

/**
 * sku销售属性&值Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class PmsSkuSaleAttrValueServiceImpl implements IPmsSkuSaleAttrValueService 
{
    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    /**
     * 查询sku销售属性&值
     * 
     * @param id sku销售属性&值主键
     * @return sku销售属性&值
     */
    @Override
    public PmsSkuSaleAttrValue selectPmsSkuSaleAttrValueById(Long id)
    {
        return pmsSkuSaleAttrValueMapper.selectPmsSkuSaleAttrValueById(id);
    }

    /**
     * 查询sku销售属性&值列表
     * 
     * @param pmsSkuSaleAttrValue sku销售属性&值
     * @return sku销售属性&值
     */
    @Override
    public List<PmsSkuSaleAttrValue> selectPmsSkuSaleAttrValueList(PmsSkuSaleAttrValue pmsSkuSaleAttrValue)
    {
        return pmsSkuSaleAttrValueMapper.selectPmsSkuSaleAttrValueList(pmsSkuSaleAttrValue);
    }

    /**
     * 新增sku销售属性&值
     * 
     * @param pmsSkuSaleAttrValue sku销售属性&值
     * @return 结果
     */
    @Override
    public int insertPmsSkuSaleAttrValue(PmsSkuSaleAttrValue pmsSkuSaleAttrValue)
    {
        return pmsSkuSaleAttrValueMapper.insertPmsSkuSaleAttrValue(pmsSkuSaleAttrValue);
    }

    /**
     * 修改sku销售属性&值
     * 
     * @param pmsSkuSaleAttrValue sku销售属性&值
     * @return 结果
     */
    @Override
    public int updatePmsSkuSaleAttrValue(PmsSkuSaleAttrValue pmsSkuSaleAttrValue)
    {
        return pmsSkuSaleAttrValueMapper.updatePmsSkuSaleAttrValue(pmsSkuSaleAttrValue);
    }

    /**
     * 批量删除sku销售属性&值
     * 
     * @param ids 需要删除的sku销售属性&值主键
     * @return 结果
     */
    @Override
    public int deletePmsSkuSaleAttrValueByIds(Long[] ids)
    {
        return pmsSkuSaleAttrValueMapper.deletePmsSkuSaleAttrValueByIds(ids);
    }

    /**
     * 删除sku销售属性&值信息
     * 
     * @param id sku销售属性&值主键
     * @return 结果
     */
    @Override
    public int deletePmsSkuSaleAttrValueById(Long id)
    {
        return pmsSkuSaleAttrValueMapper.deletePmsSkuSaleAttrValueById(id);
    }
}
