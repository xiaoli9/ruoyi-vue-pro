package cn.iocoder.yudao.module.travel.dal.mysql.scenic;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.travel.dal.dataobject.scenic.ScenicDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.travel.controller.admin.scenic.vo.*;

/**
 * 景区 Mapper
 *
 * @author alex
 */
@Mapper
public interface ScenicMapper extends BaseMapperX<ScenicDO> {

    default PageResult<ScenicDO> selectPage(ScenicPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ScenicDO>()
                .likeIfPresent(ScenicDO::getName, reqVO.getName())
                .eqIfPresent(ScenicDO::getCoverUrl, reqVO.getCoverUrl())
                .eqIfPresent(ScenicDO::getDescription, reqVO.getDescription())
                .eqIfPresent(ScenicDO::getHasAr, reqVO.getHasAr())
                .eqIfPresent(ScenicDO::getBgUrl, reqVO.getBgUrl())
                .eqIfPresent(ScenicDO::getBgBounds, reqVO.getBgBounds())
                .eqIfPresent(ScenicDO::getAudioUrl, reqVO.getAudioUrl())
                .eqIfPresent(ScenicDO::getRichText, reqVO.getRichText())
                .eqIfPresent(ScenicDO::getAddress, reqVO.getAddress())
                .eqIfPresent(ScenicDO::getIsVip, reqVO.getIsVip())
                .eqIfPresent(ScenicDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ScenicDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ScenicDO::getId));
    }

}