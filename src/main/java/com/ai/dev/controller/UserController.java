package com.ai.dev.controller;

import com.ai.dev.common.controller.response.Response;
import com.ai.dev.mapper.vo.TpUser;
import com.ai.dev.service.IUserSv;
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
public class UserController {

    @Autowired
    IUserSv userSv;

    @PostMapping(value = "/user/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response login(@RequestBody @Valid TpUser user){
        return new Response();
    }

    @PostMapping(value = "/user/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response addUser(@RequestBody @Valid TpUser user){
        log.info("入参"+ JSON.toJSON(user).toString());
        String name = userSv.name(user.getUsername(),user.getPassword());
        return new Response(name);
    }


}
