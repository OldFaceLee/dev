package com.ai.dev.common.exception.base;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/3 下午2:50
 * @description: 基础抽象异常
 */
public abstract class BaseAbstractException extends RuntimeException {
    private static final long serialVersionUID = -289364689303128644L;
    private String resultCode;
    private String resultMessage;
    private String detail;

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public String getDetail() {
        return this.detail;
    }

    public BaseAbstractException() {
    }

    public BaseAbstractException(String resultCode) {
        this.resultCode = resultCode;
    }

    public BaseAbstractException(String resultCode, String resultMessage) {
        super(resultMessage);
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public BaseAbstractException(String resultCode, String resultMessage, String detail) {
        super(resultMessage);
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.detail = detail;
    }
}
