package com.handashi.common.util;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		try {
			// resource 읽기
			URL url = XmlParserTest.class.getClassLoader().getResource("xml/template/xmlTemplate.xml");
			
			// 파일읽어오기
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder;
			documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(url.getFile());
			
			Element root = document.getDocumentElement();
			
			NodeList children = root.getChildNodes();
			
			for(int i = 0; i < children.getLength(); i++) {
				Node node = children.item(i);
				
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					
					Element el = (Element)node;
					String nodeName = el.getNodeName();
					System.out.println("=== 1) node name : " + nodeName);
					
					// 2depth
					NodeList children2 = el.getChildNodes();
					
					for(int i2 = 0; i2 < children2.getLength(); i2++) {
						Node node2 = children2.item(i2);
						if(node2.getNodeType() == Node.ELEMENT_NODE) {
							Element el2 = (Element)node2;
							String nodeName2 = el2.getNodeName();
							System.out.println("=== 2) node name : " + nodeName2);
						}						
						
					}					
					
				}
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
