package com.ai.dev.common.exception.base;


import com.ai.dev.common.exception.em.ResultCode;

/**
 * 基础系统异常
 */
public class BaseSystemException extends BaseAbstractException {
    private static final long serialVersionUID = 8510738985062314322L;

    public BaseSystemException() {
    }

    public BaseSystemException(String resultMessage) {
        super(ResultCode.INTERNAL_SERVER_ERROR.getValue(), resultMessage);
    }

    public BaseSystemException(String resultMessage, String detail) {
        super(ResultCode.INTERNAL_SERVER_ERROR.getValue(), resultMessage, detail);
    }
}