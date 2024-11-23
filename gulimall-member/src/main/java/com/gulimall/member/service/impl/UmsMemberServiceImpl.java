package com.gulimall.member.service.impl;

import java.util.List;
import com.gulimall.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.UmsMemberMapper;
import com.gulimall.member.domain.UmsMember;
import com.gulimall.member.service.IUmsMemberService;

/**
 * 会员Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class UmsMemberServiceImpl implements IUmsMemberService 
{
    @Autowired
    private UmsMemberMapper umsMemberMapper;

    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    @Override
    public UmsMember selectUmsMemberById(Long id)
    {
        return umsMemberMapper.selectUmsMemberById(id);
    }

    /**
     * 查询会员列表
     * 
     * @param umsMember 会员
     * @return 会员
     */
    @Override
    public List<UmsMember> selectUmsMemberList(UmsMember umsMember)
    {
        return umsMemberMapper.selectUmsMemberList(umsMember);
    }

    /**
     * 新增会员
     * 
     * @param umsMember 会员
     * @return 结果
     */
    @Override
    public int insertUmsMember(UmsMember umsMember)
    {
        umsMember.setCreateTime(DateUtils.getNowDate());
        return umsMemberMapper.insertUmsMember(umsMember);
    }

    /**
     * 修改会员
     * 
     * @param umsMember 会员
     * @return 结果
     */
    @Override
    public int updateUmsMember(UmsMember umsMember)
    {
        return umsMemberMapper.updateUmsMember(umsMember);
    }

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的会员主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberByIds(Long[] ids)
    {
        return umsMemberMapper.deleteUmsMemberByIds(ids);
    }

    /**
     * 删除会员信息
     * 
     * @param id 会员主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberById(Long id)
    {
        return umsMemberMapper.deleteUmsMemberById(id);
    }
}
