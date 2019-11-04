package com.handashi.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareListMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("no", 1);
		map.put("name", "홍길동");	
		
		Map<String, Object> map2 = new HashMap<String, Object>();		
		map2.put("no", 2);
		map2.put("name", "둘리");		
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("no", 2);
		map3.put("name", "도우너");
		
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("no", 2);
		map4.put("name", "고길동");
		
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("no", 3);
		map5.put("name", "또치");
		
		list.add(map);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		
		String tempName = "";
		
		for(int i = 0; i < list.size(); i++) {
			int afterNo = 0;
			String afterName = "";
			    	
			Map<String, Object>tempMap = list.get(i);
			
			int currentNo = (int) tempMap.get("no");
			String currentName = (String) tempMap.get("name");
			
			// 첫행이 아닐때 전행을 저장
			if(i + 1 < list.size()) {
				afterNo = (int) list.get(i+1).get("no");
				afterName = (String) list.get(i+1).get("name");
			}
			
			if(currentNo == afterNo) {
				if("".equals(tempName)) {
					tempName = currentName;
				}else {
					tempName = tempName + "|" + currentName;
				}
				
			}else {
				if("".equals(tempName)) {
					tempName = currentName;
				}else {
					tempName = tempName + "|" + currentName;
				}
				System.out.println("no : " + currentNo + " name : " + tempName);
				tempName = "";
			}
			
		}
		
	}

}
