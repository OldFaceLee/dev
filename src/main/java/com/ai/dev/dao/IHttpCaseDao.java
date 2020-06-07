package com.ai.dev.dao;

import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.mapper.vo.TpHttpCase;

import java.util.List;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/27
 * @description:
 */
public interface IHttpCaseDao {

    int insert(TpHttpCase tpHttpCase);

    int update(TpHttpCase tpHttpCase);

    List<TpHttpCase> obtainHttpCase(TpHttpCase tpHttpCase);

    PageInfo<TpHttpCase> query();
}
