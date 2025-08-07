package cn.iocoder.yudao.module.travel.controller.admin.route.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 路线分页 Request VO")
@Data
public class RoutePageReqVO extends PageParam {

    @Schema(description = "景区ID", example = "14553")
    private Long scenicId;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "描述", example = "随便")
    private String description;

    @Schema(description = "游览时长:1小时")
    private String duration;

    @Schema(description = "公里")
    private BigDecimal distance;

    @Schema(description = "封面地址", example = "https://www.iocoder.cn")
    private String coverUrl;

    @Schema(description = "是否需要vip")
    private Boolean isVip;

    @Schema(description = "1-正常 0-下架", example = "1")
    private Boolean status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}