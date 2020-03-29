package com.ai.dev.service.impl;

import com.ai.dev.common.controller.response.PageInfo;
import com.ai.dev.dao.ITpTestcaseDao;
import com.ai.dev.em.TestcaseEnum;
import com.ai.dev.mapper.customized.TpTestcaseRequest;
import com.ai.dev.mapper.vo.TpTestcase;
import com.ai.dev.service.ITestcaseSv;
import com.ai.dev.support.sysdate.ISysDateObtain;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        testcase.setIsValid(TestcaseEnum.VALID.getValue());
        return tpTestcaseDao.insert(testcase) >0 ? true : false;
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

}
