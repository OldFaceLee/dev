package com.ai.dev.support.context;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangchao
 * @date 2018/12/16
 */
@Getter
@AllArgsConstructor
public enum ValidateLevel {

    /**
     * 提示信息
     */
    INFO(0),

    /**
     * 警告信息
     */
    ALERT(1),

    /**
     * 用户需要确认
     */
    CONFIRM(2);

    int level;
}
