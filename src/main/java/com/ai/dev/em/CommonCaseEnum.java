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
    VALID(1,"有效case"),
    INVALID(0,"无效case");



    /**
     * 枚举值
     */
    int value;

    /**
     * 枚举描述
     */
    String desc;
}
