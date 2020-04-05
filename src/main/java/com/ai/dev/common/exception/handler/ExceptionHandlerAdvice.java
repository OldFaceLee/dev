package com.ai.dev.common.exception.handler;

import com.ai.dev.common.controller.response.ErrorResponse;
import com.ai.dev.common.controller.response.Response;
import com.ai.dev.common.exception.base.KaraBusinessException;
import com.ai.dev.common.exception.base.KaraRPCException;
import com.ai.dev.common.exception.base.KaraSystemException;
import com.ai.dev.common.exception.em.ResultCode;
import com.ai.dev.common.exception.handler.ValidationError;
import com.ai.dev.support.exception.CrmValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/3 下午2:43
 * @description: 全局捕获异常处理
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {


    /**
     * 判断是否是AJAX过来的请求
     *
     * @param request
     * @return
     */
    private static boolean isAjax(HttpServletRequest request) {
        String xRequestWith = request.getHeader("X-Requested-With");
        boolean isAjax = false;
        if (StringUtils.hasText(xRequestWith)) {
            isAjax = "XMLHttpRequest".equals(xRequestWith);
        }
        return isAjax;
    }

    @ExceptionHandler({CrmValidateException.class})
    public ResponseEntity<Response> exception(CrmValidateException e) {
        Response resp = new Response(e.getValidateResult());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
    }

    @ExceptionHandler({KaraBusinessException.class})
    public ResponseEntity<ErrorResponse> exception(KaraBusinessException e) {
        ErrorResponse resp = new ErrorResponse(e.getResultCode(), e.getResultMessage());
        log.error(e.getResultMessage(), e);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
    }

    @ExceptionHandler({KaraRPCException.class})
    public ResponseEntity<ErrorResponse> exception(KaraRPCException e) {
        log.error(e.getResultMessage(), e);
        ErrorResponse resp = new ErrorResponse(e.getResultCode(), e.getResultMessage());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
    }

    @ExceptionHandler({UndeclaredThrowableException.class})
    public ResponseEntity<ErrorResponse> exception(UndeclaredThrowableException e) {
        Throwable cause = e.getCause();
        if (cause instanceof InvocationTargetException) {
            Throwable targetException = ((InvocationTargetException) cause).getTargetException();
            if (targetException instanceof KaraRPCException) {
                return exception((KaraRPCException) targetException);
            } else {
                return exception((Exception) targetException);
            }
        } else {
            return exception((Exception) e);
        }
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> exception(IllegalArgumentException e) {
        log.error(e.getMessage(), e);
        Throwable cause = e.getCause();
        if (cause instanceof InvocationTargetException) {
            Throwable targetException = ((InvocationTargetException) cause).getTargetException();
            ErrorResponse resp = new ErrorResponse("999001", targetException.getMessage());
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
        }
        ErrorResponse resp = new ErrorResponse("999001", e.getMessage());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ErrorResponse> exception(AccessDeniedException e, HttpServletRequest request) throws AccessDeniedException {
        if (isAjax(request)) {
            ErrorResponse resp = new ErrorResponse("999000", "对不起，您没有被授权访问本操作，请联系管理员分配权限");
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
        } else {
            throw e;
        }
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> exception(MethodArgumentNotValidException e) {
        List<ObjectError> objectErrors = e.getBindingResult().getAllErrors();
        List<ValidationError> errorList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (ObjectError objectError : objectErrors) {
            sb.append(objectError.getDefaultMessage());
            sb.append("&");
            ValidationError validationError = new ValidationError();
            validationError.setPropertyName(objectError.getObjectName());
            validationError.setMessage(objectError.getDefaultMessage());
            validationError.setPropertyValue(objectError.getCode());
            errorList.add(validationError);
        }
        String resultMessage = sb.toString().substring(0, sb.lastIndexOf("&"));
        ErrorResponse resp = new ErrorResponse("999000", resultMessage);
        resp.setValidationErrors(errorList);
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
    }

    @ExceptionHandler({IllegalStateException.class})
    public ResponseEntity<ErrorResponse> exception(IllegalStateException e) {
        Throwable cause = e.getCause();
        if (cause instanceof InvocationTargetException) {
            Throwable targetException = ((InvocationTargetException) cause).getTargetException();
            ErrorResponse resp = new ErrorResponse("999001", targetException.getMessage());
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
        }
        ErrorResponse resp = new ErrorResponse("999001", e.getMessage());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
    }

    @ExceptionHandler({KaraSystemException.class})
    public ResponseEntity<ErrorResponse> exception(KaraSystemException e) {
        log.error(e.getResultMessage(), e);
        ErrorResponse resp = new ErrorResponse(e.getResultCode(), e.getResultMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> exception(Exception e) {
        log.error(e.getMessage(), e);
        ErrorResponse resp = new ErrorResponse(ResultCode.INTERNAL_SERVER_ERROR.getValue(), "系统错误，请联系管理员");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ErrorResponse> httpRequestMethodNotSupportedException(Exception e) {
        log.error(e.getMessage());
        ErrorResponse resp = new ErrorResponse(ResultCode.METHOD_NOT_ALLOWED.getValue(), e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponse> httpMediaTypeNotSupportedException(Exception e) {
        log.error(e.getMessage());
        ErrorResponse resp = new ErrorResponse(ResultCode.UNSUPPORTED_MEDIA_TYPE.getValue(), e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).contentType(MediaType.APPLICATION_JSON_UTF8).body(resp);
    }

}
