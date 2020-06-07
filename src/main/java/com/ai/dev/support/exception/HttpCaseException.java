package com.ai.dev.support.exception;

import com.ai.dev.common.exception.handler.ValidateResult;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/27
 * @description:
 */
@Getter
public class HttpCaseException extends RuntimeException implements Serializable {

        /**
         * 携带的用户信息
         */
        private ValidateResult validateResult;

        /**
         * 构造函数
         *
         * @param result
         */
        public HttpCaseException(ValidateResult result) {
            super("校验失败");
            this.validateResult = result;
        }

}
