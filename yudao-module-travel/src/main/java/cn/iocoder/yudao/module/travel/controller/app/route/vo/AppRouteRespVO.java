package cn.iocoder.yudao.module.travel.controller.app.route.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "app - 路线 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppRouteRespVO {

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

    @Schema(description = "公里")
    @ExcelProperty("公里")
    private BigDecimal distance;

    @Schema(description = "封面地址", example = "https://www.iocoder.cn")
    @ExcelProperty("封面地址")
    private String coverUrl;

    @Schema(description = "是否需要vip", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否需要vip")
    private Boolean isVip;

    private List<Points> points;

    private List<Long> poiIds;

    class Points {
        @Schema(description = "经度", requiredMode = Schema.RequiredMode.REQUIRED)
        @ExcelProperty("经度")
        private Double longitude;

        @Schema(description = "纬度", requiredMode = Schema.RequiredMode.REQUIRED)
        @ExcelProperty("纬度")
        private Double latitude;
    }
}
