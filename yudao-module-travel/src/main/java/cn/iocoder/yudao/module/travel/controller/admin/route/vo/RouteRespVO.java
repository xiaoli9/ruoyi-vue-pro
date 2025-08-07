package cn.iocoder.yudao.module.travel.controller.admin.route.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 路线 Response VO")
@Data
@ExcelIgnoreUnannotated
public class RouteRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1446")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "景区ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "14553")
    @ExcelProperty("景区ID")
    private Long scenicId;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("标题")
    private String title;

    @Schema(description = "描述", example = "随便")
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
    @ExcelProperty(value = "是否需要vip", converter = DictConvert.class)
    @DictFormat("trv_vip") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean isVip;

    @Schema(description = "1-正常 0-下架", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "1-正常 0-下架", converter = DictConvert.class)
    @DictFormat("trv_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}