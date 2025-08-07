package cn.iocoder.yudao.module.travel.controller.app.poi;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.module.travel.controller.admin.poi.vo.PoiPageReqVO;
import cn.iocoder.yudao.module.travel.controller.app.poi.vo.AppPoiPageReqVO;
import cn.iocoder.yudao.module.travel.controller.app.poi.vo.AppPoiPageRespVO;
import cn.iocoder.yudao.module.travel.controller.app.poi.vo.AppPoiRespVO;
import cn.iocoder.yudao.module.travel.controller.app.poi.vo.AppPoiSimpleRespVO;
import cn.iocoder.yudao.module.travel.convert.poi.PoiConvert;
import cn.iocoder.yudao.module.travel.dal.dataobject.favorite.UserFavoriteDO;
import cn.iocoder.yudao.module.travel.dal.dataobject.poi.PoiDO;
import cn.iocoder.yudao.module.travel.enums.ErrorCodeConstants;
import cn.iocoder.yudao.module.travel.enums.FavoriteTypeEnum;
import cn.iocoder.yudao.module.travel.service.favorite.UserFavoriteService;
import cn.iocoder.yudao.module.travel.service.poi.PoiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * @author XIYU
 */
@Tag(name = "APP - 景点POI")
@RestController
@RequestMapping("/travel/poi")
@Validated
public class AppPoiController {

    @Resource
    private PoiService poiService;
    @Resource
    private UserFavoriteService favoriteService;

    @GetMapping("/getPoi")
    @Operation(summary = "景点简介")
    @Parameter(name = "id", description = "编号", required = true, example = "1")
    @PermitAll
    public CommonResult<AppPoiSimpleRespVO> getPoi(@RequestParam("poiId") Long poiId) {
        PoiDO poi = poiService.getPoi(poiId);
        if (poi == null) {
            throw exception(ErrorCodeConstants.POI_NOT_EXISTS);
        }

        UserFavoriteDO userFavorite = favoriteService.getUserFavorite(SecurityFrameworkUtils.getLoginUserId(), FavoriteTypeEnum.POI, poiId);

        return success(PoiConvert.INSTANCE.convert(poi, userFavorite == null ? false : true));
    }

    @GetMapping("/getDetail")
    @Operation(summary = "景点详情")
    @Parameter(name = "poiId", description = "编号", required = true, example = "1")
    @PermitAll
    public CommonResult<AppPoiRespVO> getDetail(@RequestParam("poiId") Long poiId) {
        PoiDO poi = poiService.getPoi(poiId);
        if (poi == null) {
            throw exception(ErrorCodeConstants.POI_NOT_EXISTS);
        }

        return success(PoiConvert.INSTANCE.convert2(poi));
    }

    @GetMapping("/list")
    @Operation(summary = "景点列表")
    @Parameter(name = "scenicId", description = "景区ID", required = true, example = "1")
    @PermitAll
    public CommonResult<PageResult<AppPoiPageRespVO>> listAllPoi(@Valid AppPoiPageReqVO pageReqVO) {
        PoiPageReqVO param = new PoiPageReqVO();
        param.setPageNo(pageReqVO.getPageNo());
        param.setPageSize(pageReqVO.getPageSize());
        param.setScenicId(pageReqVO.getScenicId());
        PageResult<PoiDO> pageResult = poiService.getPoiPage(param);

        return success(new PageResult<>(PoiConvert.INSTANCE.convertList(pageResult.getList()),
                pageResult.getTotal()));
    }

    // --------------------------------------- 登录 -------------------------------------------------

    @GetMapping("/entryAR")
    @Operation(summary = "进入AR")
    public CommonResult<String> entryAR(@RequestParam("poiId") Long poiId) {
        return success("true");
    }
}