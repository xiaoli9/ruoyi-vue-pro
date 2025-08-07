package cn.iocoder.yudao.module.travel.controller.app.favorite.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "APP - 景区收藏 Request VO")
@Data
public class AppScenicCollectReqVO {

    @Schema(description = "scenicId", requiredMode = Schema.RequiredMode.REQUIRED, example = "14767")
    @NotNull(message = "scenicId 不能为空")
    private Long scenicId;
}