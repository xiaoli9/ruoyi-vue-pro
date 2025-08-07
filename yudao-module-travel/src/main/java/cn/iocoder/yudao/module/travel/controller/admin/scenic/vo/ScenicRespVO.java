package cn.iocoder.yudao.module.travel.controller.admin.scenic.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 景区 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ScenicRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "21554")
    @ExcelProperty("id")
    private Long id;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("名称")
    private String name;

    @Schema(description = "封面地址", example = "https://www.iocoder.cn")
    @ExcelProperty("封面地址")
    private String coverUrl;

    @Schema(description = "描述", example = "你说的对")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "是否有ar", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "是否有ar", converter = DictConvert.class)
    @DictFormat("trv_ar") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean hasAr;

    @Schema(description = "背景图", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @ExcelProperty("背景图")
    private String bgUrl;

    @Schema(description = "图片覆盖区域", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("图片覆盖区域")
    private String bgBounds;

    @Schema(description = "音频", example = "https://www.iocoder.cn")
    @ExcelProperty("音频")
    private String audioUrl;

    @Schema(description = "富文本")
    @ExcelProperty("富文本")
    private String richText;

    @Schema(description = "地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("地址")
    private String address;

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