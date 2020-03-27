package com.ai.dev.dao;

import com.ai.dev.mapper.vo.TpTestsuite;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午8:21
 * @description:
 */
public interface ITpTestsuiteDao {

    boolean insert(TpTestsuite tpTestsuite);

    boolean update(TpTestsuite tpTestsuite);
}
