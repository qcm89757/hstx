package com.zjhs.hstx.exception;

/**
 * 业务操作失败统一抛出的异常
 */
public class OperationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OperationFailedException() {
	}

	public OperationFailedException(String message) {
		super(message);
	}

	public OperationFailedException(Throwable cause) {
		super(cause);
	}

	public OperationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
