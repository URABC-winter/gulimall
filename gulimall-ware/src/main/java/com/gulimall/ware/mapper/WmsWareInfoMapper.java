package com.gulimall.ware.mapper;

import java.util.List;
import com.gulimall.ware.domain.WmsWareInfo;

/**
 * 仓库信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public interface WmsWareInfoMapper 
{
    /**
     * 查询仓库信息
     * 
     * @param id 仓库信息主键
     * @return 仓库信息
     */
    public WmsWareInfo selectWmsWareInfoById(Long id);

    /**
     * 查询仓库信息列表
     * 
     * @param wmsWareInfo 仓库信息
     * @return 仓库信息集合
     */
    public List<WmsWareInfo> selectWmsWareInfoList(WmsWareInfo wmsWareInfo);

    /**
     * 新增仓库信息
     * 
     * @param wmsWareInfo 仓库信息
     * @return 结果
     */
    public int insertWmsWareInfo(WmsWareInfo wmsWareInfo);

    /**
     * 修改仓库信息
     * 
     * @param wmsWareInfo 仓库信息
     * @return 结果
     */
    public int updateWmsWareInfo(WmsWareInfo wmsWareInfo);

    /**
     * 删除仓库信息
     * 
     * @param id 仓库信息主键
     * @return 结果
     */
    public int deleteWmsWareInfoById(Long id);

    /**
     * 批量删除仓库信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsWareInfoByIds(Long[] ids);
}
