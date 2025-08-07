package cn.iocoder.yudao.module.travel.service.scenic;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.travel.controller.admin.scenic.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.scenic.ScenicDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.travel.dal.mysql.scenic.ScenicMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.travel.enums.ErrorCodeConstants.*;

/**
 * 景区 Service 实现类
 *
 * @author alex
 */
@Service
@Validated
public class ScenicServiceImpl implements ScenicService {

    @Resource
    private ScenicMapper scenicMapper;

    @Override
    public Long createScenic(ScenicSaveReqVO createReqVO) {
        // 插入
        ScenicDO scenic = BeanUtils.toBean(createReqVO, ScenicDO.class);
        scenicMapper.insert(scenic);

        // 返回
        return scenic.getId();
    }

    @Override
    public void updateScenic(ScenicSaveReqVO updateReqVO) {
        // 校验存在
        validateScenicExists(updateReqVO.getId());
        // 更新
        ScenicDO updateObj = BeanUtils.toBean(updateReqVO, ScenicDO.class);
        scenicMapper.updateById(updateObj);
    }

    @Override
    public void deleteScenic(Long id) {
        // 校验存在
        validateScenicExists(id);
        // 删除
        scenicMapper.deleteById(id);
    }

    @Override
        public void deleteScenicListByIds(List<Long> ids) {
        // 删除
        scenicMapper.deleteByIds(ids);
        }


    private void validateScenicExists(Long id) {
        if (scenicMapper.selectById(id) == null) {
            throw exception(SCENIC_NOT_EXISTS);
        }
    }

    @Override
    public ScenicDO getScenic(Long id) {
        return scenicMapper.selectById(id);
    }

    @Override
    public PageResult<ScenicDO> getScenicPage(ScenicPageReqVO pageReqVO) {
        return scenicMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ScenicDO> listScenicListByIds(Set<Long> scenicIds) {
        return scenicMapper.selectByIds(scenicIds);
    }

}