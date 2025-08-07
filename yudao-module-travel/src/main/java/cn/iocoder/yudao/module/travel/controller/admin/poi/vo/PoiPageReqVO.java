package cn.iocoder.yudao.module.travel.controller.admin.poi.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 景点POI分页 Request VO")
@Data
public class PoiPageReqVO extends PageParam {

    @Schema(description = "景区ID", example = "9094")
    private Long scenicId;

    @Schema(description = "名称", example = "王五")
    private String name;

    @Schema(description = "icon地址", example = "https://www.iocoder.cn")
    private String iconUrl;

    @Schema(description = "描述", example = "你说的对")
    private String description;

    @Schema(description = "封面地址", example = "https://www.iocoder.cn")
    private String coverUrl;

    @Schema(description = "有AR")
    private Boolean hasAr;

    @Schema(description = "需要vip")
    private Boolean isVip;

    @Schema(description = "模块开启情况：1,true,true|2,false,false")
    private String module;

    @Schema(description = "富文本")
    private String richText;

    @Schema(description = "跳转地址")
    private String forward;

    @Schema(description = "分类ID", example = "31972")
    private Long categoryId;

    @Schema(description = "状态", example = "1")
    private Boolean status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}