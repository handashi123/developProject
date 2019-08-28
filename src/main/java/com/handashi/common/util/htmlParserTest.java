package com.handashi.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class htmlParserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder stBuilder = new StringBuilder();
		
		System.out.println(System.getProperty("user.dir"));
		
		Path currentRelativePath = Paths.get("");
		String path = currentRelativePath.toAbsolutePath().toString();
		
		System.out.println("path : " + path);
		
		File absolutePath = new File(".");
		System.out.println("absolutePath : " + absolutePath.getAbsolutePath());
				
		System.out.println("path 2 : " + htmlParserTest.class.getResource("").getPath());
		
		System.out.println("path 3 : " + htmlParserTest.class.getClassLoader().getResource("email/template/mailTemplateSample1.html").toString());
		
		// resource 경로 얻어오기 성공
		// resources 의 파일들은 컴파일 되면 설정되어있는곳 초기값은 classes/main 으로 간다. 빌드툴에서 설정 하기 나름
		// url로 받아 url.getFile 로 하게 되면 절대경로가 나온다. linux에서도 그런지 테스트 필요
		URL url = htmlParserTest.class.getClassLoader().getResource("email/template/mailTemplateSample1.html");
		System.out.println("path url : " + url.getFile());
		
		/**
		 *		C:\study\workspace\developProject\src\main\java\com\handashi\common\\util\htmlParserTest.java
		 *		C:\study\workspace\developProject\src\main\resources\email\template\mailTemplateSample1.html
		 */

		
		try {
//			BufferedReader in = new BufferedReader(new FileReader("C:\\study\\workspace\\developProject\\src\\main\\webapp\\mailSample\\mailTemplateSample1.html"));
			
//			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\study\\workspace\\developProject\\src\\main\\webapp\\mailSample\\mailTemplateSample1.html"), "UTF8"));
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(url.getFile()), "UTF8"));
			
			String str = "";
			
			while((str = in.readLine()) != null) {
				stBuilder.append(str);
			}
			
			in.close();
			
			String html = stBuilder.toString();
			
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			
			hashMap.put("subjects", "제목 입니다.");
			hashMap.put("contents", "내용 입니다.");
			hashMap.put("tail", "추신 입니다.");
			
			ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map1 = new HashMap<String, String>();
			map1.put("num", "1");
			map1.put("name", "aaa");
			arrayList.add(map1);
			
			HashMap<String, String> map2 = new HashMap<String, String>();
			map2.put("num", "2");
			map2.put("name", "bbb");
			arrayList.add(map2);
			
			HashMap<String, String> map3 = new HashMap<String, String>();
			map3.put("num", "3");
			map3.put("name", "ccc");
			arrayList.add(map3);
			
			hashMap.put("contentsList", arrayList);
			
			String mailString = makeMail(html, hashMap);
			
//			html = html.replaceAll("\\{contents\\}", "내용");
			
			// 개행문자 처리
			String line = System.getProperty("line.separator");
			mailString = mailString.replace("\\n", line);
			
			System.out.println(mailString);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static String makeMail(String template, HashMap<String, Object> hashMap) {
		
		Iterator<String> iterator = hashMap.keySet().iterator();
		
		while(iterator.hasNext()) {
			
			String key = iterator.next();
			Object value = hashMap.get(key);
			
			if(value instanceof String) {
				
				StringBuffer sb = new StringBuffer();
				sb.append("\\{");
				sb.append(key);
				sb.append("\\}");
				
				template = template.replaceAll(sb.toString(), (String)value);
				
			}else if(value instanceof ArrayList) {
				
//				contentsList
				StringBuffer sb = new StringBuffer();
				sb.append("\\{");
				sb.append(key);
				sb.append("\\}");
				
				String stList = "";
				
				int index = 0;
				
				for(HashMap<String, String> map : (ArrayList<HashMap<String, String>>)value) {
					
					stList = stList + "번호는 " + map.get("num") + " 이름은 " + map.get("name") + "입니다.";
					
					if(((ArrayList<HashMap<String, String>>) value).size() > index + 1) {
						stList = stList + "<br/>";
					}
					
					index++;
					
				}
				template = template.replaceAll(sb.toString(), stList);
				
				
			}
			
		}
		
		return template;
		
	}

}
