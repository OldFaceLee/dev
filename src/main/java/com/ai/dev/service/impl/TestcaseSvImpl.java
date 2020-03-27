package com.ai.dev.service.impl;

import com.ai.dev.dao.ITpTestcaseDao;
import com.ai.dev.mapper.vo.TpTestcase;
import com.ai.dev.service.ITestcaseSv;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Override
    public boolean addTestcase(TpTestcase testcase) {
        Assert.notNull(testcase,"测试用例对象不能为空");
        testcase.setCreateDate(new Date());
        return tpTestcaseDao.insert(testcase) >0 ? true : false;
    }

    @Override
    public boolean updateTestcase(TpTestcase testcase) {
        Assert.notNull(testcase,"测试用例对象不能为空");
        log.info("传入参数"+ JSON.toJSONString(testcase));
        testcase.setUpdateDate(new Date(System.currentTimeMillis()));
        log.info("设置的update时间"+testcase.getUpdateDate());
        return tpTestcaseDao.update(testcase)>0 ? true : false;
    }

}
