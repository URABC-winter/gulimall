package com.gulimall.product.mapper;

import java.util.List;
import com.gulimall.product.domain.PmsSpuImages;

/**
 * spu图片Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface PmsSpuImagesMapper 
{
    /**
     * 查询spu图片
     * 
     * @param id spu图片主键
     * @return spu图片
     */
    public PmsSpuImages selectPmsSpuImagesById(Long id);

    /**
     * 查询spu图片列表
     * 
     * @param pmsSpuImages spu图片
     * @return spu图片集合
     */
    public List<PmsSpuImages> selectPmsSpuImagesList(PmsSpuImages pmsSpuImages);

    /**
     * 新增spu图片
     * 
     * @param pmsSpuImages spu图片
     * @return 结果
     */
    public int insertPmsSpuImages(PmsSpuImages pmsSpuImages);

    /**
     * 修改spu图片
     * 
     * @param pmsSpuImages spu图片
     * @return 结果
     */
    public int updatePmsSpuImages(PmsSpuImages pmsSpuImages);

    /**
     * 删除spu图片
     * 
     * @param id spu图片主键
     * @return 结果
     */
    public int deletePmsSpuImagesById(Long id);

    /**
     * 批量删除spu图片
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsSpuImagesByIds(Long[] ids);
}
