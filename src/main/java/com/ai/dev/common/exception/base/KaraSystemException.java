package com.ai.dev.common.exception.base;


import com.ai.dev.common.exception.em.ResultCode;

public class KaraSystemException extends KaraAbstractException {
    private static final long serialVersionUID = 8510738985062314322L;

    public KaraSystemException() {
    }

    public KaraSystemException(String resultMessage) {
        super(ResultCode.INTERNAL_SERVER_ERROR.getValue(), resultMessage);
    }

    public KaraSystemException(String resultMessage, String detail) {
        super(ResultCode.INTERNAL_SERVER_ERROR.getValue(), resultMessage, detail);
    }
}