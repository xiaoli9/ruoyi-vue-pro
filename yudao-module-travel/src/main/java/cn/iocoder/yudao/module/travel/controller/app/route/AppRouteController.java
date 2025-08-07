package cn.iocoder.yudao.module.travel.controller.app.route;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.travel.controller.admin.route.vo.RoutePageReqVO;
import cn.iocoder.yudao.module.travel.controller.app.route.vo.AppRouteLineRespVO;
import cn.iocoder.yudao.module.travel.controller.app.route.vo.AppRouteListRespVO;
import cn.iocoder.yudao.module.travel.convert.route.RouteConvert;
import cn.iocoder.yudao.module.travel.convert.route.RouteLineConvert;
import cn.iocoder.yudao.module.travel.dal.dataobject.route.RouteDO;
import cn.iocoder.yudao.module.travel.dal.dataobject.route.RouteLineDO;
import cn.iocoder.yudao.module.travel.service.route.RouteService;
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
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * @author XIYU
 */
@Tag(name = "APP - 路线")
@RestController
@RequestMapping("/travel/route")
@Validated
public class AppRouteController {

    @Resource
    private RouteService routeService;

    @GetMapping("/list")
    @Operation(summary = "路线列表")
    @Parameter(name = "scenicId", description = "景区ID", required = true, example = "1")
    @PermitAll
    public CommonResult<List<AppRouteListRespVO>> listAllRoutes(@RequestParam("scenicId") Long scenicId) {
        RoutePageReqVO req = new RoutePageReqVO();
        req.setPageSize(1000);
        req.setScenicId(scenicId);
        PageResult<RouteDO> pageResult = routeService.getRoutePage(req);

        return success(RouteConvert.INSTANCE.convertList(pageResult.getList()));
    }

    @GetMapping("/getDetail")
    @Operation(summary = "路线详情")
    @Parameter(name = "routeId", description = "线路ID", required = true, example = "1")
    @PermitAll
    public CommonResult<List<AppRouteLineRespVO>> getDetail(@RequestParam("routeId") Long routeId) {
        List<RouteLineDO> list = routeService.getRouteLineListByRouteId(routeId);
        return success(RouteLineConvert.INSTANCE.convertList(list));
    }
}