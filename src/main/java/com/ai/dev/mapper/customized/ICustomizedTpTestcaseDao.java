package com.ai.dev.mapper.customized;

import com.ai.dev.mapper.vo.TpTestcase;
import org.apache.ibatis.annotations.*;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/6 下午1:24
 * @description:
 */
@Mapper
public interface ICustomizedTpTestcaseDao {



    @Select("select * from tp_testcase where case_id = #{caseId}")
    @Results({
            @Result(column = "case_id",property = "caseId")
    })
    TpTestcase select(@Param("caseId") String caseId);
}
