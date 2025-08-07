package cn.iocoder.yudao.module.travel.controller.app.favorite.vo;

import cn.iocoder.yudao.module.travel.controller.app.poi.vo.AppPoiBaseVO;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "APP - 景点POI Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppPoiCollectRespVO extends AppPoiBaseVO {

    @ExcelProperty("收藏状态")
    private Boolean collected;

}