package com.ai.dev.service;

import com.ai.dev.mapper.vo.TpUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/20 下午2:59
 * @description:
 */
public interface IUserSv {

    public void add(TpUser user);

    public String name(String username,String password);
}
