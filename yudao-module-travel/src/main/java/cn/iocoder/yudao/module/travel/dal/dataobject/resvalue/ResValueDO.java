package cn.iocoder.yudao.module.travel.dal.dataobject.resvalue;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 资源 DO
 *
 * @author alex
 */
@TableName("trv_res_value")
@KeySequence("trv_res_value_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResValueDO extends BaseDO {

    /**
     * ID
     */
    @TableId
    private Long id;
    /**
     * 类型
     */
    private Integer entityType;
    /**
     * 类型ID
     */
    private Long entityId;
    /**
     * 属性名
     */
    private String attrName;
    /**
     * 属性值
     */
    private String attrValue;


}