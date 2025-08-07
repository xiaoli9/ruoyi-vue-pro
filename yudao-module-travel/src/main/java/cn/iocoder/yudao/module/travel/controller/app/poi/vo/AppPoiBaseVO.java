package cn.iocoder.yudao.module.travel.controller.app.poi.vo;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 景点POI DO
 *
 * @author alex
 */
@Data
public class AppPoiBaseVO {

    /**
     * id
     */
    private Long poiId;
    /**
     * 名称
     */
    private String name;
    /**
     * 封面地址
     */
    private String coverUrl;
    /**
     * icon地址
     */
    private String iconUrl;
    /**
     * 描述
     */
    private String description;

}