package com.ai.dev.mapper.vo;

import java.io.Serializable;
import java.util.Date;

public class TpTestcase implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.case_id
     *
     * @mbg.generated
     */
    private String caseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.request_type
     *
     * @mbg.generated
     */
    private String requestType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.case_name
     *
     * @mbg.generated
     */
    private String caseName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.case_desc
     *
     * @mbg.generated
     */
    private String caseDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.case_groups
     *
     * @mbg.generated
     */
    private String caseGroups;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.uri
     *
     * @mbg.generated
     */
    private String uri;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.header
     *
     * @mbg.generated
     */
    private String header;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.param
     *
     * @mbg.generated
     */
    private String param;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.update_date
     *
     * @mbg.generated
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.create_owner
     *
     * @mbg.generated
     */
    private String createOwner;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_testcase.is_valid
     *
     * @mbg.generated
     */
    private Integer isValid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tp_testcase
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.id
     *
     * @return the value of tp_testcase.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.id
     *
     * @param id the value for tp_testcase.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.case_id
     *
     * @return the value of tp_testcase.case_id
     *
     * @mbg.generated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.case_id
     *
     * @param caseId the value for tp_testcase.case_id
     *
     * @mbg.generated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.request_type
     *
     * @return the value of tp_testcase.request_type
     *
     * @mbg.generated
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.request_type
     *
     * @param requestType the value for tp_testcase.request_type
     *
     * @mbg.generated
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.case_name
     *
     * @return the value of tp_testcase.case_name
     *
     * @mbg.generated
     */
    public String getCaseName() {
        return caseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.case_name
     *
     * @param caseName the value for tp_testcase.case_name
     *
     * @mbg.generated
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName == null ? null : caseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.case_desc
     *
     * @return the value of tp_testcase.case_desc
     *
     * @mbg.generated
     */
    public String getCaseDesc() {
        return caseDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.case_desc
     *
     * @param caseDesc the value for tp_testcase.case_desc
     *
     * @mbg.generated
     */
    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc == null ? null : caseDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.case_groups
     *
     * @return the value of tp_testcase.case_groups
     *
     * @mbg.generated
     */
    public String getCaseGroups() {
        return caseGroups;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.case_groups
     *
     * @param caseGroups the value for tp_testcase.case_groups
     *
     * @mbg.generated
     */
    public void setCaseGroups(String caseGroups) {
        this.caseGroups = caseGroups == null ? null : caseGroups.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.uri
     *
     * @return the value of tp_testcase.uri
     *
     * @mbg.generated
     */
    public String getUri() {
        return uri;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.uri
     *
     * @param uri the value for tp_testcase.uri
     *
     * @mbg.generated
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.header
     *
     * @return the value of tp_testcase.header
     *
     * @mbg.generated
     */
    public String getHeader() {
        return header;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.header
     *
     * @param header the value for tp_testcase.header
     *
     * @mbg.generated
     */
    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.param
     *
     * @return the value of tp_testcase.param
     *
     * @mbg.generated
     */
    public String getParam() {
        return param;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.param
     *
     * @param param the value for tp_testcase.param
     *
     * @mbg.generated
     */
    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.update_date
     *
     * @return the value of tp_testcase.update_date
     *
     * @mbg.generated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.update_date
     *
     * @param updateDate the value for tp_testcase.update_date
     *
     * @mbg.generated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.create_date
     *
     * @return the value of tp_testcase.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.create_date
     *
     * @param createDate the value for tp_testcase.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.create_owner
     *
     * @return the value of tp_testcase.create_owner
     *
     * @mbg.generated
     */
    public String getCreateOwner() {
        return createOwner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.create_owner
     *
     * @param createOwner the value for tp_testcase.create_owner
     *
     * @mbg.generated
     */
    public void setCreateOwner(String createOwner) {
        this.createOwner = createOwner == null ? null : createOwner.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_testcase.is_valid
     *
     * @return the value of tp_testcase.is_valid
     *
     * @mbg.generated
     */
    public Integer getIsValid() {
        return isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_testcase.is_valid
     *
     * @param isValid the value for tp_testcase.is_valid
     *
     * @mbg.generated
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}