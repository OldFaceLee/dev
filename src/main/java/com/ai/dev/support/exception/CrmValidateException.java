package com.ai.dev.support.exception;

import com.ai.dev.support.context.ValidateResult;
import lombok.Getter;

/**
 * 业务校验异常
 *
 * @author zhangchao
 * @date 2019/3/6
 */
@Getter
public class CrmValidateException extends RuntimeException {

    /**
     * 携带的用户信息
     */
    private ValidateResult validateResult;

    /**
     * 构造函数
     *
     * @param result
     */
    public CrmValidateException(ValidateResult result) {
        super("校验失败");
        this.validateResult = result;
    }
}
