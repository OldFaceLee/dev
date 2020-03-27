package com.ai.dev.service.impl;

import com.ai.dev.dao.ITpTestcaseDao;
import com.ai.dev.mapper.vo.TpTestcase;
import com.ai.dev.service.ITestcaseSv;
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
        testcase.setUpdateDate(new Date());
        return tpTestcaseDao.update(testcase)>0 ? true : false;
    }
}
