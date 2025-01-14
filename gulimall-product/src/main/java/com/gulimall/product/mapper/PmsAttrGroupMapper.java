package com.gulimall.product.mapper;

import java.util.List;
import com.gulimall.product.domain.PmsAttrGroup;

/**
 * 属性分组Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface PmsAttrGroupMapper 
{
    /**
     * 查询属性分组
     * 
     * @param attrGroupId 属性分组主键
     * @return 属性分组
     */
    public PmsAttrGroup selectPmsAttrGroupByAttrGroupId(Long attrGroupId);

    /**
     * 查询属性分组列表
     * 
     * @param pmsAttrGroup 属性分组
     * @return 属性分组集合
     */
    public List<PmsAttrGroup> selectPmsAttrGroupList(PmsAttrGroup pmsAttrGroup);

    /**
     * 新增属性分组
     * 
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    public int insertPmsAttrGroup(PmsAttrGroup pmsAttrGroup);

    /**
     * 修改属性分组
     * 
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    public int updatePmsAttrGroup(PmsAttrGroup pmsAttrGroup);

    /**
     * 删除属性分组
     * 
     * @param attrGroupId 属性分组主键
     * @return 结果
     */
    public int deletePmsAttrGroupByAttrGroupId(Long attrGroupId);

    /**
     * 批量删除属性分组
     * 
     * @param attrGroupIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsAttrGroupByAttrGroupIds(Long[] attrGroupIds);
}
