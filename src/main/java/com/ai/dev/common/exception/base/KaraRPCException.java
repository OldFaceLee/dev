package com.ai.dev.common.exception.base;

public class KaraRPCException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String resultCode;
    private String resultMessage;

    public KaraRPCException(String resultCode, String resultMessage) {
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
