package cn.iocoder.yudao.module.travel.controller.app.scenic.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "app - 景区 Response VO")
@Data
public class AppScenicBaseVO {

    private Long scenicId;

    private String name;

    private String description;

    private String coverUrl;
}