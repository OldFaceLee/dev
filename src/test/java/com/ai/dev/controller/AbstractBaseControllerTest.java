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
import org.springframework.mock.web.MockHttpServletRequest;
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
 * @date: Create in 2020/5/26
 * @description: MocMVC 的post get封装
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public abstract class AbstractBaseControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    /**
     * Get请求
     * @param uri
     * @param header
     * @return
     */
    public JSONObject get(String uri,Map<String,String> header){
        String response = null;
        try {
            response = this.commonRequest("get",uri,header,null)
                    .andReturn().getResponse().getContentAsString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("返回的结果"+response);
        return JSON.parseObject(response);
    }


    /**
     * post请求方法
     * @param uri
     * @param jsonParam
     * @return 返回JSON对象
     */
    public JSONObject post(String uri, Map<String,String> header, String jsonParam){
        String response = null;
        try {
            response = this.commonRequest("post",uri,header,jsonParam)
                    .andReturn().getResponse().getContentAsString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("返回的结果"+response);
        return JSON.parseObject(response);
    }


    private ResultActions commonRequest(String getOrPost,String uri,Map<String,String>header,String jsonParam){
        HttpHeaders httpHeaders = new HttpHeaders();
        ResultActions actions = null;
        header.forEach((k,v)->{
            httpHeaders.add(k,v);
        });
        log.info(String.format("传入的headers：%s",httpHeaders.toString()));
        if(getOrPost.equalsIgnoreCase("post")){
            try {
                log.info("触发Post请求...");
                log.info(String.format("传入的jsonParam: %s",jsonParam));
                actions = mockMvc.perform(MockMvcRequestBuilders.post(new URI(uri))
                        .headers(httpHeaders)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonParam));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(getOrPost.equalsIgnoreCase("get")){
            try {
                log.info("触发Get请求...");
                actions = mockMvc.perform(MockMvcRequestBuilders.get(new URI(uri))
                        .headers(httpHeaders)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return actions;

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
