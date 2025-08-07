package cn.iocoder.yudao.module.travel.controller.admin.scenic.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 景区分页 Request VO")
@Data
public class ScenicPageReqVO extends PageParam {

    @Schema(description = "名称", example = "赵六")
    private String name;

    @Schema(description = "封面地址", example = "https://www.iocoder.cn")
    private String coverUrl;

    @Schema(description = "描述", example = "你说的对")
    private String description;

    @Schema(description = "是否有ar")
    private Boolean hasAr;

    @Schema(description = "背景图", example = "https://www.iocoder.cn")
    private String bgUrl;

    @Schema(description = "图片覆盖区域")
    private String bgBounds;

    @Schema(description = "音频", example = "https://www.iocoder.cn")
    private String audioUrl;

    @Schema(description = "富文本")
    private String richText;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "是否需要vip")
    private Boolean isVip;

    @Schema(description = "1-正常 0-下架", example = "1")
    private Boolean status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}