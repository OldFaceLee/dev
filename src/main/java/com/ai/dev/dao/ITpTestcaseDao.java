package com.ai.dev.dao;

import com.ai.dev.mapper.vo.TpTestcase;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午6:02
 * @description:
 */
public interface ITpTestcaseDao {

    int insert(TpTestcase testcase);

    int update(TpTestcase testcase);


}
