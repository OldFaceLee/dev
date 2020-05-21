package com.ai.dev.em;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/27 上午9:46
 * @description:
 */
@Getter
@AllArgsConstructor
public enum RestFulCaseEnum {

    REQUEST_TYPE_GET("get","get请求"),
    REQUEST_TYPE_POST("post","post请求"),
    REQUEST_BODY_JSON_PARAM("json","jsonBody请求体"),
    REQUEST_HTTP_TYPE("http","http类型"),
    REQUEST_HTTPS_TYPE("https","https类型");




    String value;
    String desc;

}
