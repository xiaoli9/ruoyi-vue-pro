package cn.iocoder.yudao.module.travel.controller.admin.poi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 景点POI Response VO")
@Data
@ExcelIgnoreUnannotated
public class PoiRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "2248")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "景区ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "9094")
    @ExcelProperty("景区ID")
    private Long scenicId;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("名称")
    private String name;

    @Schema(description = "icon地址", example = "https://www.iocoder.cn")
    @ExcelProperty("icon地址")
    private String iconUrl;

    @Schema(description = "描述", example = "你说的对")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "封面地址", example = "https://www.iocoder.cn")
    @ExcelProperty("封面地址")
    private String coverUrl;

    @Schema(description = "有AR", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "有AR", converter = DictConvert.class)
    @DictFormat("trv_ar") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean hasAr;

    @Schema(description = "需要vip", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "需要vip", converter = DictConvert.class)
    @DictFormat("trv_vip") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean isVip;

    @Schema(description = "音频地址", example = "https://www.iocoder.cn")
    @ExcelProperty("音频地址")
    private String audioUrl;

    @Schema(description = "模块开启情况：1,true,true|2,false,false", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("模块开启情况：1,true,true|2,false,false")
    private String module;

    @Schema(description = "富文本")
    @ExcelProperty("富文本")
    private String richText;

    @Schema(description = "跳转地址")
    @ExcelProperty("跳转地址")
    private String forward;

    @Schema(description = "经度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("经度")
    private Double longitude;

    @Schema(description = "分类ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "31972")
    @ExcelProperty("分类ID")
    private Long categoryId;

    @Schema(description = "纬度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("纬度")
    private Double latitude;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("trv_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}