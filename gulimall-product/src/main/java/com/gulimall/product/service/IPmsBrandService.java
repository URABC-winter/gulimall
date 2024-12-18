package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.PmsBrand;

/**
 * 品牌Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IPmsBrandService 
{
    /**
     * 查询品牌
     * 
     * @param brandId 品牌主键
     * @return 品牌
     */
    public PmsBrand selectPmsBrandByBrandId(Long brandId);

    /**
     * 查询品牌列表
     * 
     * @param pmsBrand 品牌
     * @return 品牌集合
     */
    public List<PmsBrand> selectPmsBrandList(PmsBrand pmsBrand);

    /**
     * 新增品牌
     * 
     * @param pmsBrand 品牌
     * @return 结果
     */
    public int insertPmsBrand(PmsBrand pmsBrand);

    /**
     * 修改品牌
     * 
     * @param pmsBrand 品牌
     * @return 结果
     */
    public int updatePmsBrand(PmsBrand pmsBrand);

    /**
     * 批量删除品牌
     * 
     * @param brandIds 需要删除的品牌主键集合
     * @return 结果
     */
    public int deletePmsBrandByBrandIds(Long[] brandIds);

    /**
     * 删除品牌信息
     * 
     * @param brandId 品牌主键
     * @return 结果
     */
    public int deletePmsBrandByBrandId(Long brandId);
}
