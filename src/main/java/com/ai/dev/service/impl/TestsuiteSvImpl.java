package com.ai.dev.service.impl;

import com.ai.dev.dao.ITpTestsuiteDao;
import com.ai.dev.mapper.customized.TpTestsuiteRequest;
import com.ai.dev.mapper.vo.TpTestsuite;
import com.ai.dev.service.ITestsuiteSv;
import com.ai.dev.testng.InitilizedTestNG;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午8:30
 * @description:
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TestsuiteSvImpl implements ITestsuiteSv {

    @Autowired
    ITpTestsuiteDao tpTestsuiteDao;

    @Autowired
    InitilizedTestNG testNG;

    @Override
    public boolean addCaseToSuite(TpTestsuite tpTestsuite) {
        tpTestsuite.setCreateDate(new Date());
        return tpTestsuiteDao.insert(tpTestsuite);
    }

    @Override
    public String runSuite(TpTestsuiteRequest tpTestsuiteRequest) {
        testNG.runTestNG(tpTestsuiteRequest.getGroups(),tpTestsuiteRequest.isParallelByMethod(),tpTestsuiteRequest.getTestngThreadCount());
        return "reportUrl";
    }
}
