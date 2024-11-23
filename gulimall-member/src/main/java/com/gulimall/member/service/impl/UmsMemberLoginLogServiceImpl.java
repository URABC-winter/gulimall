package com.gulimall.member.service.impl;

import java.util.List;
import com.gulimall.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.UmsMemberLoginLogMapper;
import com.gulimall.member.domain.UmsMemberLoginLog;
import com.gulimall.member.service.IUmsMemberLoginLogService;

/**
 * 会员登录记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class UmsMemberLoginLogServiceImpl implements IUmsMemberLoginLogService 
{
    @Autowired
    private UmsMemberLoginLogMapper umsMemberLoginLogMapper;

    /**
     * 查询会员登录记录
     * 
     * @param id 会员登录记录主键
     * @return 会员登录记录
     */
    @Override
    public UmsMemberLoginLog selectUmsMemberLoginLogById(Long id)
    {
        return umsMemberLoginLogMapper.selectUmsMemberLoginLogById(id);
    }

    /**
     * 查询会员登录记录列表
     * 
     * @param umsMemberLoginLog 会员登录记录
     * @return 会员登录记录
     */
    @Override
    public List<UmsMemberLoginLog> selectUmsMemberLoginLogList(UmsMemberLoginLog umsMemberLoginLog)
    {
        return umsMemberLoginLogMapper.selectUmsMemberLoginLogList(umsMemberLoginLog);
    }

    /**
     * 新增会员登录记录
     * 
     * @param umsMemberLoginLog 会员登录记录
     * @return 结果
     */
    @Override
    public int insertUmsMemberLoginLog(UmsMemberLoginLog umsMemberLoginLog)
    {
        umsMemberLoginLog.setCreateTime(DateUtils.getNowDate());
        return umsMemberLoginLogMapper.insertUmsMemberLoginLog(umsMemberLoginLog);
    }

    /**
     * 修改会员登录记录
     * 
     * @param umsMemberLoginLog 会员登录记录
     * @return 结果
     */
    @Override
    public int updateUmsMemberLoginLog(UmsMemberLoginLog umsMemberLoginLog)
    {
        return umsMemberLoginLogMapper.updateUmsMemberLoginLog(umsMemberLoginLog);
    }

    /**
     * 批量删除会员登录记录
     * 
     * @param ids 需要删除的会员登录记录主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberLoginLogByIds(Long[] ids)
    {
        return umsMemberLoginLogMapper.deleteUmsMemberLoginLogByIds(ids);
    }

    /**
     * 删除会员登录记录信息
     * 
     * @param id 会员登录记录主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberLoginLogById(Long id)
    {
        return umsMemberLoginLogMapper.deleteUmsMemberLoginLogById(id);
    }
}
