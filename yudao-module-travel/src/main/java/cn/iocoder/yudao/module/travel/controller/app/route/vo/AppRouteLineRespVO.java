package cn.iocoder.yudao.module.travel.controller.app.route.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "app - 画线 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppRouteLineRespVO {

    @Schema(description = "lineId", requiredMode = Schema.RequiredMode.REQUIRED, example = "8007")
    @ExcelProperty("lineId")
    private Long lineId;

    @Schema(description = "poi点位id", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("poi点位id")
    private List<String> poiIds;

    @Schema(description = "经纬度点", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("经纬度点")
//    private List<Map<String, Object>> points;
    private String points;

}