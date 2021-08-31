package com.handashi.common.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JobHtmlParserTest {
	// 한번에 가져올수 있는 최대 행수
	public static int ROW_COUNT = 100;
	// 반복횟수
	public static int loopCnt = 10;
	// 거를 업체목록
	public static String[] badCompanyArr = {"투비모아", "텐비트"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
						
			for (int i = 0; i < loopCnt; i++) {

				int offset = i * ROW_COUNT;
				
				String sUrl = "https://okky.kr/articles/jobs?offset="+offset+"&max=100&sort=id&order=desc";
				
				System.out.println("sUrl : " + sUrl);
				
				Document doc = Jsoup.connect(sUrl).timeout(5000).get();
				
//				Elements elements = doc.select(".list-group-item list-group-item-question list-group-no-note clearfix");
				
				Elements elements = doc.select(".list-group");
				
//				System.out.println(elements.toString());
				for(Element e : elements) {
					// 안에 내용만 빼서 text로 보여줌
//					 System.out.println("text : " + e.text());
					// 안에 포함된 html포함 내용 text로 보여줌
//					 System.out.println("html : " + e.html());
					
					 Elements eVals = e.getElementsByAttributeValue("class", "list-group-item list-group-item-question list-group-no-note clearfix");
					 
					 for(Element eVal : eVals) {
//						 System.out.println(eVal.text());
//						 System.out.println("========================================");
						 
						 // 내용중 거를 업체는 제외
						 boolean excludeFlag = true;
						 for(String badCompany : badCompanyArr) {
							 if(eVal.text().matches("(.*)"+badCompany+"(.*)")) {
								 excludeFlag = false;
							 }
						 }
						 
						 if(excludeFlag) {
							 System.out.println("text : " + eVal.text());
							 System.out.println("https://okky.kr/recruit/" + eVal.text().substring(1, 7));
							 System.out.println("========================================");
						 }
						 
						 
						
						
						
					 }
					
				}
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
