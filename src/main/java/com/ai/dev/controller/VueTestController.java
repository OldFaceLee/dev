package com.ai.dev.controller;

import com.ai.dev.common.controller.response.Response;
import com.ai.dev.mapper.customized.vo.VueTestRequest;
import com.ai.dev.mapper.customized.vo.VueTestSubmitRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
    public Response testPostVue(@RequestBody VueTestRequest vueTestRequest){
        Assert.notNull(vueTestRequest,"请求对象不能为空");
        System.out.println("vueTestRequest对象为 = " + vueTestRequest.getName()+"--"+vueTestRequest.getId());
        return new Response(vueTestRequest);
    }

    @GetMapping(value = "/testGetVue/{param}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response testGetVue(@PathVariable @Valid String param){
        Assert.hasText(param,"路径参数不能为空");
        log.info(String.format("前端传入的参数是：%s",param));
        return new Response(param);
    }

    @PostMapping(value = "/testSubmit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response testSubmit(@RequestBody @Valid VueTestSubmitRequest submitRequest){
        Assert.notNull(submitRequest,"参数不能为空");
        log.info(String.format("传入的密码为【%s】,传入的确认密码【%s】,传入的年龄【%d】",submitRequest.getPass(),submitRequest.getCheckPass(),submitRequest.getAge()));
        return new Response<>(submitRequest);
    }


}
