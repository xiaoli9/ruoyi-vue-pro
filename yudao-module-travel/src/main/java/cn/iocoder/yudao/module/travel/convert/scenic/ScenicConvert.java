package cn.iocoder.yudao.module.travel.convert.scenic;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.travel.controller.app.poi.vo.AppMapPoiVO;
import cn.iocoder.yudao.module.travel.controller.app.scenic.vo.AppMapRespVO;
import cn.iocoder.yudao.module.travel.controller.app.favorite.vo.AppScenicCollectRespVO;
import cn.iocoder.yudao.module.travel.controller.app.scenic.vo.AppScenicPageRespVO;
import cn.iocoder.yudao.module.travel.controller.app.scenic.vo.AppScenicRespVO;
import cn.iocoder.yudao.module.travel.convert.poi.PoiConvert;
import cn.iocoder.yudao.module.travel.dal.dataobject.poi.PoiDO;
import cn.iocoder.yudao.module.travel.dal.dataobject.scenic.ScenicDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ScenicConvert {

    ScenicConvert INSTANCE = Mappers.getMapper(ScenicConvert.class);

    @Mapping(target = "scenicId", source = "scenic.id")
    AppScenicRespVO convert(ScenicDO scenic);

    @Mapping(target = "scenicId", source = "scenic.id")
    AppMapRespVO convert2(ScenicDO scenic);

    @Mapping(target = "scenicId", source = "scenic.id")
    AppScenicPageRespVO convert3(ScenicDO scenic);


    default AppMapRespVO convert(ScenicDO scenic, List<PoiDO> poiList) {
        AppMapRespVO res = convert2(scenic);

        List<AppMapPoiVO> poiRespList = CollectionUtils.convertList(poiList, poi -> {
            return PoiConvert.INSTANCE.convert(poi);
        });
        res.setPoiList(poiRespList);

        return res;
    }

    default List<AppScenicPageRespVO> convertList(List<ScenicDO> list) {
        return CollectionUtils.convertList(list, scenic ->
                convert3(scenic)
        );
    }

    default PageResult<AppScenicCollectRespVO> convertList(List<ScenicDO> list, boolean collected, Long totalCount) {
        List<AppScenicCollectRespVO> appPoiCollectRespVOS = CollectionUtils.convertList(list, scenic -> {
            AppScenicCollectRespVO appPoiPageRespVO = BeanUtils.toBean(scenic, AppScenicCollectRespVO.class);
            appPoiPageRespVO.setScenicId(scenic.getId());
            appPoiPageRespVO.setCollected(collected);
            return appPoiPageRespVO;
        });

        return new PageResult<>(appPoiCollectRespVOS, totalCount);
    }
}
