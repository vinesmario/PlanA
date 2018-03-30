package com.domain.common.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author chris.zhai
 * @create 2018/02/01
 **/
@Data
public class ApiException extends RuntimeException {

	private ResponseEntity result;

	public ApiException(HttpStatus code, String message) {
		this.result = new ResponseEntity(message, code);
	}
}
