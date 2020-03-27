package com.ai.dev.dao.impl;

import com.ai.dev.dao.ITpTestsuiteDao;
import com.ai.dev.mapper.interfaces.TpTestsuiteMapper;
import com.ai.dev.mapper.vo.TpTestsuite;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午8:23
 * @description:
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TpTestsuiteDapImpl implements ITpTestsuiteDao {
    @Autowired
    TpTestsuiteMapper mapper;

    @Override
    public boolean insert(TpTestsuite tpTestsuite) {
        return mapper.insert(tpTestsuite) > 0 ? true : false;
    }

    @Override
    public boolean update(TpTestsuite tpTestsuite) {
        return mapper.updateByPrimaryKeySelective(tpTestsuite) >0 ? true : false;
    }
}
