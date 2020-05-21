package com.ai.dev.em;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/8 下午9:49
 * @description:
 */
@Getter
@AllArgsConstructor
public enum UserEnum {

    USER_IS_VALID(1,"有效"),
    USER_IS_INVALID(0,"有效");

    Integer value;
    String desc;
}
