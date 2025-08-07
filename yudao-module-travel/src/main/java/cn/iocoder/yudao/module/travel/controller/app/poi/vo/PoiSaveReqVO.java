package cn.iocoder.yudao.module.travel.controller.app.poi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "app - 景点POI新增/修改 Request VO")
@Data
public class PoiSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "2572")
    private Integer id;

    @Schema(description = "景区ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "12653")
    @NotNull(message = "景区ID不能为空")
    private Integer scenicId;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @Schema(description = "描述", example = "你猜")
    private String description;

    @Schema(description = "封面地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "封面地址不能为空")
    private String coverUrl;

    @Schema(description = "音频地址", example = "https://www.iocoder.cn")
    private String audioUrl;

    @Schema(description = "富文本")
    private String richText;

    @Schema(description = "经度", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "经度不能为空")
    private Double longitude;

    @Schema(description = "纬度", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "纬度不能为空")
    private Double latitude;

    @Schema(description = "有AR模块", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "有AR模块不能为空")
    private Boolean hasAr;

    @Schema(description = "1-需要vip 0-无需", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "1-需要vip 0-无需不能为空")
    private Boolean isVip;

    @Schema(description = "模块开启情况：1,true,true|2,false,false", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "模块开启情况：1,true,true|2,false,false不能为空")
    private List<String> modules;

    @Schema(description = "1-正常 0-下架", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "1-正常 0-下架不能为空")
    private Boolean status;

}