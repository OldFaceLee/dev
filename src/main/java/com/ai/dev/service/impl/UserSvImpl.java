package com.ai.dev.service.impl;

import com.ai.dev.dao.impl.UserDaoImpl;
import com.ai.dev.mapper.vo.TpUser;
import com.ai.dev.service.IUserSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/20 下午3:00
 * @description:
 */
@Service
public class UserSvImpl implements IUserSv {

    @Autowired
    UserDaoImpl userDao;

    @Override
    public void add(TpUser user) {
        userDao.addUser(user);
    }

    @Override
    public String name(String username,String password) {
        List<TpUser> user = userDao.select(username,password);
        List<String> firstName = user.stream().distinct().map(TpUser::getFirstname).filter(Objects::nonNull).collect(Collectors.toList());
        List<String> lastName = user.stream().distinct().map(TpUser::getLastname).filter(Objects::nonNull).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(lastName);
        return Optional.ofNullable(sb.toString()).orElse(null);
    }
}
