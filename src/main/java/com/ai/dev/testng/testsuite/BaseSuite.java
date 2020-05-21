package com.ai.dev.testng.testsuite;

import com.ai.dev.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/17 上午11:11
 * @description:
 */
@SpringBootTest(classes = Application.class)
public class BaseSuite extends AbstractTestNGSpringContextTests {
}
