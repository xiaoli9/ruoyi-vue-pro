package cn.iocoder.yudao.module.travel.service.resvalue;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.travel.controller.admin.resvalue.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.resvalue.ResValueDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 资源 Service 接口
 *
 * @author alex
 */
public interface ResValueService {

    /**
     * 创建资源
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createResValue(@Valid ResValueSaveReqVO createReqVO);

    /**
     * 更新资源
     *
     * @param updateReqVO 更新信息
     */
    void updateResValue(@Valid ResValueSaveReqVO updateReqVO);

    /**
     * 删除资源
     *
     * @param id 编号
     */
    void deleteResValue(Long id);

    /**
    * 批量删除资源
    *
    * @param ids 编号
    */
    void deleteResValueListByIds(List<Long> ids);

    /**
     * 获得资源
     *
     * @param id 编号
     * @return 资源
     */
    ResValueDO getResValue(Long id);

    /**
     * 获得资源分页
     *
     * @param pageReqVO 分页查询
     * @return 资源分页
     */
    PageResult<ResValueDO> getResValuePage(ResValuePageReqVO pageReqVO);

}