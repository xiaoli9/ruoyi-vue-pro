package cn.iocoder.yudao.module.travel.dal.dataobject.route;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 画线 DO
 *
 * @author alex
 */
@TableName("trv_route_line")
@KeySequence("trv_route_line_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteLineDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 路线ID
     */
    private Long routeId;
    /**
     * poi点位id
     */
    private String poiIds;
    /**
     * 经纬度点
     */
    private String points;
    /**
     * 排序
     */
    private Integer sortOrder;

}