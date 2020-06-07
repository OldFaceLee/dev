package com.ai.dev.controller;

import com.ai.dev.common.controller.response.Response;
import com.ai.dev.dao.ITpUserDao;
import com.ai.dev.mapper.vo.TpUser;
import com.ai.dev.support.sysdate.ISysDateObtain;
import com.alibaba.fastjson.JSON;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/8 下午9:32
 * @description:
 */
@RestController
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(value = "*")
public class UserController {

    @Autowired
    ITpUserDao userDao;

    @Autowired
    ISysDateObtain sysDateObtain;

    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<TpUser> login(TpUser user){
        Assert.notNull(user,"必须传入用户名与密码");
        List<TpUser> userList = userDao.select(user);
        List<String> userName = userList.stream().map(TpUser::getName).filter(Objects::nonNull).collect(Collectors.toList());
        List<String> userPwd = userList.stream().map(TpUser::getPassWord).filter(Objects::nonNull).collect(Collectors.toList());
        if(user.getName().equals(userName.get(0))){
            if(user.getPassWord().equals(userPwd.get(0))){
                return new Response (userList);
            }
        }
        return null;
    }
    @PostMapping(value = "/user/register",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response register(@RequestBody @Valid TpUser user){
        log.info("传入的user对象"+ JSON.toJSONString(user));
        boolean isExsitUser = userDao.userExsit(user);
        if(!isExsitUser){
            userDao.insert(user);
            user.setCreateDate(sysDateObtain.getSysdate());
        }
        return new Response();
    }
}
