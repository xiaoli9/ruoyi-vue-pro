package cn.iocoder.yudao.module.travel.controller.admin.resvalue.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 资源分页 Request VO")
@Data
public class ResValuePageReqVO extends PageParam {

    @Schema(description = "类型", example = "2")
    private Integer entityType;

    @Schema(description = "类型ID", example = "25960")
    private Long entityId;

    @Schema(description = "属性名", example = "芋艿")
    private String attrName;

    @Schema(description = "属性值")
    private String attrValue;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}