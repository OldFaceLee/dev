package com.ai.dev.dao.impl;

import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.dao.ITpGisDao;
import com.ai.dev.mapper.interfaces.TpGisMapper;
import com.ai.dev.mapper.vo.TpGis;
import com.ai.dev.mapper.vo.TpGisCriteria;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lixuejun
 * @date: Create in 2020/6/8
 * @description:
 */
@Service
public class TpGisDaoImpl implements ITpGisDao {

    @Autowired
    TpGisMapper mapper;

    @Override
    public PageInfo<TpGis> query(Integer pageNO, Integer PageSize) {
        TpGisCriteria sql = new TpGisCriteria();
        return new PageInfo<>(PageHelper.startPage(pageNO,PageSize).doSelectPageInfo(()->mapper.selectByExample(sql)));
    }
}
