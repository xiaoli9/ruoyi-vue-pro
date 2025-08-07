package cn.iocoder.yudao.module.travel.dal.mysql.poi;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.travel.dal.dataobject.poi.PoiDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.travel.controller.admin.poi.vo.*;

/**
 * 景点POI Mapper
 *
 * @author alex
 */
@Mapper
public interface PoiMapper extends BaseMapperX<PoiDO> {

    default PageResult<PoiDO> selectPage(PoiPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PoiDO>()
                .eqIfPresent(PoiDO::getScenicId, reqVO.getScenicId())
                .likeIfPresent(PoiDO::getName, reqVO.getName())
                .eqIfPresent(PoiDO::getIconUrl, reqVO.getIconUrl())
                .likeIfPresent(PoiDO::getDescription, reqVO.getDescription())
                .eqIfPresent(PoiDO::getCoverUrl, reqVO.getCoverUrl())
                .eqIfPresent(PoiDO::getHasAr, reqVO.getHasAr())
                .eqIfPresent(PoiDO::getIsVip, reqVO.getIsVip())
                .eqIfPresent(PoiDO::getModule, reqVO.getModule())
                .likeIfPresent(PoiDO::getRichText, reqVO.getRichText())
                .eqIfPresent(PoiDO::getForward, reqVO.getForward())
                .eqIfPresent(PoiDO::getCategoryId, reqVO.getCategoryId())
                .eqIfPresent(PoiDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(PoiDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PoiDO::getId));
    }

}