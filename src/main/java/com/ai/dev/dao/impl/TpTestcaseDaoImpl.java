package com.ai.dev.dao.impl;

import com.ai.dev.dao.ITpTestcaseDao;
import com.ai.dev.mapper.interfaces.TpTestcaseMapper;
import com.ai.dev.mapper.vo.TpTestcase;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午6:04
 * @description:
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TpTestcaseDaoImpl implements ITpTestcaseDao {

    @Autowired
    TpTestcaseMapper mapper;

    @Override
    public int insert(TpTestcase testcase) {
        return mapper.insert(testcase);
    }

    @Override
    public int update(TpTestcase testcase) {
        return mapper.updateByPrimaryKeySelective(testcase);
    }
}
