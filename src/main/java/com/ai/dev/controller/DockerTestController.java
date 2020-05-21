package com.ai.dev.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/20
 * @description:
 */
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class DockerTestController {

    @GetMapping(value = "/docker/{param}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String testDockerBuild(@PathVariable String param){
        if (param != null) {
            log.info("参数不等于空，打印日志");
            return "参数!=null,返回\"不等于空\"";
        }
        return null;
    }
}
