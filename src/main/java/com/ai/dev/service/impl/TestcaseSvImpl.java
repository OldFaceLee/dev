package com.ai.dev.service.impl;

import com.ai.dev.common.exception.handler.ValidateResult;
import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.dao.IHttpCaseDao;
import com.ai.dev.dao.ITpTestcaseDao;
import com.ai.dev.mapper.customized.ICustomizedTpTestcaseDao;
import com.ai.dev.mapper.customized.TpTestcaseRequest;
import com.ai.dev.mapper.vo.TpHttpCase;
import com.ai.dev.mapper.vo.TpTestcase;
import com.ai.dev.service.ITestcaseSv;
import com.ai.dev.support.exception.HttpCaseException;
import com.ai.dev.support.sysdate.ISysDateObtain;
import com.ai.dev.testng.testsuite.TestNGRunCase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.testng.TestNG;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午6:16
 * @description:
 */
@Service
@Slf4j
public class TestcaseSvImpl implements ITestcaseSv {

    @Autowired
    ITpTestcaseDao tpTestcaseDao;

    @Autowired
    IHttpCaseDao httpCaseDao;

    @Autowired
    ISysDateObtain sysDateObtain;


    @Override
    public boolean addTestcase(TpTestcase testcase) {
        Assert.notNull(testcase,"测试用例对象不能为空");
        List<TpTestcase> isCaseExsit= tpTestcaseDao.select(testcase.getCaseId());
        List<String> caseID = isCaseExsit.stream().map(TpTestcase::getCaseId).filter(Objects::nonNull).collect(Collectors.toList());
        if(caseID.size() != 0){
            if(testcase.getCaseId().equals(caseID.get(0))){
                log.info("传入的caseID"+testcase.getCaseId()+"已经存在数据库表tpTestcase中");
                return false;
            }
        }
        testcase.setCreateDate(sysDateObtain.getSysdate());
//        testcase.setIsValid(TestcaseEnum.VALID.getValue());
        return tpTestcaseDao.insert(testcase) >0 ? true : false;
    }

    @Override
    public TpHttpCase addTestCase(TpHttpCase tpHttpCase) {
        Assert.notNull(tpHttpCase,"httpcase对象不能为空");
        List<TpHttpCase> cases = httpCaseDao.obtainHttpCase(tpHttpCase);
        List<String> caseId = cases.stream().map(TpHttpCase::getCaseId).collect(Collectors.toList());
        if(caseId.size() > 0){
            log.info("所有的case"+caseId.toString());
            caseId.forEach(id->{
                if(id.equals(tpHttpCase.getCaseId())) {
                    List<String> message = Stream.of("存在了").collect(Collectors.toList());
                    Assert.isTrue(!id.equals(tpHttpCase.getCaseId()),String.format("caseId【%s】已存在",tpHttpCase.getCaseId()));
                    throw new RuntimeException(String.format("已存在"));
                }
            });
        }
        log.info("接受的数据："+JSON.toJSONString(tpHttpCase));
        tpHttpCase.setCreateUser(tpHttpCase.getCreateUser());
        tpHttpCase.setCreateDate(sysDateObtain.getSysdate());
        tpHttpCase.setIsValid(1);
        log.info("准备存入数据库的数据:"+JSON.toJSONString(tpHttpCase));
        if(tpTestcaseDao.insert(tpHttpCase) > 0){
            log.info("数据库操作执行："+tpTestcaseDao.insert(tpHttpCase));
            return tpHttpCase;
        }
        return null;
    }

    @Override
    public void runTestNGCase(TpHttpCase tpHttpCase) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{TestNGRunCase.class});
        testNG.run();
    }

    @Override
    public boolean updateTestcase(TpTestcase testcase) {
        Assert.notNull(testcase,"测试用例对象不能为空");
        log.info("传入参数"+ JSON.toJSONString(testcase));
        testcase.setUpdateDate(sysDateObtain.getSysdate());
        log.info("设置的update时间"+testcase.getUpdateDate());
        return tpTestcaseDao.update(testcase)>0 ? true : false;
    }

    @Override
    public PageInfo<TpTestcase> queryTestcase(TpTestcaseRequest testcase) {
        return tpTestcaseDao.queryForPageInfo(testcase);
    }

    @Override
    public TpTestcase customizedQueryCaseId(String caseId) {
        if(StringUtils.isEmpty(caseId)){
            return null;
        }
        return null;
    }

}
