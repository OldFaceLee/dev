package com.ai.dev.common.exception.base;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/3 下午2:50
 * @description:
 */
public abstract class KaraAbstractException extends RuntimeException {
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

    public KaraAbstractException() {
    }

    public KaraAbstractException(String resultCode) {
        this.resultCode = resultCode;
    }

    public KaraAbstractException(String resultCode, String resultMessage) {
        super(resultMessage);
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public KaraAbstractException(String resultCode, String resultMessage, String detail) {
        super(resultMessage);
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.detail = detail;
    }
}
