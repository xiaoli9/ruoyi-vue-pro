package cn.iocoder.yudao.module.travel.enums;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 收藏枚举
 * @author XIYU
 */
@Getter
@AllArgsConstructor
public enum FavoriteTypeEnum implements ArrayValuable<String> {

    POI("poi", "景点"),
    SCENIC("scenic", "景区");

    public static final String[] ARRAYS = Arrays.stream(values()).map(FavoriteTypeEnum::getCode).toArray(String[]::new);

    /**
     * 星级
     */
    private final String code;

    /**
     * 星级名
     */
    private final String name;

    @Override
    public String[] array() {
        return ARRAYS;
    }

}
