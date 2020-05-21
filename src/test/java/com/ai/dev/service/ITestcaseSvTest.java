package com.ai.dev.service;
import java.util.Date;

import com.ai.dev.Application;
import com.ai.dev.mapper.vo.TpTestcase;
import com.ai.dev.support.sysdate.ISysDateObtain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.*;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/21
 * @description:
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@TestConfiguration
public class ITestcaseSvTest {

    @Autowired
    ITestcaseSv testcaseSv;

    @Autowired
    ISysDateObtain dataBaseDate;

    @Test
    public void test_addTestcase(){
        TpTestcase tpTestcase = new TpTestcase();
        tpTestcase.setId(0);
        tpTestcase.setCaseId("");
        tpTestcase.setRequestType("");
        tpTestcase.setCaseName("");
        tpTestcase.setCaseDesc("");
        tpTestcase.setCaseGroups("");
        tpTestcase.setUri("");
        tpTestcase.setHeader("");
        tpTestcase.setParam("");
        tpTestcase.setUpdateDate(new Date());
        tpTestcase.setCreateDate(new Date());
        tpTestcase.setCreateOwner("");
        tpTestcase.setIsValid(0);










        /*tpTestcase.setCreateDate(dataBaseDate.getSysdate());
        tpTestcase.setUpdateDate(dataBaseDate.getSysdate());
        tpTestcase.setCaseDesc("service实现测试描述");
        tpTestcase.setCaseGroups("service实现测试用例组描述");
        tpTestcase.setCaseId("520");
        tpTestcase.setCaseName("520实现");
        tpTestcase.setCreateOwner("李学军");
        tpTestcase.setHeader("Header");
        tpTestcase.setIsValid(1);
        tpTestcase.setParam("参数");
        tpTestcase.setRequestType("post");
        tpTestcase.setUri("/url/test");
        boolean result = testcaseSv.addTestcase(tpTestcase);
        log.info(String.format("测试结果为: %s",result));*/
//        Assert.assertTrue(result);
    }


}
