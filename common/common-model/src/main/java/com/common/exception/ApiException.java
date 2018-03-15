package com.common.exception;

import com.common.web.HttpResponseDto;
import lombok.Data;
import org.springframework.http.ResponseEntity;

/**
 * @author chris.zhai
 * @create 2018/02/01
 **/
@Data
public class ApiException extends RuntimeException {

	private ResponseEntity result;

	public ApiException(int code, String message) {
		this.result = new ResponseEntity(code, message);
	}
}
