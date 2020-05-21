package com.ai.dev.common.testcase;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/1 下午10:22
 * @description:
 */
@Component
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonCase {

    /**
     * 主键
     */
    Integer id;

    /**
     * 创建人
     */
    String createrName;

    /**
     * 创建时间
     */
    Date createDate;

    /**
     * 更新人
     */
    String updateName;

    /**
     * 更新时间
     */
    Date updateDate;

    /**
     * 所属系统名称
     */
    String systemName;

    /**
     * 组ID
     */
    String groupId;

    /**
     * 用例id
     */
    String caseId;

    /**
     * 接口描述
     */
    String apiDesc;

    /**
     * 接口地址
     */
    String apiURi;

    /**
     * 端口号
     */
    String apiPort;

    /**
     * get还是post请求
     */
    String requestType;

    /**
     * 备注
     */
    String description;

    /**
     * headers
     */
    String headerValue;

    /**
     * 请求体类型
     */
    String reuestBodyType;

    /**
     * 请求体json参数
     */
    String jsonParam;

    /**
     * 响应结果
     */
    String responseResult;

}
