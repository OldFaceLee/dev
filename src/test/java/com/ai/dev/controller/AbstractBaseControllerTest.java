package com.ai.dev.controller;

import com.ai.dev.Application;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Map;


/**
 * @author: lixuejun
 * @date: Create in 2020/5/21
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public abstract class AbstractBaseControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext context;

    public JSONObject get(String uri){
        return null;
    }


    /**
     * post请求方法
     * @param uri
     * @param jsonParam
     * @return 返回JSON对象
     */
    public JSONObject post(String uri, Map<String,String> header, String jsonParam){
        String response = null;
        ResultActions actions = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        header.forEach((k,v)->{
            httpHeaders.add(k,v);
        });
        log.info(String.format("传入的headers：%s",httpHeaders.toString()));
        log.info(String.format("传入的jsonParam: %s",jsonParam));
        try {
            actions = mockMvc.perform(MockMvcRequestBuilders.post(new URI(uri))
                    .headers(httpHeaders)
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonParam));
            response = actions.andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("返回的结果"+response);
        return JSON.parseObject(response);
    }

    @Before
    public void setUp(){
       log.info("开始controller层测试");
       mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
       log.info("初始化WebApplicationContext对象");
    }

    @After
    public void tearDown(){
        log.info("结束controller层测试");
    }



}
