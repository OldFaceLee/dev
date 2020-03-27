package com.ai.dev.service;

import com.ai.dev.mapper.vo.TpTestcase;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午6:13
 * @description:
 */
public interface ITestcaseSv {

    boolean addTestcase(TpTestcase testcase);

    boolean updateTestcase(TpTestcase testcase);


}
