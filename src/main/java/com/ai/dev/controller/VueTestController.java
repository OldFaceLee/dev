package com.ai.dev.controller;

import com.ai.dev.common.controller.response.Response;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.Valid;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/20
 * @description:
 */
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@CrossOrigin(origins = "*")
public class VueTestController {

    @PostMapping(value = "/testPostVue",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response testPostVue(@RequestBody String param){
        if (param != null) {
            log.info("参数不等于空，打印日志");
            return new Response(param);
        }
        return null;
    }

    @GetMapping(value = "/testGetVue/{param}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response testGetVue(@PathVariable @Valid String param){
        Assert.hasText(param,"路径参数不能为空");
        log.info(String.format("前端传入的参数是：%s",param));
        return new Response(param);
    }


}
