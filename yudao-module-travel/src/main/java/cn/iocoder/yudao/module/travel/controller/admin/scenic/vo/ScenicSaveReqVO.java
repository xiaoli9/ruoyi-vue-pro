package cn.iocoder.yudao.module.travel.controller.admin.scenic.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 景区新增/修改 Request VO")
@Data
public class ScenicSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "21554")
    private Long id;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @Schema(description = "封面地址", example = "https://www.iocoder.cn")
    private String coverUrl;

    @Schema(description = "描述", example = "你说的对")
    private String description;

    @Schema(description = "是否有ar", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否有ar不能为空")
    private Boolean hasAr;

    @Schema(description = "背景图", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "背景图不能为空")
    private String bgUrl;

    @Schema(description = "图片覆盖区域", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "图片覆盖区域不能为空")
    private String bgBounds;

    @Schema(description = "音频", example = "https://www.iocoder.cn")
    private String audioUrl;

    @Schema(description = "富文本")
    private String richText;

    @Schema(description = "地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "地址不能为空")
    private String address;

    @Schema(description = "是否需要vip", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否需要vip不能为空")
    private Boolean isVip;

    @Schema(description = "1-正常 0-下架", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "1-正常 0-下架不能为空")
    private Boolean status;

}