package com.ai.dev.dao;

import com.ai.dev.mapper.vo.TpUser;

import java.util.List;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/8 下午9:15
 * @description:
 */
public interface ITpUserDao {

    List<TpUser> select(TpUser tpUser);

    boolean userExsit(TpUser tpUser);

    int insert(TpUser tpUser);
}
