package com.ai.dev.controller;

import com.ai.dev.dao.ITpTestsuiteDao;
import com.ai.dev.mapper.vo.TpTestsuite;
import com.ai.dev.service.ITestsuiteSv;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.*;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午8:19
 * @description:
 */
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestSuiteController {

    @Autowired
    ITestsuiteSv testsuiteSv;

    @PostMapping(value = "/testsuite/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean addTestsuite(@RequestBody @Valid TpTestsuite tpTestsuite){
       return testsuiteSv.addCaseToSuite(tpTestsuite);
    }


}
