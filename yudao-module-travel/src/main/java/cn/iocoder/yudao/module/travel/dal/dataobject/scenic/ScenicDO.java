package cn.iocoder.yudao.module.travel.dal.dataobject.scenic;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 景区 DO
 *
 * @author alex
 */
@TableName("trv_scenic")
@KeySequence("trv_scenic_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScenicDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 封面地址
     */
    private String coverUrl;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否有ar
     *
     * 枚举 {@link TODO trv_ar 对应的类}
     */
    private Boolean hasAr;
    /**
     * 背景图
     */
    private String bgUrl;
    /**
     * 图片覆盖区域
     */
    private String bgBounds;
    /**
     * 音频
     */
    private String audioUrl;
    /**
     * 富文本
     */
    private String richText;
    /**
     * 地址
     */
    private String address;
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