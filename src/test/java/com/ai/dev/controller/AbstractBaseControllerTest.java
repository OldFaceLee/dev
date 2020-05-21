package com.ai.dev.controller;

import com.ai.dev.Application;
import com.ai.dev.mapper.customized.TpTestcaseRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/21
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class AbstractBaseControllerTest {

    protected MockMvc mockMvc;

    private WebApplicationContext context;

    protected ObjectMapper objectMapper;


    @Before
    public void setUp(){
        /*this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .addFilters(new KongGatewayAuthenticationProcessingFilter(accountDetailsService))
                .build();*/
    }



}
