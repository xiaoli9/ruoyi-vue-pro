package cn.iocoder.yudao.module.travel.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * ar travel 错误码枚举类
 * <p>
 * ar travel 系统，使用 1-060-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 景区相关  1-060-001-000 ============
    ErrorCode SCENIC_NOT_EXISTS = new ErrorCode(1_060_001_001, "景区不存在");

    // ========== 景点POI相关  1-060-002-000 ============
    ErrorCode POI_NOT_EXISTS = new ErrorCode(1_060_002_001, "景点POI不存在");

    // ========== 路线相关  1-060-003-000 ============
    ErrorCode ROUTE_NOT_EXISTS = new ErrorCode(1_060_003_001, "路线不存在");

    ErrorCode ROUTE_LINE_NOT_EXISTS = new ErrorCode(1_060_003_002, "线不存在");

    // ========== 资源相关  1-060-004-000 ============
    ErrorCode RES_VALUE_NOT_EXISTS = new ErrorCode(1_060_004_001, "资源不存在");

    // ========== 资源相关  1-060-005-000 ============
    ErrorCode USER_FAVORITE_NOT_EXISTS = new ErrorCode(1_060_005_001, "用户收藏不存在");

}
