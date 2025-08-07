package cn.iocoder.yudao.module.travel.controller.app.favorite.vo;

import cn.iocoder.yudao.module.travel.controller.app.scenic.vo.AppScenicBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "app - 景区 Response VO")
@Data
public class AppScenicCollectRespVO extends AppScenicBaseVO {

    private Boolean collected;

}