package cn.iocoder.yudao.module.travel.controller.app.scenic.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "app - 景区 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppScenicRespVO extends AppScenicBaseVO {

    @Schema(description = "背景图", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    private String bgUrl;

    @Schema(description = "图片覆盖区域", requiredMode = Schema.RequiredMode.REQUIRED)
    private String bgBounds;

    @Schema(description = "音频", example = "https://www.iocoder.cn")
    private String audioUrl;

    @Schema(description = "富文本")
    private String richText;

    @Schema(description = "地址", requiredMode = Schema.RequiredMode.REQUIRED)
    private String address;

    @Schema(description = "是否有ar", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean hasAr;

    @Schema(description = "是否需要vip", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean isVip;

}