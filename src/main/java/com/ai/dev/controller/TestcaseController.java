package com.ai.dev.controller;

import com.ai.dev.common.controller.response.Response;
import com.ai.dev.mapper.vo.TpHttpCase;
import com.ai.dev.service.ITestcaseSv;
import com.alibaba.fastjson.JSON;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/20 下午2:48
 * @description:
 */
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@CrossOrigin(origins = "*")
public class TestcaseController {


    @Autowired
    ITestcaseSv testcaseSv;

    @PostMapping(value = "/testcase/restful/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response addTestcase(@RequestBody @Valid TpHttpCase tpHttpCase){
        log.info("接收的参数："+JSON.toJSONString(tpHttpCase));
        return new Response<>(testcaseSv.addTestCase(tpHttpCase));
    }





}
