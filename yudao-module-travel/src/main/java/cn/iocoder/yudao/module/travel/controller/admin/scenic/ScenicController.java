package cn.iocoder.yudao.module.travel.controller.admin.scenic;

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

import cn.iocoder.yudao.module.travel.controller.admin.scenic.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.scenic.ScenicDO;
import cn.iocoder.yudao.module.travel.service.scenic.ScenicService;

@Tag(name = "管理后台 - 景区")
@RestController
@RequestMapping("/travel/scenic")
@Validated
public class ScenicController {

    @Resource
    private ScenicService scenicService;

    @PostMapping("/create")
    @Operation(summary = "创建景区")
    @PreAuthorize("@ss.hasPermission('travel:scenic:create')")
    public CommonResult<Long> createScenic(@Valid @RequestBody ScenicSaveReqVO createReqVO) {
        return success(scenicService.createScenic(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新景区")
    @PreAuthorize("@ss.hasPermission('travel:scenic:update')")
    public CommonResult<Boolean> updateScenic(@Valid @RequestBody ScenicSaveReqVO updateReqVO) {
        scenicService.updateScenic(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除景区")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('travel:scenic:delete')")
    public CommonResult<Boolean> deleteScenic(@RequestParam("id") Long id) {
        scenicService.deleteScenic(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除景区")
                @PreAuthorize("@ss.hasPermission('travel:scenic:delete')")
    public CommonResult<Boolean> deleteScenicList(@RequestParam("ids") List<Long> ids) {
        scenicService.deleteScenicListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得景区")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('travel:scenic:query')")
    public CommonResult<ScenicRespVO> getScenic(@RequestParam("id") Long id) {
        ScenicDO scenic = scenicService.getScenic(id);
        return success(BeanUtils.toBean(scenic, ScenicRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得景区分页")
    @PreAuthorize("@ss.hasPermission('travel:scenic:query')")
    public CommonResult<PageResult<ScenicRespVO>> getScenicPage(@Valid ScenicPageReqVO pageReqVO) {
        PageResult<ScenicDO> pageResult = scenicService.getScenicPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ScenicRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出景区 Excel")
    @PreAuthorize("@ss.hasPermission('travel:scenic:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportScenicExcel(@Valid ScenicPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ScenicDO> list = scenicService.getScenicPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "景区.xls", "数据", ScenicRespVO.class,
                        BeanUtils.toBean(list, ScenicRespVO.class));
    }

}