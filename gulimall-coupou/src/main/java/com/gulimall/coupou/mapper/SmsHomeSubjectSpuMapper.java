package com.gulimall.coupou.mapper;

import java.util.List;
import com.gulimall.coupou.domain.SmsHomeSubjectSpu;

/**
 * 专题商品Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface SmsHomeSubjectSpuMapper 
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
     * 删除专题商品
     * 
     * @param id 专题商品主键
     * @return 结果
     */
    public int deleteSmsHomeSubjectSpuById(Long id);

    /**
     * 批量删除专题商品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSmsHomeSubjectSpuByIds(Long[] ids);
}
