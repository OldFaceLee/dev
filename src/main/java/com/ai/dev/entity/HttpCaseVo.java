package com.ai.dev.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/8 下午8:18
 * @description:
 */
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class HttpCaseVo implements Serializable {
    private static final long serialVersionUID = -7514881628880563155L;

    /**主键**/
    Integer id;

    /**所属系统**/
    String systemName;

    /**用例名称**/
    String caseName;

    /**用例描述**/
    String caseDesc;

    /**请求的URL**/
    String uri;

    /**port**/
    String port;

    /**请求头，jsonStr模式**/
    String header;

    /**请求体，jsonStr模式**/
    String requestBody;

    /**检查sql语句**/
    String checkSql;

    /**期望结果**/
    String expectedResult;

    /**创建人**/
    String createUser;

    /**创建时间**/
    Date createDate;

    /**更新时间**/
    Date updateDate;





}
