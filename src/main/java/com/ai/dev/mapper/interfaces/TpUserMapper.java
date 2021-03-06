package com.ai.dev.mapper.interfaces;

import com.ai.dev.mapper.vo.TpUser;
import com.ai.dev.mapper.vo.TpUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    long countByExample(TpUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    int deleteByExample(TpUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    int insert(TpUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    int insertSelective(TpUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    List<TpUser> selectByExample(TpUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    TpUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TpUser record, @Param("example") TpUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TpUser record, @Param("example") TpUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TpUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TpUser record);
}