package cn.iocoder.yudao.module.travel.controller.admin.favorite.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 用户收藏 Response VO")
@Data
@ExcelIgnoreUnannotated
public class UserFavoriteRespVO {

    @Schema(description = "收藏编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "18635")
    @ExcelProperty("收藏编号")
    private Long id;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "8191")
    @ExcelProperty("用户编号")
    private Long userId;

    @Schema(description = "收藏类型:景点或景区", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("收藏类型:景点或景区")
    private String itemType;

    @Schema(description = "对应类型的ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "13905")
    @ExcelProperty("对应类型的ID")
    private Long itemId;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}