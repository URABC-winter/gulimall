package com.gulimall.coupou.service;

import java.util.List;
import com.gulimall.coupou.domain.SmsHomeSubjectSpu;

/**
 * 专题商品Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface ISmsHomeSubjectSpuService 
{
    /**
     * 查询专题商品
     * 
     * @param id 专题商品主键
     * @return 专题商品
     */
    public SmsHomeSubjectSpu selectSmsHomeSubjectSpuById(Long id);

    /**
     * 查询专题商品列表
     * 
     * @param smsHomeSubjectSpu 专题商品
     * @return 专题商品集合
     */
    public List<SmsHomeSubjectSpu> selectSmsHomeSubjectSpuList(SmsHomeSubjectSpu smsHomeSubjectSpu);

    /**
     * 新增专题商品
     * 
     * @param smsHomeSubjectSpu 专题商品
     * @return 结果
     */
    public int insertSmsHomeSubjectSpu(SmsHomeSubjectSpu smsHomeSubjectSpu);

    /**
     * 修改专题商品
     * 
     * @param smsHomeSubjectSpu 专题商品
     * @return 结果
     */
    public int updateSmsHomeSubjectSpu(SmsHomeSubjectSpu smsHomeSubjectSpu);

    /**
     * 批量删除专题商品
     * 
     * @param ids 需要删除的专题商品主键集合
     * @return 结果
     */
    public int deleteSmsHomeSubjectSpuByIds(Long[] ids);

    /**
     * 删除专题商品信息
     * 
     * @param id 专题商品主键
     * @return 结果
     */
    public int deleteSmsHomeSubjectSpuById(Long id);
}
