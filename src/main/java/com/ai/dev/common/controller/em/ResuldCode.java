package com.ai.dev.common.controller.em;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/12 下午6:04
 * @description:
 */

@Getter
@AllArgsConstructor
public enum ResuldCode {
    OK("000000", "OK");

    String value;
    String desc;

}
