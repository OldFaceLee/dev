package com.ai.dev.controller;

import com.ai.dev.common.controller.response.Response;
import com.ai.dev.mapper.vo.TpTestcase;
import com.ai.dev.mapper.vo.TpUser;
import com.ai.dev.service.ITestcaseSv;
import com.alibaba.fastjson.JSON;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/20 下午2:48
 * @description:
 */
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TestcaseController {


    @Autowired
    ITestcaseSv testcaseSv;

    @PostMapping(value = "/testcase/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean addTestcase(@RequestBody @Valid TpTestcase testcase){
        log.info("传入的参数"+JSON.toJSONString(testcase));
        return testcaseSv.addTestcase(testcase);
    }

    @PostMapping(value = "/testcase/update",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean updateTestcase(@RequestBody @Valid TpTestcase testcase){
        return testcaseSv.updateTestcase(testcase);
    }


}