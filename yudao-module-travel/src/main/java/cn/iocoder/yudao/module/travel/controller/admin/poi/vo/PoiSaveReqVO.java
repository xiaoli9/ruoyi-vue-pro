package cn.iocoder.yudao.module.travel.controller.admin.poi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 景点POI新增/修改 Request VO")
@Data
public class PoiSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "2248")
    private Long id;

    @Schema(description = "景区ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "9094")
    @NotNull(message = "景区ID不能为空")
    private Long scenicId;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @Schema(description = "icon地址", example = "https://www.iocoder.cn")
    private String iconUrl;

    @Schema(description = "描述", example = "你说的对")
    private String description;

    @Schema(description = "封面地址", example = "https://www.iocoder.cn")
    private String coverUrl;

    @Schema(description = "有AR", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "有AR不能为空")
    private Boolean hasAr;

    @Schema(description = "需要vip", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "需要vip不能为空")
    private Boolean isVip;

    @Schema(description = "音频地址", example = "https://www.iocoder.cn")
    private String audioUrl;

    @Schema(description = "模块开启情况：1,true,true|2,false,false", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "模块开启情况：1,true,true|2,false,false不能为空")
    private String module;

    @Schema(description = "富文本")
    private String richText;

    @Schema(description = "跳转地址")
    private String forward;

    @Schema(description = "经度", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "经度不能为空")
    private Double longitude;

    @Schema(description = "分类ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "31972")
    @NotNull(message = "分类ID不能为空")
    private Long categoryId;

    @Schema(description = "纬度", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "纬度不能为空")
    private Double latitude;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Boolean status;

}