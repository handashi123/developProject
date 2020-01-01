package com.handashi.common.util;

import com.handashi.common.util.vo.EnumVo;
import com.handashi.common.util.vo.EnumVo2;
import com.handashi.common.util.vo.EnumVo3;
import com.handashi.common.util.vo.TestEnumVo;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumVo enumVo = EnumVo.NUMBER;
		
		if(EnumVo.NUMBER.equals(enumVo)) {
			System.out.println("value true: " + EnumVo.NUMBER + "파라미터 : " + EnumVo.NAME.getParam());
		}else {
			System.out.println("value false: " + EnumVo.NUMBER);
		}
		
		/**
		 * ENUM 을 상수 호출에 사용해도 되고, 상수를 계산하는 식으로 사용해도 된다.
		 * 기존 private static final 상수를 사용하면 실질적으로 기본 상수를 세트로 가지고 다니는 것들을
		 * 게산해야 하지만 enum 클래스 사용으로 한묶을처럼 사용해도 된다.
		 * ex) 상품금액 : 부가세, 원가, 판매가, 할인가 등등 연관된것들을 한번에 가져올수 있다.
		 */
		
		
		// 계산 enum 테스트
		EnumVo2 enumVo2 = EnumVo2.DOUBLE;
		System.out.println(enumVo2.getRetVal(3));
		
		System.out.println(EnumVo2.DOUBLE.getRetVal(5));
		
		System.out.println(EnumVo2.TRIPPLE.getRetVal(5));
		
		TestEnumVo testEnumVo = new TestEnumVo("상품명", 100, EnumVo2.DOUBLE);
		
		System.out.println(testEnumVo.getEnumVo2().getRetVal(100)); 
		/**
		 * VO에 enum 클래스 사용할때의 장점
		 * 데이터에서 상품코드와 판매가만 가져온다고 할경우
		 * 계산식이 일정하게 정의되어있을경우 ENUM 클래스에 정의해두면 상품명, 원가, 세금등을 
		 * 한번에 가져올수 있다.
		 */
		
		TestEnumVo testVo = new TestEnumVo();
		testVo.setProductName("상품1");
		testVo.setPrice(250);
		
		System.out.println("getDoubleRetVal : " + testVo.getDoubleRetVal());
		System.out.println("getTrippleRetVal : " + testVo.getTrippleRetVal());
		
		
		// vo3 테스트
		/**
		 * java 8 일경우 function 에 람다식 사용하면 되지만 7이하일경우 추상클래스를 사용해야한다.
		 * 1. 추상클래스 선언
		 * 2. 상수에 추상클래스 구현
		 * 3. 추상클래스 호출하고 가져오는 메소드 생성
		 * 
		 * 장점 enum 클래스 바로 호출해서 상수에 해당하는 값들을 바로 계산해서 가져올수 있다.
		 * 명시적으로 선언되므로 알아보기 쉽다.
		 * 
		 *  
		 */
		System.out.println(EnumVo3.TEX.getName());
		
		System.out.println(EnumVo3.TEX.getCalc(100));
		
	}

}
