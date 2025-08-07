package cn.iocoder.yudao.module.travel.service.poi;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.travel.controller.admin.poi.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.poi.PoiDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.travel.dal.mysql.poi.PoiMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.travel.enums.ErrorCodeConstants.*;

/**
 * 景点POI Service 实现类
 *
 * @author alex
 */
@Service
@Validated
public class PoiServiceImpl implements PoiService {

    @Resource
    private PoiMapper poiMapper;

    @Override
    public Long createPoi(PoiSaveReqVO createReqVO) {
        // 插入
        PoiDO poi = BeanUtils.toBean(createReqVO, PoiDO.class);
        poiMapper.insert(poi);

        // 返回
        return poi.getId();
    }

    @Override
    public void updatePoi(PoiSaveReqVO updateReqVO) {
        // 校验存在
        validatePoiExists(updateReqVO.getId());
        // 更新
        PoiDO updateObj = BeanUtils.toBean(updateReqVO, PoiDO.class);
        poiMapper.updateById(updateObj);
    }

    @Override
    public void deletePoi(Long id) {
        // 校验存在
        validatePoiExists(id);
        // 删除
        poiMapper.deleteById(id);
    }

    @Override
        public void deletePoiListByIds(List<Long> ids) {
        // 删除
        poiMapper.deleteByIds(ids);
        }


    private void validatePoiExists(Long id) {
        if (poiMapper.selectById(id) == null) {
            throw exception(POI_NOT_EXISTS);
        }
    }

    @Override
    public PoiDO getPoi(Long id) {
        return poiMapper.selectById(id);
    }

    @Override
    public PageResult<PoiDO> getPoiPage(PoiPageReqVO pageReqVO) {
        return poiMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PoiDO> listPoiListByIds(Set<Long> poiIds) {
        return poiMapper.selectByIds(poiIds);
    }

}