package com.ai.dev.em;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/1 下午10:35
 * @description:
 */
@Getter
@AllArgsConstructor
public enum CommonCaseEnum {

    REQUEST_TYPE_GET("get","get请求"),
    REQUEST_TYPE_POST("post","post请求"),

    REQUEST_BODY_TYPE("json","jsonBody请求体");



    String value;
    String desc;
}
