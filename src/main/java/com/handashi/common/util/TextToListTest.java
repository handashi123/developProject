package com.handashi.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TextToListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			File file = new File("C:\\Test\\export.dsv");
			
			// 파일한번에 읽기
//			Path path = Paths.get("C:\\Test\\export.dsv");			
//			Charset cs = StandardCharsets.UTF_8;
			
			// 파일 한번에 읽기 스캐너
			Scanner scan = new Scanner(file);
			
			int idx = 0;
			
			String[] keyNames = null;
			
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			
			while(scan.hasNextLine()) {
				String delimTemp = scan.nextLine();
				
//				System.out.println(delimTemp);
				
				String[] delimArr = delimTemp.split("\\|");
				
//				System.out.println(delimArr.length);
				
				HashMap<String, String> map = new HashMap<String, String>();
				
				// 첫째줄이면 키 세팅
				if(idx == 0) {
					
					keyNames = new String[delimArr.length];
					
					for(int i = 0; i < delimArr.length; i++) {						
//						System.out.println(delimArr[i]);
						keyNames[i] = delimArr[i];		
						System.out.println(keyNames[i] + " : " + delimArr[i]);
					}
					
				}else {
					
					for(int i = 0; i < delimArr.length; i++) {						
						System.out.println(keyNames[i] + " : " + delimArr[i]);
						map.put(keyNames[i], delimArr[i]);
					}
					list.add(map);
				}
				
				idx++;
			}
			
			for (HashMap<String, String> hashMap : list) {
				System.out.println(hashMap.toString());
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
