package cn.iocoder.yudao.module.travel.controller.admin.route.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import cn.iocoder.yudao.module.travel.dal.dataobject.route.RouteLineDO;

@Schema(description = "管理后台 - 路线新增/修改 Request VO")
@Data
public class RouteSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1446")
    private Long id;

    @Schema(description = "景区ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "14553")
    @NotNull(message = "景区ID不能为空")
    private Long scenicId;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "标题不能为空")
    private String title;

    @Schema(description = "描述", example = "随便")
    private String description;

    @Schema(description = "游览时长:1小时", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "游览时长:1小时不能为空")
    private String duration;

    @Schema(description = "公里")
    private BigDecimal distance;

    @Schema(description = "封面地址", example = "https://www.iocoder.cn")
    private String coverUrl;

    @Schema(description = "是否需要vip", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否需要vip不能为空")
    private Boolean isVip;

    @Schema(description = "1-正常 0-下架", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "1-正常 0-下架不能为空")
    private Boolean status;

    @Schema(description = "画线列表")
    private List<RouteLineDO> routeLines;

}