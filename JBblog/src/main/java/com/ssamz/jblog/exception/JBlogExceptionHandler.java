package com.ssamz.jblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.ssamz.jblog.dto.ResponseDTO;

@ControllerAdvice
@RestController
public class JBlogExceptionHandler {
// JSON 방식으로 에러 메세지 나타내기
	@ExceptionHandler(value = Exception.class)
	public ResponseDTO<String> globalExceptionHandler(Exception e){
		return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
//	public String globalExceptionHandler(Exception e) {
//		return "<h1>" + e.getMessage() + "</h1>";
//	}
}
