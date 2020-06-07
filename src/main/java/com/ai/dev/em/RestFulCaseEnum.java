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

    REQUEST_TYPE_GET(0,"get请求"),
    REQUEST_TYPE_POST(1,"post请求");


    Integer value;
    String desc;


}
