package cn.iocoder.yudao.module.travel.controller.app.poi.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "APP - 景点模块 VO")
@Data
@ExcelIgnoreUnannotated
public class AppPoiModuleVO {

    private String moduleId;

    private String lock;

    private String vip;

}