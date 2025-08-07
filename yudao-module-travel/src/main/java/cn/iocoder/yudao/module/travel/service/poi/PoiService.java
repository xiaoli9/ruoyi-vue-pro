package cn.iocoder.yudao.module.travel.service.poi;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.travel.controller.admin.poi.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.poi.PoiDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 景点POI Service 接口
 *
 * @author alex
 */
public interface PoiService {

    /**
     * 创建景点POI
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPoi(@Valid PoiSaveReqVO createReqVO);

    /**
     * 更新景点POI
     *
     * @param updateReqVO 更新信息
     */
    void updatePoi(@Valid PoiSaveReqVO updateReqVO);

    /**
     * 删除景点POI
     *
     * @param id 编号
     */
    void deletePoi(Long id);

    /**
    * 批量删除景点POI
    *
    * @param ids 编号
    */
    void deletePoiListByIds(List<Long> ids);

    /**
     * 获得景点POI
     *
     * @param id 编号
     * @return 景点POI
     */
    PoiDO getPoi(Long id);

    /**
     * 获得景点POI分页
     *
     * @param pageReqVO 分页查询
     * @return 景点POI分页
     */
    PageResult<PoiDO> getPoiPage(PoiPageReqVO pageReqVO);

    List<PoiDO> listPoiListByIds(Set<Long> poiIds);
}