package cn.iocoder.yudao.module.travel.controller.app.poi.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "APP - 景点POI Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppPoiPageRespVO extends AppPoiBaseVO {

    @Schema(description = "经度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("经度")
    private Double longitude;

    @Schema(description = "纬度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("纬度")
    private Double latitude;

    @Schema(description = "模块开启情况：1,true,true|2,false,false", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("模块开启情况：1,true,true|2,false,false")
    private List<AppPoiModuleVO> modules;

}