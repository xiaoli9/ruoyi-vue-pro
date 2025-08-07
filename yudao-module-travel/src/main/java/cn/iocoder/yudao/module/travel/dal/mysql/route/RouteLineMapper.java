package cn.iocoder.yudao.module.travel.dal.mysql.route;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.travel.dal.dataobject.route.RouteLineDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 画线 Mapper
 *
 * @author alex
 */
@Mapper
public interface RouteLineMapper extends BaseMapperX<RouteLineDO> {

    default List<RouteLineDO> selectListByRouteId(Long routeId) {
        return selectList(RouteLineDO::getRouteId, routeId);
    }

    default int deleteByRouteId(Long routeId) {
        return delete(RouteLineDO::getRouteId, routeId);
    }

	default int deleteByRouteIds(List<Long> routeIds) {
	    return deleteBatch(RouteLineDO::getRouteId, routeIds);
	}

}