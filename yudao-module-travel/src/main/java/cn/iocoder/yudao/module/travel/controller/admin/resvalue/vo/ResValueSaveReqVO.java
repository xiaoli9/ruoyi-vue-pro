package cn.iocoder.yudao.module.travel.controller.admin.resvalue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 资源新增/修改 Request VO")
@Data
public class ResValueSaveReqVO {

    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "32695")
    private Long id;

    @Schema(description = "类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "类型不能为空")
    private Integer entityType;

    @Schema(description = "类型ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "25960")
    @NotNull(message = "类型ID不能为空")
    private Long entityId;

    @Schema(description = "属性名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotEmpty(message = "属性名不能为空")
    private String attrName;

    @Schema(description = "属性值", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "属性值不能为空")
    private String attrValue;

}