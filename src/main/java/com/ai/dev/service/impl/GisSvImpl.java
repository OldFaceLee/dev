package com.ai.dev.service.impl;

import com.ai.dev.common.controller.response.Response;
import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.dao.ITpGisDao;
import com.ai.dev.mapper.vo.TpGis;
import com.ai.dev.service.IGisSv;
import com.ai.dev.support.sysdate.ISysDateObtain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lixuejun
 * @date: Create in 2020/6/8
 * @description:
 */
@Service
public class GisSvImpl implements IGisSv {

    @Autowired
    ISysDateObtain sysDateObtain;

    @Autowired
    ITpGisDao gisDao;

    @Override
    public PageInfo<TpGis> compareLocation(Integer pageNo, Integer pageSize){
        return gisDao.query(pageNo,pageSize);
    }
}
