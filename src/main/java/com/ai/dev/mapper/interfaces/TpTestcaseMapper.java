package com.ai.dev.mapper.interfaces;

import com.ai.dev.mapper.vo.TpTestcase;
import com.ai.dev.mapper.vo.TpTestcaseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpTestcaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    long countByExample(TpTestcaseCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    int deleteByExample(TpTestcaseCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    int insert(TpTestcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    int insertSelective(TpTestcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    List<TpTestcase> selectByExample(TpTestcaseCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    TpTestcase selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TpTestcase record, @Param("example") TpTestcaseCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TpTestcase record, @Param("example") TpTestcaseCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TpTestcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TpTestcase record);
}