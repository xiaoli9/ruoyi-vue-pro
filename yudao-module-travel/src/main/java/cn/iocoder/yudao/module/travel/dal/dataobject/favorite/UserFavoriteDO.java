package cn.iocoder.yudao.module.travel.dal.dataobject.favorite;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 用户收藏 DO
 *
 * @author 芋道源码
 */
@TableName("trv_user_favorite")
@KeySequence("trv_user_favorite_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFavoriteDO extends BaseDO {

    /**
     * 收藏编号
     */
    @TableId
    private Long id;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 收藏类型:景点或景区
     */
    private String itemType;
    /**
     * 对应类型的ID
     */
    private Long itemId;


}