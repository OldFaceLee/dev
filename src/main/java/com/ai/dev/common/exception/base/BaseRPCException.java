package com.ai.dev.common.exception.base;

/**
 * 基础RPC异常
 */
public class BaseRPCException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String resultCode;
    private String resultMessage;

    public BaseRPCException(String resultCode, String resultMessage) {
        super(resultMessage);
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
