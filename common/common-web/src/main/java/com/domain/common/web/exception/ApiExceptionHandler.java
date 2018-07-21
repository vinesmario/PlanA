package com.domain.common.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This's a configuration for Gobal Exception.
 *
 * @create 2018/01/29
 **/
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = ApiException.class)
	public Object ExceptionHandler(ApiException exception) {
		return exception.getResult();
	}

	/**
	 * 全局异常处理
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public Object ExceptionHandler(Exception exception) {
		ResponseEntity result = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return result;
	}
}
