package com.gulimall.product.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.PmsCategoryMapper;
import com.gulimall.product.domain.PmsCategory;
import com.gulimall.product.service.IPmsCategoryService;

/**
 * 商品三级分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
@Service
public class PmsCategoryServiceImpl implements IPmsCategoryService 
{
    @Autowired
    private PmsCategoryMapper pmsCategoryMapper;

    /**
     * 查询商品三级分类
     * 
     * @param catId 商品三级分类主键
     * @return 商品三级分类
     */
    @Override
    public PmsCategory selectPmsCategoryByCatId(Long catId)
    {
        return pmsCategoryMapper.selectPmsCategoryByCatId(catId);
    }

    /**
     * 查询商品三级分类列表
     * 
     * @param pmsCategory 商品三级分类
     * @return 商品三级分类
     */
    @Override
    public List<PmsCategory> selectPmsCategoryList(PmsCategory pmsCategory)
    {
        return pmsCategoryMapper.selectPmsCategoryList(pmsCategory);
    }

    /**
     * 新增商品三级分类
     * 
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int insertPmsCategory(PmsCategory pmsCategory)
    {
        return pmsCategoryMapper.insertPmsCategory(pmsCategory);
    }

    /**
     * 修改商品三级分类
     * 
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int updatePmsCategory(PmsCategory pmsCategory)
    {
        return pmsCategoryMapper.updatePmsCategory(pmsCategory);
    }

    /**
     * 批量删除商品三级分类
     * 
     * @param catIds 需要删除的商品三级分类主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryByCatIds(Long[] catIds)
    {
        return pmsCategoryMapper.deletePmsCategoryByCatIds(catIds);
    }

    /**
     * 删除商品三级分类信息
     * 
     * @param catId 商品三级分类主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryByCatId(Long catId)
    {
        return pmsCategoryMapper.deletePmsCategoryByCatId(catId);
    }

    @Override
    public List<PmsCategory> selectPmsCategoryListTree(PmsCategory pmsCategory) {
        pmsCategory.setShowStatus(1L);
        List<PmsCategory> list = pmsCategoryMapper.selectPmsCategoryList(pmsCategory);
        List<PmsCategory> level1Menus = list.stream().filter(
                menu -> menu.getParentCid() == 0
        ).map((menu) -> {
            menu.setChildrens(getChildrens(menu, list));
            return menu;
        }).sorted((menu1,menu2) -> {
                    return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
                }
        ).collect(Collectors.toList());
        //return getDataTable(list);
        return level1Menus;
    }

    @Override
    public int updatePmsCategoryList(List<PmsCategory> pmsCategory) {
        return pmsCategoryMapper.updatePmsCategoryList(pmsCategory);
    }

    @Override
    public Long[] getCatlogPath(Long catId) {
        PmsCategory pmsCategory3 = pmsCategoryMapper.selectPmsCategoryByCatId(catId);
        PmsCategory pmsCategory2 = pmsCategoryMapper.selectPmsCategoryByCatId(pmsCategory3.getParentCid());
        PmsCategory pmsCategory1 = pmsCategoryMapper.selectPmsCategoryByCatId(pmsCategory2.getParentCid());
        return new Long[]{pmsCategory1.getCatId(),pmsCategory2.getCatId(),pmsCategory3.getCatId()};
    }

    private List<PmsCategory> getChildrens(PmsCategory root, List<PmsCategory> list) {
        List<PmsCategory> children = list.stream().filter(
                menu -> menu.getParentCid().equals(root.getCatId())
        ).map((menu) -> {
            menu.setChildrens(getChildrens(menu, list));
            return menu;
        }).sorted((menu1,menu2) -> {
                    return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
                }
        ).collect(Collectors.toList());
        return children;
    }
}
