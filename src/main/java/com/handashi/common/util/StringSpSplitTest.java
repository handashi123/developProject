package com.handashi.common.util;

public class StringSpSplitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stVal = "사과^오렌지^복숭아";
		
		stVal = stVal.replaceAll("\\^", ",");
		
		System.out.println(stVal);
	}

}
