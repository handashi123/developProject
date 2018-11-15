package com.handashi.blog.exception;

public class CustomException1 extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomException1(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomException1(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomException1(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		System.out.println("CustomException1");
	}

	public CustomException1(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
