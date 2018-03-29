package com.domain.common.exception;

import com.domain.common.web.HttpResponseDto;
import org.springframework.http.HttpStatus;
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
		HttpResponseDto result = new HttpResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name());
		result.setData(exception.getMessage());
		return result;
	}
}
