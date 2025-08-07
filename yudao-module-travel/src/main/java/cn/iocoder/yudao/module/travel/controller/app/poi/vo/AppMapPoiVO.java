package cn.iocoder.yudao.module.travel.controller.app.poi.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 景点POI
 *
 * @author alex
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppMapPoiVO extends AppPoiBaseVO {

    private Long categoryId;

    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
}