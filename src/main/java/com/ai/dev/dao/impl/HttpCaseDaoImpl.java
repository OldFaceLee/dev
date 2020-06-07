package com.ai.dev.dao.impl;

import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.dao.IHttpCaseDao;
import com.ai.dev.mapper.interfaces.TpHttpCaseMapper;
import com.ai.dev.mapper.vo.TpHttpCase;
import com.ai.dev.mapper.vo.TpHttpCaseCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/27
 * @description:
 */
@Service
@Slf4j
public class HttpCaseDaoImpl implements IHttpCaseDao {

    @Autowired
    TpHttpCaseMapper tpHttpCaseMapper;

    @Override
    public int insert(TpHttpCase tpHttpCase) {
        return tpHttpCaseMapper.insert(tpHttpCase);
    }

    @Override
    public int update(TpHttpCase tpHttpCase) {
        return tpHttpCaseMapper.updateByPrimaryKeySelective(tpHttpCase);
    }

    @Override
    public List<TpHttpCase> obtainHttpCase(TpHttpCase tpHttpCase) {
        TpHttpCaseCriteria sql = new TpHttpCaseCriteria();
        sql.or().andCaseIdEqualTo(tpHttpCase.getCaseId());
        List<TpHttpCase> cases = tpHttpCaseMapper.selectByExample(sql);
        return Optional.ofNullable(cases).orElse(Collections.emptyList());
    }

    @Override
    public PageInfo<TpHttpCase> query() {
        return null;
    }
}
