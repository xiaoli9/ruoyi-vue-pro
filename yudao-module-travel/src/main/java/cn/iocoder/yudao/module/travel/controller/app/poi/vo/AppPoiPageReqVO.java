package cn.iocoder.yudao.module.travel.controller.app.poi.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "app - 景点POI分页 Request VO")
@Data
public class AppPoiPageReqVO extends PageParam {

    @Schema(description = "景区ID", example = "12653")
    private Long scenicId;
}