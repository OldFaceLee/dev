package com.ai.dev.dao.impl;

import com.ai.dev.dao.IUsersDao;
import com.ai.dev.mapper.interfaces.TpUserMapper;
import com.ai.dev.mapper.vo.TpUser;
import com.ai.dev.mapper.vo.TpUserCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/20 下午1:54
 * @description:
 */
@Service
@Slf4j
public class UserDaoImpl implements IUsersDao {

    @Autowired
    TpUserMapper mapper;

    @Override
    public void insert(TpUser users) {
        mapper.insert(users);
    }

    @Override
    public void update(TpUser users) {

    }

    @Override
    public List<TpUser> select(String username,String password) {
        Assert.hasText(username,"用户名不能为空");
        Assert.hasText(password,"密码不能为空");
        TpUserCriteria sql = new TpUserCriteria();
        TpUserCriteria.Criteria criteria = sql.or();
        criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
        return Optional.ofNullable(mapper.selectByExample(sql)).orElse(Collections.emptyList());
    }

    @Override
    public void addUser(TpUser users) {
        this.insert(users);

    }

    @Override
    public void registeUser(TpUser users) {

    }

}
