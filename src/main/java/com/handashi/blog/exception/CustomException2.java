package com.handashi.blog.exception;

public class CustomException2 extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomException2(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomException2(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomException2(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		System.out.println("CustomException2");
	}

	public CustomException2(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
