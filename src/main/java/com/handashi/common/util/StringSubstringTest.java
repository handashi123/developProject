package com.handashi.common.util;

public class StringSubstringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date = "20191017";
		
		String temp = date.substring(0, 4) +"/"+ date.substring(4, 6) +"/"+ date.substring(6, 8);
		
		System.out.println(temp);
	}

}
