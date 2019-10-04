package com.zjhs.hstx.base;

import java.io.Serializable;

/**
 * 请求处理完成后的json结果集
 *
 * @param <T>
 */
public class Result<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码
     * ('00'成功，其他失败)
     */
    private String code;

    /**
     * 成功的消息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private T data;

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
        super();
        this.code = CommonConstants.RETURN_RESULT.RESULT_SUCCESS;
        this.msg = "success";
    }

    public Result(T data) {
        this();
        this.data = data;
    }

    /**
     * 成功返回
     *
     * @param msg  成功信息
     * @param body 返回数据
     * @return Result
     */
    public static <T> Result<T> success(String msg, T body) {
        return new Result<>(CommonConstants.RETURN_RESULT.RESULT_SUCCESS, msg, body);
    }

    /**
     * 成功返回
     *
     * @param body 返回数据
     * @return Result
     */
    public static <T> Result<T> success(T body) {
        return success("success", body);
    }

    /**
     * 成功返回
     *
     * @return Result
     */
    public static <T> Result<T> success() {
        return success(null);
    }

    /**
     * 失败返回
     *
     * @param code 错误编码
     * @param msg  错误信息
     * @return Result
     */
    public static <T> Result<T> fail(String code, String msg) {
        return new Result<>(code, msg, null);
    }

    /**
     * 普通失败返回
     *
     * @param msg 错误信息
     * @return Result
     */
    public static <T> Result<T> fail(String msg) {
        return fail(CommonConstants.RETURN_RESULT.RESULT_OPERATION_FAILED, msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }


}