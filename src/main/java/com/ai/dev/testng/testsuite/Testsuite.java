package com.ai.dev.testng.testsuite;

import com.ai.dev.common.testcase.CommonCase;
import lombok.extern.slf4j.Slf4j;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/30 下午11:12
 * @description:
 */
@Slf4j
public class Testsuite {

    @DataProvider(name = "testData")
    public static Object[][] dataProvider(){
        return new Object[][]{};
    }

    @Test(dataProvider = "testData")
    public void testcase(CommonCase commonCase){
        Reporter.log("执行线程名=>"+Thread.currentThread().getName());

    }
}
