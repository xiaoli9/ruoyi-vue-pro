package cn.iocoder.yudao.module.travel.dal.mysql.route;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.travel.dal.dataobject.route.RouteDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.travel.controller.admin.route.vo.*;

/**
 * 路线 Mapper
 *
 * @author alex
 */
@Mapper
public interface RouteMapper extends BaseMapperX<RouteDO> {

    default PageResult<RouteDO> selectPage(RoutePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RouteDO>()
                .eqIfPresent(RouteDO::getScenicId, reqVO.getScenicId())
                .eqIfPresent(RouteDO::getTitle, reqVO.getTitle())
                .eqIfPresent(RouteDO::getDescription, reqVO.getDescription())
                .eqIfPresent(RouteDO::getDuration, reqVO.getDuration())
                .eqIfPresent(RouteDO::getDistance, reqVO.getDistance())
                .eqIfPresent(RouteDO::getCoverUrl, reqVO.getCoverUrl())
                .eqIfPresent(RouteDO::getIsVip, reqVO.getIsVip())
                .eqIfPresent(RouteDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(RouteDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RouteDO::getId));
    }

}