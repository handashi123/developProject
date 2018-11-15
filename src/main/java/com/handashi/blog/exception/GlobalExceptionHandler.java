package com.handashi.blog.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
public class GlobalExceptionHandler {
	/**
	 * Exception을 ResponseEntity에 담아 반환
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<?> handleGlobalException(HttpServletRequest request, Exception e){
		
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);				
		
	}
	/**
	 * Exception 별로 처리 
	 */
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(value = BaseException.class)
//	public String handleBaseException(BaseException be) {
//		return be.getMessage();
//	}
//	@ExceptionHandler(value = Exception.class)
//	public String handleException(Exception e) {
//		return e.getMessage();
//	}
	
}
