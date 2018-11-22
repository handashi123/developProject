package com.handashi.common.spring.log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class CallLog {
	
	/**
	 * 기동시 시작
	 */
	@PostConstruct
	private void initConstruct() {
		System.out.println("CallLog 기동시 동작");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("CallLog 삭제전 동작");
	}
	
	
}
