package com.handashi.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class StringDivTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문자열 중복 제거 테스트 - set은 자동 중복 제거됨
		
		
		String val1 = "블랙,90,null,null";
		String val2 = "블랙,95,null,null";
		String val3 = "블랙,100,null,null";
		String val4 = "네이비,90,null,null";
		String val5 = "네이비,95,null,null";
		String val6 = "네이비,100,null,null";
		
		ArrayList list = new ArrayList<String>();
		list.add(val1);
		list.add(val2);
		list.add(val3);
		list.add(val4);
		list.add(val5);
		list.add(val6);
		
//		ArrayList opt1 = new ArrayList<String>();
//		ArrayList opt2 = new ArrayList<String>();
//		ArrayList opt3 = new ArrayList<String>();
//		ArrayList opt4 = new ArrayList<String>();
		
		HashSet<String> opt1 = new HashSet<String>();
		HashSet<String> opt2 = new HashSet<String>();
		HashSet<String> opt3 = new HashSet<String>();
		HashSet<String> opt4 = new HashSet<String>();
		
//		TreeSet<String> opt1 = new TreeSet<String>();
//		TreeSet<String> opt2 = new TreeSet<String>();
//		TreeSet<String> opt3 = new TreeSet<String>();
//		TreeSet<String> opt4 = new TreeSet<String>();
		
		for(int i = 0; i < list.size(); i++) {
			String temp = (String) list.get(i);
			String tempArray[] = temp.split(",");
					
			opt1.add(tempArray[0]);
			opt2.add(tempArray[1]);
			opt3.add(tempArray[2]);
			opt4.add(tempArray[3]);
			
		}
		
		ArrayList opt2List = new ArrayList<String>(opt2);
		// 자동 정렬 예시 - set -> list -> Collections.sort 를 하면 자동정렬
		// 문자열의 숫자 체크하기 위해선 체크메소드가 필요.
		Collections.sort(opt2List);
		
		System.out.println(opt2List.toString());
		
		System.out.println(opt1.toString());
		System.out.println(opt2.toString());
		System.out.println(opt3.toString());
		System.out.println(opt4.toString());
		
	}

}
