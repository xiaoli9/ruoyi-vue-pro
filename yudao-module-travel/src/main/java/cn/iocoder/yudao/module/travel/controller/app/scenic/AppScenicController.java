package cn.iocoder.yudao.module.travel.controller.app.scenic;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.travel.controller.admin.poi.vo.PoiPageReqVO;
import cn.iocoder.yudao.module.travel.controller.admin.scenic.vo.ScenicPageReqVO;
import cn.iocoder.yudao.module.travel.controller.app.scenic.vo.AppMapRespVO;
import cn.iocoder.yudao.module.travel.controller.app.scenic.vo.AppScenicPageReqVO;
import cn.iocoder.yudao.module.travel.controller.app.scenic.vo.AppScenicPageRespVO;
import cn.iocoder.yudao.module.travel.controller.app.scenic.vo.AppScenicRespVO;
import cn.iocoder.yudao.module.travel.convert.scenic.ScenicConvert;
import cn.iocoder.yudao.module.travel.dal.dataobject.poi.PoiDO;
import cn.iocoder.yudao.module.travel.dal.dataobject.scenic.ScenicDO;
import cn.iocoder.yudao.module.travel.service.poi.PoiService;
import cn.iocoder.yudao.module.travel.service.scenic.ScenicService;
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
import static cn.iocoder.yudao.module.travel.enums.ErrorCodeConstants.SCENIC_NOT_EXISTS;

@Tag(name = "APP - 景区")
@RestController
@RequestMapping("/travel/scenic")
@Validated
public class AppScenicController {

    @Resource
    private ScenicService scenicService;
    @Resource
    private PoiService poiService;

    @GetMapping("/index")
    @Operation(summary = "主页(地图页)")
    @Parameter(name = "scenicId", description = "景区ID", required = true, example = "1")
    @PermitAll
    public CommonResult<AppMapRespVO> indexPage(@RequestParam("scenicId") Long scenicId) {
        ScenicDO scenic = scenicService.getScenic(scenicId);
        if (scenic == null) {
            throw exception(SCENIC_NOT_EXISTS);
        }

        PoiPageReqVO poiPageReqVO = new PoiPageReqVO();
        poiPageReqVO.setScenicId(scenicId);
        poiPageReqVO.setPageNo(1);
        poiPageReqVO.setPageSize(1000);
        PageResult<PoiDO> poiPage = poiService.getPoiPage(poiPageReqVO);

        return success(ScenicConvert.INSTANCE.convert(scenic, poiPage.getList()));
    }

    @GetMapping("/getDetail")
    @Operation(summary = "景区详情")
    @Parameter(name = "id", description = "编号", required = true, example = "1")
    @PermitAll
    public CommonResult<AppScenicRespVO> getDetail(@RequestParam("scenicId") Long scenicId) {
        ScenicDO scenic = scenicService.getScenic(scenicId);
        if (scenic == null) {
            throw exception(SCENIC_NOT_EXISTS);
        }

        return success(ScenicConvert.INSTANCE.convert(scenic));
    }

    @GetMapping("/page")
    @Operation(summary = "景区列表")
    @Parameter(name = "id", description = "编号", required = true, example = "1")
    @PermitAll
    public CommonResult<PageResult<AppScenicPageRespVO>> listScenicPage(@Valid AppScenicPageReqVO pageReqVO) {
        ScenicPageReqVO scenicPageReqVO = new ScenicPageReqVO();
        scenicPageReqVO.setPageNo(pageReqVO.getPageNo());
        scenicPageReqVO.setPageSize(pageReqVO.getPageSize());
        scenicPageReqVO.setName(pageReqVO.getKeyword());

        // 获得分页列表
        PageResult<ScenicDO> pageResult = scenicService.getScenicPage(scenicPageReqVO);

        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal()));
        }

        return success(new PageResult<>(ScenicConvert.INSTANCE.convertList(pageResult.getList()),
                pageResult.getTotal()));
    }

    // --------------------------------------- 登录 -------------------------------------------------

}