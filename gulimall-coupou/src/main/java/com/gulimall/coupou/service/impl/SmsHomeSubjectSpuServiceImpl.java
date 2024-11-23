package com.gulimall.coupou.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupou.mapper.SmsHomeSubjectSpuMapper;
import com.gulimall.coupou.domain.SmsHomeSubjectSpu;
import com.gulimall.coupou.service.ISmsHomeSubjectSpuService;

/**
 * 专题商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class SmsHomeSubjectSpuServiceImpl implements ISmsHomeSubjectSpuService 
{
    @Autowired
    private SmsHomeSubjectSpuMapper smsHomeSubjectSpuMapper;

    /**
     * 查询专题商品
     * 
     * @param id 专题商品主键
     * @return 专题商品
     */
    @Override
    public SmsHomeSubjectSpu selectSmsHomeSubjectSpuById(Long id)
    {
        return smsHomeSubjectSpuMapper.selectSmsHomeSubjectSpuById(id);
    }

    /**
     * 查询专题商品列表
     * 
     * @param smsHomeSubjectSpu 专题商品
     * @return 专题商品
     */
    @Override
    public List<SmsHomeSubjectSpu> selectSmsHomeSubjectSpuList(SmsHomeSubjectSpu smsHomeSubjectSpu)
    {
        return smsHomeSubjectSpuMapper.selectSmsHomeSubjectSpuList(smsHomeSubjectSpu);
    }

    /**
     * 新增专题商品
     * 
     * @param smsHomeSubjectSpu 专题商品
     * @return 结果
     */
    @Override
    public int insertSmsHomeSubjectSpu(SmsHomeSubjectSpu smsHomeSubjectSpu)
    {
        return smsHomeSubjectSpuMapper.insertSmsHomeSubjectSpu(smsHomeSubjectSpu);
    }

    /**
     * 修改专题商品
     * 
     * @param smsHomeSubjectSpu 专题商品
     * @return 结果
     */
    @Override
    public int updateSmsHomeSubjectSpu(SmsHomeSubjectSpu smsHomeSubjectSpu)
    {
        return smsHomeSubjectSpuMapper.updateSmsHomeSubjectSpu(smsHomeSubjectSpu);
    }

    /**
     * 批量删除专题商品
     * 
     * @param ids 需要删除的专题商品主键
     * @return 结果
     */
    @Override
    public int deleteSmsHomeSubjectSpuByIds(Long[] ids)
    {
        return smsHomeSubjectSpuMapper.deleteSmsHomeSubjectSpuByIds(ids);
    }

    /**
     * 删除专题商品信息
     * 
     * @param id 专题商品主键
     * @return 结果
     */
    @Override
    public int deleteSmsHomeSubjectSpuById(Long id)
    {
        return smsHomeSubjectSpuMapper.deleteSmsHomeSubjectSpuById(id);
    }
}
