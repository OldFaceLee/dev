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
public enum TestcaseEnum {

    VALID(1,"有效case"),
    INVALID(0,"无效case");

    int value;
    String desc;

}
