package cn.iocoder.yudao.module.travel.service.route;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.travel.controller.admin.route.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.route.RouteDO;
import cn.iocoder.yudao.module.travel.dal.dataobject.route.RouteLineDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.travel.dal.mysql.route.RouteMapper;
import cn.iocoder.yudao.module.travel.dal.mysql.route.RouteLineMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.travel.enums.ErrorCodeConstants.*;

/**
 * 路线 Service 实现类
 *
 * @author alex
 */
@Service
@Validated
public class RouteServiceImpl implements RouteService {

    @Resource
    private RouteMapper routeMapper;
    @Resource
    private RouteLineMapper routeLineMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createRoute(RouteSaveReqVO createReqVO) {
        // 插入
        RouteDO route = BeanUtils.toBean(createReqVO, RouteDO.class);
        routeMapper.insert(route);


        // 插入子表
        createRouteLineList(route.getId(), createReqVO.getRouteLines());
        // 返回
        return route.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRoute(RouteSaveReqVO updateReqVO) {
        // 校验存在
        validateRouteExists(updateReqVO.getId());
        // 更新
        RouteDO updateObj = BeanUtils.toBean(updateReqVO, RouteDO.class);
        routeMapper.updateById(updateObj);

        // 更新子表
        updateRouteLineList(updateReqVO.getId(), updateReqVO.getRouteLines());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRoute(Long id) {
        // 校验存在
        validateRouteExists(id);
        // 删除
        routeMapper.deleteById(id);

        // 删除子表
        deleteRouteLineByRouteId(id);
    }

    @Override
        @Transactional(rollbackFor = Exception.class)
    public void deleteRouteListByIds(List<Long> ids) {
        // 删除
        routeMapper.deleteByIds(ids);
    
    // 删除子表
            deleteRouteLineByRouteIds(ids);
    }


    private void validateRouteExists(Long id) {
        if (routeMapper.selectById(id) == null) {
            throw exception(ROUTE_NOT_EXISTS);
        }
    }

    @Override
    public RouteDO getRoute(Long id) {
        return routeMapper.selectById(id);
    }

    @Override
    public PageResult<RouteDO> getRoutePage(RoutePageReqVO pageReqVO) {
        return routeMapper.selectPage(pageReqVO);
    }

    // ==================== 子表（画线） ====================

    @Override
    public List<RouteLineDO> getRouteLineListByRouteId(Long routeId) {
        return routeLineMapper.selectListByRouteId(routeId);
    }

    private void createRouteLineList(Long routeId, List<RouteLineDO> list) {
        list.forEach(o -> o.setRouteId(routeId).clean());
        routeLineMapper.insertBatch(list);
    }

    private void updateRouteLineList(Long routeId, List<RouteLineDO> list) {
	    list.forEach(o -> o.setRouteId(routeId).clean());
	    List<RouteLineDO> oldList = routeLineMapper.selectListByRouteId(routeId);
	    List<List<RouteLineDO>> diffList = diffList(oldList, list, (oldVal, newVal) -> {
            boolean same = ObjectUtil.equal(oldVal.getId(), newVal.getId());
            if (same) {
                newVal.setId(oldVal.getId()).clean(); // 解决更新情况下：updateTime 不更新
            }
            return same;
	    });

	    // 第二步，批量添加、修改、删除
	    if (CollUtil.isNotEmpty(diffList.get(0))) {
	        routeLineMapper.insertBatch(diffList.get(0));
	    }
	    if (CollUtil.isNotEmpty(diffList.get(1))) {
	        routeLineMapper.updateBatch(diffList.get(1));
	    }
	    if (CollUtil.isNotEmpty(diffList.get(2))) {
	        routeLineMapper.deleteByIds(convertList(diffList.get(2), RouteLineDO::getId));
	    }
    }

    private void deleteRouteLineByRouteId(Long routeId) {
        routeLineMapper.deleteByRouteId(routeId);
    }

	private void deleteRouteLineByRouteIds(List<Long> routeIds) {
        routeLineMapper.deleteByRouteIds(routeIds);
	}

}