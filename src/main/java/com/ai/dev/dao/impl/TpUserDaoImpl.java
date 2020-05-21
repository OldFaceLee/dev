package com.ai.dev.dao.impl;

import com.ai.dev.dao.ITpUserDao;
import com.ai.dev.em.UserEnum;
import com.ai.dev.mapper.interfaces.TpUserMapper;
import com.ai.dev.mapper.vo.TpUser;
import com.ai.dev.mapper.vo.TpUserCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/8 下午9:18
 * @description:
 */
@Service
public class TpUserDaoImpl implements ITpUserDao {

    @Autowired
    TpUserMapper tpUserMapper;

    @Override
    public List<TpUser> select(TpUser tpUser) {
        TpUserCriteria sql = new TpUserCriteria();
        if(StringUtils.hasText(tpUser.getName()) || StringUtils.hasText(tpUser.getPassWord())){
            return null;
        }
        sql.or().andNameEqualTo(tpUser.getUserName());
        return Optional.ofNullable(tpUserMapper.selectByExample(sql)).orElse(Collections.emptyList());
    }

    @Override
    public boolean userExsit(TpUser tpUser) {
        TpUserCriteria sql = new TpUserCriteria();
        sql.or().andNameEqualTo(tpUser.getName()).andIsValidEqualTo(UserEnum.USER_IS_INVALID.getValue());
        List<TpUser> userList = tpUserMapper.selectByExample(sql);
        return userList.size() != 0 ? true : false;
    }

    @Override
    public int insert(TpUser tpUser) {
        return tpUserMapper.insert(tpUser);
    }


}
