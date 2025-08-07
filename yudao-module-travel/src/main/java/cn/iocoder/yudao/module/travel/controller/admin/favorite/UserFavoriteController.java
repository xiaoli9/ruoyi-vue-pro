package cn.iocoder.yudao.module.travel.controller.admin.favorite;

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

import cn.iocoder.yudao.module.travel.controller.admin.favorite.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.favorite.UserFavoriteDO;
import cn.iocoder.yudao.module.travel.service.favorite.UserFavoriteService;

@Tag(name = "管理后台 - 用户收藏")
@RestController
@RequestMapping("/travel/user-favorite")
@Validated
public class UserFavoriteController {

    @Resource
    private UserFavoriteService userFavoriteService;

    @PostMapping("/create")
    @Operation(summary = "创建用户收藏")
    @PreAuthorize("@ss.hasPermission('travel:user-favorite:create')")
    public CommonResult<Long> createUserFavorite(@Valid @RequestBody UserFavoriteSaveReqVO createReqVO) {
        return success(userFavoriteService.createUserFavorite(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新用户收藏")
    @PreAuthorize("@ss.hasPermission('travel:user-favorite:update')")
    public CommonResult<Boolean> updateUserFavorite(@Valid @RequestBody UserFavoriteSaveReqVO updateReqVO) {
        userFavoriteService.updateUserFavorite(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除用户收藏")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('travel:user-favorite:delete')")
    public CommonResult<Boolean> deleteUserFavorite(@RequestParam("id") Long id) {
        userFavoriteService.deleteUserFavorite(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除用户收藏")
                @PreAuthorize("@ss.hasPermission('travel:user-favorite:delete')")
    public CommonResult<Boolean> deleteUserFavoriteList(@RequestParam("ids") List<Long> ids) {
        userFavoriteService.deleteUserFavoriteListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得用户收藏")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('travel:user-favorite:query')")
    public CommonResult<UserFavoriteRespVO> getUserFavorite(@RequestParam("id") Long id) {
        UserFavoriteDO userFavorite = userFavoriteService.getUserFavorite(id);
        return success(BeanUtils.toBean(userFavorite, UserFavoriteRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得用户收藏分页")
    @PreAuthorize("@ss.hasPermission('travel:user-favorite:query')")
    public CommonResult<PageResult<UserFavoriteRespVO>> getUserFavoritePage(@Valid UserFavoritePageReqVO pageReqVO) {
        PageResult<UserFavoriteDO> pageResult = userFavoriteService.getUserFavoritePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, UserFavoriteRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出用户收藏 Excel")
    @PreAuthorize("@ss.hasPermission('travel:user-favorite:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportUserFavoriteExcel(@Valid UserFavoritePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<UserFavoriteDO> list = userFavoriteService.getUserFavoritePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "用户收藏.xls", "数据", UserFavoriteRespVO.class,
                        BeanUtils.toBean(list, UserFavoriteRespVO.class));
    }

}