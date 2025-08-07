package cn.iocoder.yudao.module.travel.service.scenic;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.travel.controller.admin.scenic.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.scenic.ScenicDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 景区 Service 接口
 *
 * @author alex
 */
public interface ScenicService {

    /**
     * 创建景区
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createScenic(@Valid ScenicSaveReqVO createReqVO);

    /**
     * 更新景区
     *
     * @param updateReqVO 更新信息
     */
    void updateScenic(@Valid ScenicSaveReqVO updateReqVO);

    /**
     * 删除景区
     *
     * @param id 编号
     */
    void deleteScenic(Long id);

    /**
    * 批量删除景区
    *
    * @param ids 编号
    */
    void deleteScenicListByIds(List<Long> ids);

    /**
     * 获得景区
     *
     * @param id 编号
     * @return 景区
     */
    ScenicDO getScenic(Long id);

    /**
     * 获得景区分页
     *
     * @param pageReqVO 分页查询
     * @return 景区分页
     */
    PageResult<ScenicDO> getScenicPage(ScenicPageReqVO pageReqVO);

    List<ScenicDO> listScenicListByIds(Set<Long> scenicIds);
}