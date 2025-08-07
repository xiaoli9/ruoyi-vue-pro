package cn.iocoder.yudao.module.travel.convert.route;

import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.module.travel.controller.app.route.vo.AppRouteListRespVO;
import cn.iocoder.yudao.module.travel.dal.dataobject.route.RouteDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RouteConvert {

    RouteConvert INSTANCE = Mappers.getMapper(RouteConvert.class);

    @Mapping(target = "routeId", source = "route.id")
    @Mapping(target = "vip", source = "route.isVip")
    AppRouteListRespVO convert(RouteDO route);

    default List<AppRouteListRespVO> convertList(List<RouteDO> list) {
        return CollectionUtils.convertList(list, scenic ->
                convert(scenic)
        );
    }

}
