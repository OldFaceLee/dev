package com.ai.dev.testng;


import com.ai.dev.testng.report.ExtentTestNGIReporterListener;
import com.ai.dev.testng.testsuite.Testsuite;
import org.springframework.stereotype.Service;
import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/30 下午10:34
 * @description:
 */
@Service
public class InitilizedTestNG {

    public void runTestNG(String groups,boolean isParallelByMethod,int testngThreadCount){
        TestNG testNG = new TestNG();
        //执行的套件
        testNG.setTestClasses(new Class[]{Testsuite.class});
        //执行的测试组
        testNG.setGroups(groups);
        //extendReport监听器设置
        Class[] listenerClass = {ExtentTestNGIReporterListener.class};
        testNG.setListenerClasses(Arrays.asList(listenerClass));
        //判断是否需要并发
        if(isParallelByMethod){
            testNG.setParallel(XmlSuite.ParallelMode.METHODS);
            testNG.setThreadCount(testngThreadCount);
        }
        testNG.run();
    }
}