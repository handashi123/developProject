package com.handashi.common.util;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		HashMap<String, String> map3 = new HashMap<String, String>();
		HashMap<String, String> map4 = new HashMap<String, String>();
		HashMap<String, String> map5 = new HashMap<String, String>();
		
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>(); 
		
		map1.put("no", "1"); map1.put("name", "aaa"); map1.put("group", "A1"); list.add(map1);
		map2.put("no", "2"); map2.put("name", "bbb"); map2.put("group", "A1"); list.add(map2);
		map3.put("no", "3"); map3.put("name", "ccc"); map3.put("group", "A2"); list.add(map3);
		map4.put("no", "4"); map4.put("name", "ddd"); map4.put("group", "A2"); list.add(map4);
		map4.put("no", "5"); map5.put("name", "eee"); map5.put("group", "B1"); list.add(map5);
		
		for(int i = 0; i < list.size(); i++) {
			
			HashMap<String, String> temp = list.get(i);
			String beforeGrp = "";
			String afterGrp = "";
			
			beforeGrp = temp.get("group");
			
			if(list.size() > i + 1) {
				HashMap<String, String> cTemp = list.get(i+1);
				afterGrp = cTemp.get("group");
			}
			
			if(!beforeGrp.equals(afterGrp) && !"".equals(afterGrp)) {
				System.out.println();
			}
			
			
		}
		
	}

}
