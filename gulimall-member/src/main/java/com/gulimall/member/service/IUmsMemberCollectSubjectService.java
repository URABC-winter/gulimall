package com.gulimall.member.service;

import java.util.List;
import com.gulimall.member.domain.UmsMemberCollectSubject;

/**
 * 会员收藏的专题活动Service接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface IUmsMemberCollectSubjectService 
{
    /**
     * 查询会员收藏的专题活动
     * 
     * @param id 会员收藏的专题活动主键
     * @return 会员收藏的专题活动
     */
    public UmsMemberCollectSubject selectUmsMemberCollectSubjectById(Long id);

    /**
     * 查询会员收藏的专题活动列表
     * 
     * @param umsMemberCollectSubject 会员收藏的专题活动
     * @return 会员收藏的专题活动集合
     */
    public List<UmsMemberCollectSubject> selectUmsMemberCollectSubjectList(UmsMemberCollectSubject umsMemberCollectSubject);

    /**
     * 新增会员收藏的专题活动
     * 
     * @param umsMemberCollectSubject 会员收藏的专题活动
     * @return 结果
     */
    public int insertUmsMemberCollectSubject(UmsMemberCollectSubject umsMemberCollectSubject);

    /**
     * 修改会员收藏的专题活动
     * 
     * @param umsMemberCollectSubject 会员收藏的专题活动
     * @return 结果
     */
    public int updateUmsMemberCollectSubject(UmsMemberCollectSubject umsMemberCollectSubject);

    /**
     * 批量删除会员收藏的专题活动
     * 
     * @param ids 需要删除的会员收藏的专题活动主键集合
     * @return 结果
     */
    public int deleteUmsMemberCollectSubjectByIds(Long[] ids);

    /**
     * 删除会员收藏的专题活动信息
     * 
     * @param id 会员收藏的专题活动主键
     * @return 结果
     */
    public int deleteUmsMemberCollectSubjectById(Long id);
}