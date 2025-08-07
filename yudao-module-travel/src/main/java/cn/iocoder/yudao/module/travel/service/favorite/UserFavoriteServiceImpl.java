package cn.iocoder.yudao.module.travel.service.favorite;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.travel.controller.admin.favorite.vo.UserFavoritePageReqVO;
import cn.iocoder.yudao.module.travel.controller.admin.favorite.vo.UserFavoriteSaveReqVO;
import cn.iocoder.yudao.module.travel.dal.dataobject.favorite.UserFavoriteDO;
import cn.iocoder.yudao.module.travel.dal.mysql.favorite.UserFavoriteMapper;
import cn.iocoder.yudao.module.travel.enums.FavoriteTypeEnum;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.travel.enums.ErrorCodeConstants.USER_FAVORITE_NOT_EXISTS;

/**
 * 用户收藏 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class UserFavoriteServiceImpl implements UserFavoriteService {

    @Resource
    private UserFavoriteMapper userFavoriteMapper;

    @Override
    public Long createUserFavorite(UserFavoriteSaveReqVO createReqVO) {
        // 插入
        UserFavoriteDO userFavorite = BeanUtils.toBean(createReqVO, UserFavoriteDO.class);
        userFavoriteMapper.insert(userFavorite);

        // 返回
        return userFavorite.getId();
    }

    @Override
    public void updateUserFavorite(UserFavoriteSaveReqVO updateReqVO) {
        // 校验存在
        validateUserFavoriteExists(updateReqVO.getId());
        // 更新
        UserFavoriteDO updateObj = BeanUtils.toBean(updateReqVO, UserFavoriteDO.class);
        userFavoriteMapper.updateById(updateObj);
    }

    @Override
    public void deleteUserFavorite(Long id) {
        // 校验存在
        validateUserFavoriteExists(id);
        // 删除
        userFavoriteMapper.deleteById(id);
    }

    @Override
    public void deleteUserFavoriteListByIds(List<Long> ids) {
        // 删除
        userFavoriteMapper.deleteByIds(ids);
    }


    private void validateUserFavoriteExists(Long id) {
        if (userFavoriteMapper.selectById(id) == null) {
            throw exception(USER_FAVORITE_NOT_EXISTS);
        }
    }

    @Override
    public UserFavoriteDO getUserFavorite(Long id) {
        return userFavoriteMapper.selectById(id);
    }

    @Override
    public UserFavoriteDO getUserFavorite(Long userId, FavoriteTypeEnum itemType, Long itemId) {
        return userFavoriteMapper.selectByUserId(userId, itemType, itemId);
    }

    @Override
    public PageResult<UserFavoriteDO> getUserFavoritePage(UserFavoritePageReqVO pageReqVO) {
        return userFavoriteMapper.selectPage(pageReqVO);
    }

    @Override
    public boolean collectItem(Long loginUserId, FavoriteTypeEnum type, Long itemId) {

        UserFavoriteDO userFavoriteDO = userFavoriteMapper.selectByUserId(loginUserId, type, itemId);
        if (userFavoriteDO != null) {
            userFavoriteMapper.deleteById(userFavoriteDO.getId());
            return false;
        }

        userFavoriteMapper.insert(new UserFavoriteDO()
                .setUserId(loginUserId)
                .setItemType(type.getCode())
                .setItemId(itemId));
        return true;
    }

}