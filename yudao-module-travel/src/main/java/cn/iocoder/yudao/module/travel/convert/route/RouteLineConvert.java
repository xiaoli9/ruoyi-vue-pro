package cn.iocoder.yudao.module.travel.convert.route;

import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.module.travel.controller.app.route.vo.AppRouteLineRespVO;
import cn.iocoder.yudao.module.travel.dal.dataobject.route.RouteLineDO;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Mapper
public interface RouteLineConvert {

    RouteLineConvert INSTANCE = Mappers.getMapper(RouteLineConvert.class);

    @Mapping(target = "lineId", source = "route.id")
    default AppRouteLineRespVO convert(RouteLineDO route) {
        if (route == null) {
            return null;
        }

        AppRouteLineRespVO respVO = new AppRouteLineRespVO();
        respVO.setLineId(route.getId());

        String poiIdStr = route.getPoiIds();
        List<String> poiIds = Strings.isNullOrEmpty(poiIdStr) ? Collections.emptyList() : Arrays.asList(StringUtils.split(poiIdStr, ','));
        respVO.setPoiIds(poiIds);

//        // 解析为 List<Map<String, Object>>
//        List<Map<String, Object>> pointList = JSON.parseObject(
//                route.getPoints(),
//                new TypeReference<List<Map<String, Object>>>() {
//                }
//        );
        respVO.setPoints(route.getPoints());
        return respVO;
    }

    default List<AppRouteLineRespVO> convertList(List<RouteLineDO> list) {
        return CollectionUtils.convertList(list, line ->
                convert(line)
        );
    }

}
