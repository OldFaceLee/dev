package com.ai.dev.common.exception.base;

public class KaraBusinessException extends KaraAbstractException {
    private static final long serialVersionUID = 1L;

    public KaraBusinessException() {
    }

    public KaraBusinessException(String resultCode, String resultMessage) {
        super(resultCode, resultMessage);
    }
}