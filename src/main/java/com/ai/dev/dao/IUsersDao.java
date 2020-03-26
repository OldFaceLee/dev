package com.ai.dev.dao;

import com.ai.dev.mapper.vo.TpUser;


import java.util.List;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/20 下午1:51
 * @description:
 */
public interface IUsersDao {

    void insert(TpUser users);

    void update(TpUser users);

    List<TpUser> select(String username,String password);

    void addUser(TpUser users);

    void registeUser(TpUser users);
}
