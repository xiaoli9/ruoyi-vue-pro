package cn.iocoder.yudao.module.travel.dal.dataobject.route;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 路线 DO
 *
 * @author alex
 */
@TableName("trv_route")
@KeySequence("trv_route_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteDO extends BaseDO {

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
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 游览时长:1小时
     */
    private String duration;
    /**
     * 公里
     */
    private BigDecimal distance;
    /**
     * 封面地址
     */
    private String coverUrl;
    /**
     * 是否需要vip
     *
     * 枚举 {@link TODO trv_vip 对应的类}
     */
    private Boolean isVip;
    /**
     * 1-正常 0-下架
     *
     * 枚举 {@link TODO trv_status 对应的类}
     */
    private Boolean status;


}