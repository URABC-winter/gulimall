package com.gulimall.member.service;

import java.util.List;
import com.gulimall.member.domain.UmsMemberStatisticsInfo;

/**
 * 会员统计信息Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IUmsMemberStatisticsInfoService 
{
    /**
     * 查询会员统计信息
     * 
     * @param id 会员统计信息主键
     * @return 会员统计信息
     */
    public UmsMemberStatisticsInfo selectUmsMemberStatisticsInfoById(Long id);

    /**
     * 查询会员统计信息列表
     * 
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 会员统计信息集合
     */
    public List<UmsMemberStatisticsInfo> selectUmsMemberStatisticsInfoList(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /**
     * 新增会员统计信息
     * 
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 结果
     */
    public int insertUmsMemberStatisticsInfo(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /**
     * 修改会员统计信息
     * 
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 结果
     */
    public int updateUmsMemberStatisticsInfo(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /**
     * 批量删除会员统计信息
     * 
     * @param ids 需要删除的会员统计信息主键集合
     * @return 结果
     */
    public int deleteUmsMemberStatisticsInfoByIds(Long[] ids);

    /**
     * 删除会员统计信息信息
     * 
     * @param id 会员统计信息主键
     * @return 结果
     */
    public int deleteUmsMemberStatisticsInfoById(Long id);
}
