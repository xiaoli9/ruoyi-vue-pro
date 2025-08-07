package cn.iocoder.yudao.module.travel.controller.app.favorite.vo;

import cn.iocoder.yudao.module.travel.enums.FavoriteTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "APP - 景点收藏 Request VO")
@Data
public class AppFavoriteReqVO {

    @NotNull(message = "itemId 不能为空")
    private Long itemId;

    @NotNull(message = "itemType 不能为空")
    private FavoriteTypeEnum itemType;
}