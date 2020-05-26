package com.ai.dev.common.exception.base;

/**
 * 基础业务异常
 */
public class BaseBusinessException extends BaseAbstractException {
    private static final long serialVersionUID = 1L;

    public BaseBusinessException() {
    }

    public BaseBusinessException(String resultCode, String resultMessage) {
        super(resultCode, resultMessage);
    }
}