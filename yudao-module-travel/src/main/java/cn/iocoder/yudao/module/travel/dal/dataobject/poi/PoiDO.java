package cn.iocoder.yudao.module.travel.dal.dataobject.poi;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 景点POI DO
 *
 * @author alex
 */
@TableName("trv_poi")
@KeySequence("trv_poi_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PoiDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 景区ID
     */
    private Long scenicId;
    /**
     * 名称
     */
    private String name;
    /**
     * icon地址
     */
    private String iconUrl;
    /**
     * 描述
     */
    private String description;
    /**
     * 封面地址
     */
    private String coverUrl;
    /**
     * 有AR
     *
     * 枚举 {@link TODO trv_ar 对应的类}
     */
    private Boolean hasAr;
    /**
     * 需要vip
     *
     * 枚举 {@link TODO trv_vip 对应的类}
     */
    private Boolean isVip;
    /**
     * 音频地址
     */
    private String audioUrl;
    /**
     * 模块开启情况：1,true,true|2,false,false
     */
    private String module;
    /**
     * 富文本
     */
    private String richText;
    /**
     * 跳转地址
     */
    private String forward;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 分类ID
     */
    private Long categoryId;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 状态
     *
     * 枚举 {@link TODO trv_status 对应的类}
     */
    private Boolean status;


}