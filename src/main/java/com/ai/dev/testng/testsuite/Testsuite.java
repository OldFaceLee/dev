package com.ai.dev.testng.testsuite;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/30 下午11:12
 * @description:
 */
@Slf4j
public class Testsuite {

    @Test(groups = {"tc01"})
    public void test01(){
        log.info(Thread.currentThread().getName()+"测试01");
    }
    @Test(groups = {"tc02"})
    public void test02(){
        log.info(Thread.currentThread().getName()+"测试02");
    }
    @Test(groups = {"tc03"})
    public void test03(){
        log.info(Thread.currentThread().getName()+"测试03");
    }
}
