package com.ai.dev.service;

import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.mapper.customized.TpTestcaseRequest;
import com.ai.dev.mapper.vo.TpHttpCase;
import com.ai.dev.mapper.vo.TpTestcase;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午6:13
 * @description:
 */
public interface ITestcaseSv {

    boolean addTestcase(TpTestcase testcase);

    TpHttpCase addTestCase(TpHttpCase tpHttpCase);

    void runTestNGCase(TpHttpCase tpHttpCase);

    boolean updateTestcase(TpTestcase testcase);

    PageInfo<TpTestcase> queryTestcase(TpTestcaseRequest testcase);

    TpTestcase customizedQueryCaseId(String caseId);



}
