package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.WmsPurchaseDetail;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IWmsPurchaseDetailService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public WmsPurchaseDetail selectWmsPurchaseDetailById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param wmsPurchaseDetail 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<WmsPurchaseDetail> selectWmsPurchaseDetailList(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 新增【请填写功能名称】
     * 
     * @param wmsPurchaseDetail 【请填写功能名称】
     * @return 结果
     */
    public int insertWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 修改【请填写功能名称】
     * 
     * @param wmsPurchaseDetail 【请填写功能名称】
     * @return 结果
     */
    public int updateWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteWmsPurchaseDetailByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteWmsPurchaseDetailById(Long id);
}
