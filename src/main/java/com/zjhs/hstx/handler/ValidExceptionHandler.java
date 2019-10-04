package com.zjhs.hstx.handler;
import com.zjhs.hstx.base.Result;
import com.zjhs.hstx.exception.CheckException;
import com.zjhs.hstx.exception.OperationFailedException;
import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.FileUploadBase.SizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * 处理controller层异常
 */
@ControllerAdvice
@Component
public class ValidExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ValidExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handle(MethodArgumentNotValidException e) {
        String error = e.getBindingResult().getFieldError().getDefaultMessage();
        log.info("方法参数校验异常:{}", error);
        return Result.fail(error);
    }

    @ExceptionHandler(OperationFailedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handler(OperationFailedException e) {
        String error = e.getLocalizedMessage();
        log.info("自定义错误信息:{}", error);
        return Result.fail(error);
    }

    @ExceptionHandler(CheckException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handler(CheckException e) {
        String error = e.getLocalizedMessage();
        log.info("自定义校验错误:{}", error);
        return Result.fail(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handlerHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String error = e.getLocalizedMessage();
        log.error("无可读取的参数体:{}", error);
        return Result.fail("无可读取的参数体");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handlerMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        String error = e.getLocalizedMessage();
        log.error("参数不能为空:{}", error);
        return Result.fail("参数不能为空");
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handlerBindException(BindException e) {
        String error = e.getLocalizedMessage();
        log.error("参数绑定失败:{}", error);
        return Result.fail("参数绑定失败");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handlerConstraintViolationException(ConstraintViolationException e) {
        String error = e.getLocalizedMessage();
        log.error("约束冲突异常:{}", error);
        return Result.fail("约束冲突异常");
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handlerValidationException(ValidationException e) {
        String error = e.getLocalizedMessage();
        log.error("参数验证失败:{}", error);
        return Result.fail("参数验证失败");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String error = e.getLocalizedMessage();
        log.error("不支持当前请求方法:{}", error);
        return Result.fail("不支持当前请求方法");
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handlerHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        String error = e.getLocalizedMessage();
        log.error("不支持当前媒体类型:{}", error);
        return Result.fail("不支持当前媒体类型");
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handlerInvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e) {
        String error = e.getLocalizedMessage();
        log.error("数据库操作失败:{}", error);
        return Result.fail("数据库操作失败");
    }

    /**
     * 参数类型不匹配
     *
     * @param ex 异常
     * @return Result.fail
     */
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    public Result requestTypeMismatch(TypeMismatchException ex) {
        String error = String.format("参数类型不匹配,参数 %s 类型应该为 %s，实际传入参数：%s", ex.getPropertyName(), ex.getRequiredType(), ex.getValue());
        log.error("参数类型不匹配:{}", error);
        return Result.fail(error);
    }

    /**
     * 参数验证异常
     *
     * @param ex 参数不合法异常
     * @return Result.fail
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Result illegalArgumentExceptionHandler(IllegalArgumentException ex) {
        log.error("参数验证异常:{}", ex.getLocalizedMessage());
        return Result.fail("参数验证异常:" + ex.getLocalizedMessage());
    }

    /**
     * 请求参数过大或者文件大小过大
     */
    @SuppressWarnings("Duplicates")
    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    public Result MultipartExceptionHandler(MultipartException ex) {
        Throwable cause = ex.getCause().getCause();
        String message;
        if (cause instanceof SizeLimitExceededException) {
            SizeLimitExceededException flEx = (SizeLimitExceededException) cause;
            long permittedSize = flEx.getPermittedSize() / 1024 / 1024;
            message = String.format("操作失败：单个请求超过[%d]MB", permittedSize);
        } else if (cause instanceof FileSizeLimitExceededException) {
            FileSizeLimitExceededException flEx = (FileSizeLimitExceededException) cause;
            long permittedSize = flEx.getPermittedSize() / 1024 / 1024;
            message = String.format("操作失败：单个文件超过[%d]MB", permittedSize);
        } else {
            message = String.format("操作失败：%s", ex.getMessage());
        }
        log.error("上传文件失败：{}", message);
        return Result.fail(message);
    }

    /**
     * 处理其他所有异常
     *
     * @param ex 所有异常
     * @return Result.fail
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception ex) {
        log.error("其他异常", ex);
        return Result.fail(String.format("操作失败：%s", ex.getMessage()));
    }
}
