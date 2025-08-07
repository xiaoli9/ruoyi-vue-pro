package cn.iocoder.yudao.module.travel.controller.admin.poi;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.travel.controller.admin.poi.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.poi.PoiDO;
import cn.iocoder.yudao.module.travel.service.poi.PoiService;

@Tag(name = "管理后台 - 景点POI")
@RestController
@RequestMapping("/travel/poi")
@Validated
public class PoiController {

    @Resource
    private PoiService poiService;

    @PostMapping("/create")
    @Operation(summary = "创建景点POI")
    @PreAuthorize("@ss.hasPermission('travel:poi:create')")
    public CommonResult<Long> createPoi(@Valid @RequestBody PoiSaveReqVO createReqVO) {
        return success(poiService.createPoi(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新景点POI")
    @PreAuthorize("@ss.hasPermission('travel:poi:update')")
    public CommonResult<Boolean> updatePoi(@Valid @RequestBody PoiSaveReqVO updateReqVO) {
        poiService.updatePoi(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除景点POI")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('travel:poi:delete')")
    public CommonResult<Boolean> deletePoi(@RequestParam("id") Long id) {
        poiService.deletePoi(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除景点POI")
                @PreAuthorize("@ss.hasPermission('travel:poi:delete')")
    public CommonResult<Boolean> deletePoiList(@RequestParam("ids") List<Long> ids) {
        poiService.deletePoiListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得景点POI")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('travel:poi:query')")
    public CommonResult<PoiRespVO> getPoi(@RequestParam("id") Long id) {
        PoiDO poi = poiService.getPoi(id);
        return success(BeanUtils.toBean(poi, PoiRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得景点POI分页")
    @PreAuthorize("@ss.hasPermission('travel:poi:query')")
    public CommonResult<PageResult<PoiRespVO>> getPoiPage(@Valid PoiPageReqVO pageReqVO) {
        PageResult<PoiDO> pageResult = poiService.getPoiPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PoiRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出景点POI Excel")
    @PreAuthorize("@ss.hasPermission('travel:poi:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPoiExcel(@Valid PoiPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PoiDO> list = poiService.getPoiPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "景点POI.xls", "数据", PoiRespVO.class,
                        BeanUtils.toBean(list, PoiRespVO.class));
    }

}