package com.gulimall.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.UmsMemberStatisticsInfoMapper;
import com.gulimall.member.domain.UmsMemberStatisticsInfo;
import com.gulimall.member.service.IUmsMemberStatisticsInfoService;

/**
 * 会员统计信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class UmsMemberStatisticsInfoServiceImpl implements IUmsMemberStatisticsInfoService 
{
    @Autowired
    private UmsMemberStatisticsInfoMapper umsMemberStatisticsInfoMapper;

    /**
     * 查询会员统计信息
     * 
     * @param id 会员统计信息主键
     * @return 会员统计信息
     */
    @Override
    public UmsMemberStatisticsInfo selectUmsMemberStatisticsInfoById(Long id)
    {
        return umsMemberStatisticsInfoMapper.selectUmsMemberStatisticsInfoById(id);
    }

    /**
     * 查询会员统计信息列表
     * 
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 会员统计信息
     */
    @Override
    public List<UmsMemberStatisticsInfo> selectUmsMemberStatisticsInfoList(UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        return umsMemberStatisticsInfoMapper.selectUmsMemberStatisticsInfoList(umsMemberStatisticsInfo);
    }

    /**
     * 新增会员统计信息
     * 
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 结果
     */
    @Override
    public int insertUmsMemberStatisticsInfo(UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        return umsMemberStatisticsInfoMapper.insertUmsMemberStatisticsInfo(umsMemberStatisticsInfo);
    }

    /**
     * 修改会员统计信息
     * 
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 结果
     */
    @Override
    public int updateUmsMemberStatisticsInfo(UmsMemberStatisticsInfo umsMemberStatisticsInfo)
    {
        return umsMemberStatisticsInfoMapper.updateUmsMemberStatisticsInfo(umsMemberStatisticsInfo);
    }

    /**
     * 批量删除会员统计信息
     * 
     * @param ids 需要删除的会员统计信息主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberStatisticsInfoByIds(Long[] ids)
    {
        return umsMemberStatisticsInfoMapper.deleteUmsMemberStatisticsInfoByIds(ids);
    }

    /**
     * 删除会员统计信息信息
     * 
     * @param id 会员统计信息主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberStatisticsInfoById(Long id)
    {
        return umsMemberStatisticsInfoMapper.deleteUmsMemberStatisticsInfoById(id);
    }
}
