package com.handashi.common.util;

import com.handashi.common.util.vo.EnumCodeMapVo;

public class EnumCodeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int code = 1;
		
		EnumCodeMapVo vo = EnumCodeMapVo.getEnumByCode(code);
				
		System.out.println("=== " + vo.getCode());
		System.out.println("=== " + vo.getName());
		System.out.println("=== " + vo.getPrice());
	}

}
