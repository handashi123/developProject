package com.handashi.common.aspact;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CtrlAspact {
	
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	private void ctrlPointCut() {
		
	}
	@Around("ctrlPointCut()")
	public Object ctrlAop(ProceedingJoinPoint jointPoint) throws Throwable{
		
		Object[] args = jointPoint.getArgs();
		System.out.println("aspect args : " + args.toString());
		
		
		// get method name
		String signatureStr = jointPoint.getSignature().toString();
		
		System.out.println("method name : " + signatureStr);
		
				
		Object retObj = jointPoint.proceed();
		
		return retObj;
	}
	@Before("execution(* com.handashi..*(..))")
	public void beforeMethod() {
		System.out.println("--- before aop");
	}
	@After("execution(* com.handashi..*(..))")
	public void afterMethod() {
		System.out.println("--- after aop");
	}
	
	
}
