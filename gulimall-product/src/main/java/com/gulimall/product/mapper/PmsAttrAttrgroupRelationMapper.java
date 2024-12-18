package com.gulimall.product.mapper;

import java.util.List;
import com.gulimall.product.domain.PmsAttrAttrgroupRelation;

/**
 * 属性&属性分组关联Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface PmsAttrAttrgroupRelationMapper 
{
    /**
     * 查询属性&属性分组关联
     * 
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    public PmsAttrAttrgroupRelation selectPmsAttrAttrgroupRelationById(Long id);

    /**
     * 查询属性&属性分组关联列表
     * 
     * @param pmsAttrAttrgroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联集合
     */
    public List<PmsAttrAttrgroupRelation> selectPmsAttrAttrgroupRelationList(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /**
     * 新增属性&属性分组关联
     * 
     * @param pmsAttrAttrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    public int insertPmsAttrAttrgroupRelation(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /**
     * 修改属性&属性分组关联
     * 
     * @param pmsAttrAttrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    public int updatePmsAttrAttrgroupRelation(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /**
     * 删除属性&属性分组关联
     * 
     * @param id 属性&属性分组关联主键
     * @return 结果
     */
    public int deletePmsAttrAttrgroupRelationById(Long id);

    /**
     * 批量删除属性&属性分组关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsAttrAttrgroupRelationByIds(Long[] ids);
}
