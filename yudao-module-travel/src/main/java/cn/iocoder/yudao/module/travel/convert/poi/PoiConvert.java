package cn.iocoder.yudao.module.travel.convert.poi;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.travel.controller.app.favorite.vo.AppPoiCollectRespVO;
import cn.iocoder.yudao.module.travel.controller.app.poi.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.poi.PoiDO;
import org.bouncycastle.util.Strings;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PoiConvert {

    PoiConvert INSTANCE = Mappers.getMapper(PoiConvert.class);

    @Mapping(target = "poiId", source = "poi.id")
    AppMapPoiVO convert(PoiDO poi);

    @Mapping(target = "poiId", source = "poi.id")
    default AppPoiSimpleRespVO convert(PoiDO poi, boolean collected) {
        AppPoiSimpleRespVO appPoiSimpleRespVO = BeanUtils.toBean(poi, AppPoiSimpleRespVO.class);
        appPoiSimpleRespVO.setPoiId(poi.getId());

        List<AppPoiModuleVO> list = convertModule(poi.getModule());
        appPoiSimpleRespVO.setModules(list);

        return appPoiSimpleRespVO.setCollected(collected);
    }

    @Mapping(target = "poiId", source = "poi.id")
    default AppPoiRespVO convert2(PoiDO poi) {
        AppPoiRespVO appPoiSimpleRespVO = BeanUtils.toBean(poi, AppPoiRespVO.class);
        appPoiSimpleRespVO.setPoiId(poi.getId());

        List<AppPoiModuleVO> list = convertModule(poi.getModule());

        return appPoiSimpleRespVO.setModules(list);
    }

    default List<AppPoiPageRespVO> convertList(List<PoiDO> list) {
        return CollectionUtils.convertList(list, poi -> {
            AppPoiPageRespVO appPoiPageRespVO = BeanUtils.toBean(poi, AppPoiPageRespVO.class);
            appPoiPageRespVO.setPoiId(poi.getId());
            appPoiPageRespVO.setModules(convertModule(poi.getModule()));
            return appPoiPageRespVO;
        });
    }

    default PageResult<AppPoiCollectRespVO> convertList(List<PoiDO> list, boolean collected, Long totalCount) {
        List<AppPoiCollectRespVO> appPoiCollectRespVOS = CollectionUtils.convertList(list, poi -> {
            AppPoiCollectRespVO appPoiPageRespVO = BeanUtils.toBean(poi, AppPoiCollectRespVO.class);
            appPoiPageRespVO.setPoiId(poi.getId());
            appPoiPageRespVO.setCollected(collected);
            return appPoiPageRespVO;
        });

        return new PageResult<>(appPoiCollectRespVOS, totalCount);
    }

    default List<AppPoiModuleVO> convertModule(String moduleStr) {
        String[] split = Strings.split(moduleStr, '|');
        return Arrays.stream(split).map(s -> {
            String[] split1 = Strings.split(s, ',');
            return new AppPoiModuleVO().setModuleId(split1[0])
                    .setLock(split1[1])
                    .setVip(split1[2]);
        }).collect(Collectors.toList());
    }
}
