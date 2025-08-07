package cn.iocoder.yudao.module.travel.controller.app.route.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "app - 路线 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppRouteListRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "29930")
    @ExcelProperty("id")
    private Integer routeId;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("标题")
    private String title;

    @Schema(description = "描述", example = "你猜")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "游览时长:1小时", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("游览时长:1小时")
    private String duration;

    @Schema(description = "是否需要vip", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否需要vip")
    private Boolean vip;

}