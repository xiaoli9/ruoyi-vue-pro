package cn.iocoder.yudao.module.travel.dal.mysql.favorite;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.travel.controller.admin.favorite.vo.UserFavoritePageReqVO;
import cn.iocoder.yudao.module.travel.dal.dataobject.favorite.UserFavoriteDO;
import cn.iocoder.yudao.module.travel.enums.FavoriteTypeEnum;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户收藏 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface UserFavoriteMapper extends BaseMapperX<UserFavoriteDO> {

    default PageResult<UserFavoriteDO> selectPage(UserFavoritePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<UserFavoriteDO>()
                .eqIfPresent(UserFavoriteDO::getUserId, reqVO.getUserId())
                .eqIfPresent(UserFavoriteDO::getItemType, reqVO.getItemType())
                .eqIfPresent(UserFavoriteDO::getItemId, reqVO.getItemId())
                .betweenIfPresent(UserFavoriteDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(UserFavoriteDO::getId));
    }

    default UserFavoriteDO selectByUserId(Long userId, FavoriteTypeEnum type, Long itemId) {
        return selectOne(UserFavoriteDO::getUserId, userId, UserFavoriteDO::getItemType, type.getCode(), UserFavoriteDO::getItemId, itemId);
    }
}