package cn.iocoder.yudao.module.travel.service.resvalue;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.travel.controller.admin.resvalue.vo.*;
import cn.iocoder.yudao.module.travel.dal.dataobject.resvalue.ResValueDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.travel.dal.mysql.resvalue.ResValueMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.travel.enums.ErrorCodeConstants.*;

/**
 * 资源 Service 实现类
 *
 * @author alex
 */
@Service
@Validated
public class ResValueServiceImpl implements ResValueService {

    @Resource
    private ResValueMapper resValueMapper;

    @Override
    public Long createResValue(ResValueSaveReqVO createReqVO) {
        // 插入
        ResValueDO resValue = BeanUtils.toBean(createReqVO, ResValueDO.class);
        resValueMapper.insert(resValue);

        // 返回
        return resValue.getId();
    }

    @Override
    public void updateResValue(ResValueSaveReqVO updateReqVO) {
        // 校验存在
        validateResValueExists(updateReqVO.getId());
        // 更新
        ResValueDO updateObj = BeanUtils.toBean(updateReqVO, ResValueDO.class);
        resValueMapper.updateById(updateObj);
    }

    @Override
    public void deleteResValue(Long id) {
        // 校验存在
        validateResValueExists(id);
        // 删除
        resValueMapper.deleteById(id);
    }

    @Override
        public void deleteResValueListByIds(List<Long> ids) {
        // 删除
        resValueMapper.deleteByIds(ids);
        }


    private void validateResValueExists(Long id) {
        if (resValueMapper.selectById(id) == null) {
            throw exception(RES_VALUE_NOT_EXISTS);
        }
    }

    @Override
    public ResValueDO getResValue(Long id) {
        return resValueMapper.selectById(id);
    }

    @Override
    public PageResult<ResValueDO> getResValuePage(ResValuePageReqVO pageReqVO) {
        return resValueMapper.selectPage(pageReqVO);
    }

}