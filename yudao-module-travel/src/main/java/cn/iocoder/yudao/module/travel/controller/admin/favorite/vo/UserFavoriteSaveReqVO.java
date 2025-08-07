package cn.iocoder.yudao.module.travel.controller.admin.favorite.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 用户收藏新增/修改 Request VO")
@Data
public class UserFavoriteSaveReqVO {

    @Schema(description = "收藏编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "18635")
    private Long id;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "8191")
    @NotNull(message = "用户编号不能为空")
    private Long userId;

    @Schema(description = "收藏类型:景点或景区", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotEmpty(message = "收藏类型:景点或景区不能为空")
    private String itemType;

    @Schema(description = "对应类型的ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "13905")
    @NotNull(message = "对应类型的ID不能为空")
    private Long itemId;

}