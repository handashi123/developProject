package com.handashi.common.util;

import java.util.ArrayList;

public class StringSplitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value = "";
//		String nullVal = null;
		
		String[] valueArr = value.split(",");
//		String[] nullValArr = nullVal.split(",");
		
		System.out.println("length : " + valueArr.length);
		
		for(String temp:valueArr) {
			System.out.println("temp : " + temp);
		}
		
		ArrayList arrayList = new ArrayList<>();
		
		System.out.println("list size : " + arrayList.size());
		
	}

}
