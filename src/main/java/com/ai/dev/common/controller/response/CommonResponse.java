package com.ai.dev.common.controller.response;

import java.io.Serializable;

/**
 * 公共响应
 * @author: lixuejun
 * @date: Create in 2020/3/12 下午5:25
 * @description:
 */

public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resultCode;
    private String resultMessage;

    public CommonResponse(){}

    public CommonResponse(String resultCode,String resultMessage){
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;

    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
