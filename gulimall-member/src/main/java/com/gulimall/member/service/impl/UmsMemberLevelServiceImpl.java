package com.gulimall.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.UmsMemberLevelMapper;
import com.gulimall.member.domain.UmsMemberLevel;
import com.gulimall.member.service.IUmsMemberLevelService;

/**
 * 会员等级Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class UmsMemberLevelServiceImpl implements IUmsMemberLevelService 
{
    @Autowired
    private UmsMemberLevelMapper umsMemberLevelMapper;

    /**
     * 查询会员等级
     * 
     * @param id 会员等级主键
     * @return 会员等级
     */
    @Override
    public UmsMemberLevel selectUmsMemberLevelById(Long id)
    {
        return umsMemberLevelMapper.selectUmsMemberLevelById(id);
    }

    /**
     * 查询会员等级列表
     * 
     * @param umsMemberLevel 会员等级
     * @return 会员等级
     */
    @Override
    public List<UmsMemberLevel> selectUmsMemberLevelList(UmsMemberLevel umsMemberLevel)
    {
        return umsMemberLevelMapper.selectUmsMemberLevelList(umsMemberLevel);
    }

    /**
     * 新增会员等级
     * 
     * @param umsMemberLevel 会员等级
     * @return 结果
     */
    @Override
    public int insertUmsMemberLevel(UmsMemberLevel umsMemberLevel)
    {
        return umsMemberLevelMapper.insertUmsMemberLevel(umsMemberLevel);
    }

    /**
     * 修改会员等级
     * 
     * @param umsMemberLevel 会员等级
     * @return 结果
     */
    @Override
    public int updateUmsMemberLevel(UmsMemberLevel umsMemberLevel)
    {
        return umsMemberLevelMapper.updateUmsMemberLevel(umsMemberLevel);
    }

    /**
     * 批量删除会员等级
     * 
     * @param ids 需要删除的会员等级主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberLevelByIds(Long[] ids)
    {
        return umsMemberLevelMapper.deleteUmsMemberLevelByIds(ids);
    }

    /**
     * 删除会员等级信息
     * 
     * @param id 会员等级主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberLevelById(Long id)
    {
        return umsMemberLevelMapper.deleteUmsMemberLevelById(id);
    }
}
