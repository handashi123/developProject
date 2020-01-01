package com.handashi.common.util;

import java.io.StringWriter;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONObject;
import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class XmlToJson {
	
	public final static int PRETTY_PRINT_INDENT_FACTOR = 4;
	
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
			
			// xml to String
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();			
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			// xml string
			String output = writer.getBuffer().toString();
			
//			System.out.println(output);
			
			// xml string to json
			JSONObject xmlJsonObj = org.json.XML.toJSONObject(output);
			String jsonPrettyPrintString = xmlJsonObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			
			System.out.println(jsonPrettyPrintString);
			
			// json parsing
			ObjectMapper mapper = new ObjectMapper();
			
//			JsonNode jsonNode = mapper.readValue(jsonPrettyPrintString, JsonNode.class);
			
			JsonNode jsonNode = mapper.readTree(jsonPrettyPrintString);
			
//			System.out.println(jsonNode.toString());
			
			System.out.println(jsonNode.at("/instantiation/instantiation/instance-list").asText());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
