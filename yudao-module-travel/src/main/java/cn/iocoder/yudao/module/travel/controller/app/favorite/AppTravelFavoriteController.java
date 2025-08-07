package cn.iocoder.yudao.module.travel.controller.app.favorite;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.module.travel.controller.admin.favorite.vo.UserFavoritePageReqVO;
import cn.iocoder.yudao.module.travel.controller.app.favorite.vo.AppFavoriteReqVO;
import cn.iocoder.yudao.module.travel.controller.app.favorite.vo.AppPoiCollectRespVO;
import cn.iocoder.yudao.module.travel.controller.app.favorite.vo.AppScenicCollectRespVO;
import cn.iocoder.yudao.module.travel.convert.poi.PoiConvert;
import cn.iocoder.yudao.module.travel.convert.scenic.ScenicConvert;
import cn.iocoder.yudao.module.travel.dal.dataobject.favorite.UserFavoriteDO;
import cn.iocoder.yudao.module.travel.dal.dataobject.poi.PoiDO;
import cn.iocoder.yudao.module.travel.dal.dataobject.scenic.ScenicDO;
import cn.iocoder.yudao.module.travel.enums.FavoriteTypeEnum;
import cn.iocoder.yudao.module.travel.service.favorite.UserFavoriteService;
import cn.iocoder.yudao.module.travel.service.poi.PoiService;
import cn.iocoder.yudao.module.travel.service.scenic.ScenicService;
import de.danielbechler.util.Collections;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.module.travel.enums.ErrorCodeConstants.POI_NOT_EXISTS;
import static cn.iocoder.yudao.module.travel.enums.ErrorCodeConstants.SCENIC_NOT_EXISTS;

/**
 * @author XIYU
 */
@Tag(name = "APP - 景点POI")
@RestController
@RequestMapping("/travel/favorite")
@Validated
public class AppTravelFavoriteController {

    @Resource
    private PoiService poiService;

    @Resource
    private ScenicService scenicService;

    @Resource
    private UserFavoriteService favoriteService;


    // --------------------------------------- 登录 -------------------------------------------------

    @PostMapping("/collect")
    @Operation(summary = "收藏")
    public CommonResult<Object> collectPoi(@Valid @RequestBody AppFavoriteReqVO reqVO) {

        switch (reqVO.getItemType()) {
            case POI:
                PoiDO poi = poiService.getPoi(reqVO.getItemId());
                if (poi == null) {
                    throw exception(POI_NOT_EXISTS);
                }
                break;
            case SCENIC:
                ScenicDO scenic = scenicService.getScenic(reqVO.getItemId());
                if (scenic == null) {
                    throw exception(SCENIC_NOT_EXISTS);
                }
                break;
            default: {
                throw exception(POI_NOT_EXISTS);
            }
        }

        boolean status = favoriteService.collectItem(SecurityFrameworkUtils.getLoginUserId(), reqVO.getItemType(), reqVO.getItemId());
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        return success(map);
    }

    @GetMapping("/getPoiPage")
    @Operation(summary = "景点收藏列表")
    @Parameter(name = "id", description = "编号", required = true, example = "1")
    public CommonResult<PageResult<AppPoiCollectRespVO>> listPoiFavorite(@RequestParam("pageNo") Integer pageNo) {

        UserFavoritePageReqVO param = new UserFavoritePageReqVO();
        param.setPageNo(pageNo);
        param.setUserId(SecurityFrameworkUtils.getLoginUserId());
        param.setItemType(FavoriteTypeEnum.POI.getCode());


        PageResult<UserFavoriteDO> pageResult = favoriteService.getUserFavoritePage(param);
        if (Collections.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }

        Set<Long> poiIds = pageResult.getList().stream().map(v -> v.getItemId()).collect(Collectors.toSet());
        List<PoiDO> poiDOS = poiService.listPoiListByIds(poiIds);
        return success(PoiConvert.INSTANCE.convertList(poiDOS, true, pageResult.getTotal()));
    }


    @GetMapping("/getScenicPage")
    @Operation(summary = "景区收藏列表")
    @Parameter(name = "pageNo", description = "页码", required = true, example = "1")
    public CommonResult<PageResult<AppScenicCollectRespVO>> listScenicFavorite(@RequestParam("pageNo") Integer pageNo) {

        UserFavoritePageReqVO param = new UserFavoritePageReqVO();
        param.setPageNo(pageNo);
        param.setUserId(SecurityFrameworkUtils.getLoginUserId());
        param.setItemType(FavoriteTypeEnum.SCENIC.getCode());


        PageResult<UserFavoriteDO> pageResult = favoriteService.getUserFavoritePage(param);
        if (Collections.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }

        Set<Long> scenicIds = pageResult.getList().stream().map(v -> v.getItemId()).collect(Collectors.toSet());
        List<ScenicDO> scenicDOList = scenicService.listScenicListByIds(scenicIds);
        return success(ScenicConvert.INSTANCE.convertList(scenicDOList, true, pageResult.getTotal()));
    }
}