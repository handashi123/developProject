package com.handashi.common.util;

import com.handashi.common.util.vo.EnumCode;

public class EnumTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 코드는 1, 2
		int foodCode = 2;
		
		if(EnumCode.HAMBURGER.getCode() == foodCode) {
			System.out.println("주문한 음식은 : " + EnumCode.HAMBURGER.getName());
		}
		
		for(EnumCode enumCode:EnumCode.values()) {
			System.out.println("code : " + enumCode.getCode());
			System.out.println("code : " + enumCode.getName());
		}
		
		System.out.println("주문 음식 : " + EnumCode.enumCodeByCode(foodCode).getName());;
	}
	
	static {
		System.out.println("처음");
	}

}
