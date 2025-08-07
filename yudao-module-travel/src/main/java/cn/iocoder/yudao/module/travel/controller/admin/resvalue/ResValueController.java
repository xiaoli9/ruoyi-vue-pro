package cn.iocoder.yudao.module.travel.controller.admin.resvalue;

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

import cn.iocoder.yudao.module.travel.controller.admin.resvalue.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.resvalue.ResValueDO;
import cn.iocoder.yudao.module.travel.service.resvalue.ResValueService;

@Tag(name = "管理后台 - 资源")
@RestController
@RequestMapping("/travel/res-value")
@Validated
public class ResValueController {

    @Resource
    private ResValueService resValueService;

    @PostMapping("/create")
    @Operation(summary = "创建资源")
    @PreAuthorize("@ss.hasPermission('travel:res-value:create')")
    public CommonResult<Long> createResValue(@Valid @RequestBody ResValueSaveReqVO createReqVO) {
        return success(resValueService.createResValue(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新资源")
    @PreAuthorize("@ss.hasPermission('travel:res-value:update')")
    public CommonResult<Boolean> updateResValue(@Valid @RequestBody ResValueSaveReqVO updateReqVO) {
        resValueService.updateResValue(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除资源")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('travel:res-value:delete')")
    public CommonResult<Boolean> deleteResValue(@RequestParam("id") Long id) {
        resValueService.deleteResValue(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除资源")
                @PreAuthorize("@ss.hasPermission('travel:res-value:delete')")
    public CommonResult<Boolean> deleteResValueList(@RequestParam("ids") List<Long> ids) {
        resValueService.deleteResValueListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得资源")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('travel:res-value:query')")
    public CommonResult<ResValueRespVO> getResValue(@RequestParam("id") Long id) {
        ResValueDO resValue = resValueService.getResValue(id);
        return success(BeanUtils.toBean(resValue, ResValueRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得资源分页")
    @PreAuthorize("@ss.hasPermission('travel:res-value:query')")
    public CommonResult<PageResult<ResValueRespVO>> getResValuePage(@Valid ResValuePageReqVO pageReqVO) {
        PageResult<ResValueDO> pageResult = resValueService.getResValuePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ResValueRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出资源 Excel")
    @PreAuthorize("@ss.hasPermission('travel:res-value:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportResValueExcel(@Valid ResValuePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ResValueDO> list = resValueService.getResValuePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "资源.xls", "数据", ResValueRespVO.class,
                        BeanUtils.toBean(list, ResValueRespVO.class));
    }

}