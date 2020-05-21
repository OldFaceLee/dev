package com.ai.dev.testng.testsuite;

import com.ai.dev.common.testcase.CommonCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/30 下午11:12
 * @description:
 */
@Slf4j
public class Testsuite extends BaseSuite{

    @Autowired
    CommonCase commonCase;

    @DataProvider(name = "testData")
    public Object[][] dataProvider(){
        commonCase.setJsonParam("111");
        commonCase.setJsonParam("222");
        return new Object[][]{
                {commonCase}
        };
    }


    @Test(dataProvider = "testData")
    public void testcase(CommonCase cc){
        System.out.println(cc.getJsonParam());
        System.out.println("执行线程名=>"+Thread.currentThread().getName());

    }
}
