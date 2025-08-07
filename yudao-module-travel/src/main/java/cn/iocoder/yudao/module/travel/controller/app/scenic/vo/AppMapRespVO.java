package cn.iocoder.yudao.module.travel.controller.app.scenic.vo;

import cn.iocoder.yudao.module.travel.controller.app.poi.vo.AppMapPoiVO;
import lombok.Data;

import java.util.List;

@Data
public class AppMapRespVO extends AppScenicBaseVO{

    private String bgUrl;

    private String bgBounds;

    private List<AppMapPoiVO> poiList;
}