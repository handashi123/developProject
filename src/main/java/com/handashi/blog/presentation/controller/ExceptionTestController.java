package com.handashi.blog.presentation.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handashi.blog.exception.BaseException;
import com.handashi.blog.exception.CustomException1;
import com.handashi.blog.exception.CustomException2;

@RestController
@RequestMapping("/test")
public class ExceptionTestController {
	
	@RequestMapping("/ex1")
	public String ex1() throws BaseException {
		throw new BaseException("base exception");
	}
	@RequestMapping("/ex2")
	public String ex2() throws CustomException1 {
		throw new CustomException1("this is custom exception 1");
	}
	
	@RequestMapping("/ex3")
	public String ex3() throws CustomException2 {
		throw new CustomException2("this is custom exception 2");
	} 
	
	@RequestMapping("/ex4")
	public String ex4() throws NullPointerException{
		throw new NullPointerException("null pointer exception");
	}
	
	@RequestMapping("/ex5")
	public String ex5() throws NumberFormatException{
		throw new NumberFormatException("number format exception");
	}
	@ExceptionHandler(value = NumberFormatException.class)
	public String nfeHandler(NumberFormatException nfe) {
		return nfe.getMessage();
	}
}
