package cn.iocoder.yudao.module.travel.controller.admin.favorite.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 用户收藏分页 Request VO")
@Data
public class UserFavoritePageReqVO extends PageParam {

    @Schema(description = "用户编号", example = "8191")
    private Long userId;

    @Schema(description = "收藏类型:景点或景区", example = "2")
    private String itemType;

    @Schema(description = "对应类型的ID", example = "13905")
    private Long itemId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}