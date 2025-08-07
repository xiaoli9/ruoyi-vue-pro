package cn.iocoder.yudao.module.travel.service.favorite;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.travel.controller.admin.favorite.vo.UserFavoritePageReqVO;
import cn.iocoder.yudao.module.travel.controller.admin.favorite.vo.UserFavoriteSaveReqVO;
import cn.iocoder.yudao.module.travel.dal.dataobject.favorite.UserFavoriteDO;
import cn.iocoder.yudao.module.travel.enums.FavoriteTypeEnum;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户收藏 Service 接口
 *
 * @author 芋道源码
 */
public interface UserFavoriteService {

    /**
     * 创建用户收藏
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createUserFavorite(@Valid UserFavoriteSaveReqVO createReqVO);

    /**
     * 更新用户收藏
     *
     * @param updateReqVO 更新信息
     */
    void updateUserFavorite(@Valid UserFavoriteSaveReqVO updateReqVO);

    /**
     * 删除用户收藏
     *
     * @param id 编号
     */
    void deleteUserFavorite(Long id);

    /**
     * 批量删除用户收藏
     *
     * @param ids 编号
     */
    void deleteUserFavoriteListByIds(List<Long> ids);

    /**
     * 获得用户收藏
     *
     * @param id 编号
     * @return 用户收藏
     */
    UserFavoriteDO getUserFavorite(Long id);

    /**
     * 根据用户编号、收藏类型、收藏项编号，获得用户收藏
     *
     * @param userId
     * @param itemType
     * @param itemId
     * @return
     */
    UserFavoriteDO getUserFavorite(Long userId, FavoriteTypeEnum itemType, Long itemId);

    /**
     * 获得用户收藏分页
     *
     * @param pageReqVO 分页查询
     * @return 用户收藏分页
     */
    PageResult<UserFavoriteDO> getUserFavoritePage(UserFavoritePageReqVO pageReqVO);

    boolean collectItem(Long loginUserId, FavoriteTypeEnum type, Long itemId);
}