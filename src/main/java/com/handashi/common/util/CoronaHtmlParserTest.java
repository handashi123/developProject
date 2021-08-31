package com.handashi.common.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CoronaHtmlParserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Document doc = Jsoup.connect("https://www.incheon.go.kr/health/HE020409").get();
			
			// System.out.println(doc.toString());
			
			Elements elements = doc.select(".patient-profile-route-group");
			
			for(Element e : elements) {
				// 안에 내용만 빼서 text로 보여줌
				// System.out.println("text : " + e.text());
				// 안에 포함된 html포함 내용 text로 보여줌
				// System.out.println("html : " + e.html());
				
				// 내용중 산곡이 포함된것들 보여줌
				if(e.text().matches("(.*)부평.*동(.*)") || e.text().matches("(.*)산곡(.*)")) {				
					System.out.println("text : " + e.text());
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
