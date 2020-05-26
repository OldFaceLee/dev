package com.ai.dev.mapper.interfaces;

import com.ai.dev.mapper.vo.THttpcase;
import com.ai.dev.mapper.vo.THttpcaseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THttpcaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    long countByExample(THttpcaseCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    int deleteByExample(THttpcaseCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    int insert(THttpcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    int insertSelective(THttpcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    List<THttpcase> selectByExample(THttpcaseCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    THttpcase selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") THttpcase record, @Param("example") THttpcaseCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") THttpcase record, @Param("example") THttpcaseCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(THttpcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_httpCase
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(THttpcase record);
}