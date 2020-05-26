package com.ai.dev.common.controller.response;

import com.ai.dev.common.exception.handler.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * 错误的响应
 */
public class ErrorResponse {
    private String resultCode;
    private String resultMessage;
    private List<ValidationError> validationErrors = new ArrayList();

    public ErrorResponse() {
    }

    public ErrorResponse(String errorCode, String resultMessage) {
        this.resultCode = errorCode;
        this.resultMessage = resultMessage;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String errorCode) {
        this.resultCode = errorCode;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public List<ValidationError> getValidationErrors() {
        return this.validationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
