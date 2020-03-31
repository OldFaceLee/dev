package com.ai.dev.service;

import com.ai.dev.mapper.customized.TpTestsuiteRequest;
import com.ai.dev.mapper.vo.TpTestsuite;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午8:27
 * @description:
 */
public interface ITestsuiteSv {

    boolean addCaseToSuite(TpTestsuite tpTestsuite);

    public String runSuite(TpTestsuiteRequest tpTestsuiteRequest);
}
