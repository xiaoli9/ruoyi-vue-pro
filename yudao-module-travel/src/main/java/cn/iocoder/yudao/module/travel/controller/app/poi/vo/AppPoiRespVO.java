package cn.iocoder.yudao.module.travel.controller.app.poi.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "APP - 景点POI Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppPoiRespVO extends AppPoiBaseVO{

    @Schema(description = "音频地址", example = "https://www.iocoder.cn")
    @ExcelProperty("音频地址")
    private String audioUrl;

    @Schema(description = "富文本")
    @ExcelProperty("富文本")
    private String richText;

    @Schema(description = "经度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("经度")
    private Double longitude;

    @Schema(description = "纬度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("纬度")
    private Double latitude;

    @Schema(description = "有AR模块", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("有AR模块")
    private Boolean hasAr;

    @Schema(description = "1-需要vip 0-无需", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("1-需要vip 0-无需")
    private Boolean isVip;

    @Schema(description = "模块开启情况：1,true,true|2,false,false", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("模块开启情况：1,true,true|2,false,false")
    private List<AppPoiModuleVO> modules;

}