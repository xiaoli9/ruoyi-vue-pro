package cn.iocoder.yudao.module.travel.controller.app.scenic.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "app - 景区分页 Request VO")
@Data
public class AppScenicPageReqVO extends PageParam {

    @Schema(description = "关键词", example = "西湖")
    private String keyword;
}