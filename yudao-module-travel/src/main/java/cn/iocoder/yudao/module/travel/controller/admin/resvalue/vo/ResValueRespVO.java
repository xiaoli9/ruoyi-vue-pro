package cn.iocoder.yudao.module.travel.controller.admin.resvalue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 资源 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ResValueRespVO {

    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "32695")
    @ExcelProperty("ID")
    private Long id;

    @Schema(description = "类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("类型")
    private Integer entityType;

    @Schema(description = "类型ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "25960")
    @ExcelProperty("类型ID")
    private Long entityId;

    @Schema(description = "属性名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("属性名")
    private String attrName;

    @Schema(description = "属性值", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("属性值")
    private String attrValue;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}