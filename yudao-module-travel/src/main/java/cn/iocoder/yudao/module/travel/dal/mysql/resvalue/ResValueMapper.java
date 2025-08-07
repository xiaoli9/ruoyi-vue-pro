package cn.iocoder.yudao.module.travel.dal.mysql.resvalue;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.travel.dal.dataobject.resvalue.ResValueDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.travel.controller.admin.resvalue.vo.*;

/**
 * 资源 Mapper
 *
 * @author alex
 */
@Mapper
public interface ResValueMapper extends BaseMapperX<ResValueDO> {

    default PageResult<ResValueDO> selectPage(ResValuePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ResValueDO>()
                .eqIfPresent(ResValueDO::getEntityType, reqVO.getEntityType())
                .eqIfPresent(ResValueDO::getEntityId, reqVO.getEntityId())
                .likeIfPresent(ResValueDO::getAttrName, reqVO.getAttrName())
                .eqIfPresent(ResValueDO::getAttrValue, reqVO.getAttrValue())
                .betweenIfPresent(ResValueDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ResValueDO::getId));
    }

}