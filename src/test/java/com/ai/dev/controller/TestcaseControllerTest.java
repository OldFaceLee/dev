package com.ai.dev.controller;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ai.dev.Application;
import com.ai.dev.mapper.vo.TpHttpCase;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/26
 * @description:
 */
@Slf4j
public class TestcaseControllerTest extends AbstractBaseControllerTest{


    @Test
    public void addHttpCase(){
        TpHttpCase tpHttpCase = new TpHttpCase();
        tpHttpCase.setCaseId("TC002");
        tpHttpCase.setSystemName("京东");
        tpHttpCase.setCaseName("第一个controller测试");
        tpHttpCase.setCaseDesc("测试的描述");
        tpHttpCase.setCaseGroups("http接口测试组");
        tpHttpCase.setUri("/testcase/restful/add");
        tpHttpCase.setPort(8080);
        tpHttpCase.setHeader("{\"auth\":\"token\"}");
        tpHttpCase.setRequestBody("{\"paramKey\":\"paramValue\"}");
        tpHttpCase.setCheckSql("select * from tp_http_case");

        Map<String,String> header = new HashMap<String,String>();
        header.put("auth","value");
        header.put("type","application/json");
        post("/testcase/restful/add",header,JSON.toJSONString(tpHttpCase));

    }

    @Test
    public void runCase(){
        TpHttpCase tpHttpCase = new TpHttpCase();
        tpHttpCase.setCaseId("TC005");
        tpHttpCase.setSystemName("testNG");
        tpHttpCase.setCaseName("通过testNG设置");
        tpHttpCase.setCaseDesc("描述testNG");
        tpHttpCase.setCaseGroups("组testNG");
        tpHttpCase.setRequestType(1);
        tpHttpCase.setUri("http://localhost:8080/testcase/restful/add");
        tpHttpCase.setPort(0);
        tpHttpCase.setHeader("{\"auth\":\"accessToken\"}");
        tpHttpCase.setRequestBody("{\"key\":\"value\"}");
        tpHttpCase.setCheckSql("select * from table");
        tpHttpCase.setExpectedResult("这就是期望的");
        tpHttpCase.setCreateUser("李学军");
        tpHttpCase.setCreateDate(new Date());
        tpHttpCase.setOperateUser("李学军");
        tpHttpCase.setUpdateDate(new Date());
        tpHttpCase.setIsValid(1);

        Map<String,String> header = new HashMap<String,String>();
        header.put("auth","value");
        header.put("type","application/json");
        post("/testcase/run",header,JSON.toJSONString(tpHttpCase));

    }


    @Test
    public void testAjax(){
        get("/test/ajax/params",new HashMap<>());
    }

}
