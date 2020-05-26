package com.ai.dev.dao;

import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.mapper.customized.TpTestcaseRequest;
import com.ai.dev.mapper.vo.TpHttpCase;
import com.ai.dev.mapper.vo.TpTestcase;

import java.util.List;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午6:02
 * @description:
 */
public interface ITpTestcaseDao {

    int insert(TpTestcase testcase);

    /**
     * 添加http类型的用例，返回更新count
     * @param tpHttpCase
     * @return
     */
    int insert(TpHttpCase tpHttpCase);

    int update(TpTestcase testcase);

    List<TpTestcase> select(String caseId);

    /**
     *  @NotNull(message = "每页查询记录数不能为空")
     *     @Min(value = 1, message = "每页查询数据至少为1")
     *     Integer pageSize;
     *
     *     @NotNull(message = "当前页码不能为空")
     *     @Min(value = 1, message = "当前页码至少为1")
     *     Integer pageNo;
     * @return
     */
    PageInfo<TpTestcase> queryForPageInfo(TpTestcaseRequest tpTestcaseRequest);





}
