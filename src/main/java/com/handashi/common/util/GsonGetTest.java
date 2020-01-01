package com.handashi.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GsonGetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tempJson = "{\"data\":{\"test\":\"123\"}}";
//		String tempJson = "{\r\n" + 
//				"	\"data\":\r\n" + 
//				"	{\r\n" + 
//				"			\"test\":\"123\"\r\n" + 
//				"	}\r\n" + 
//				"}";
		String sample = "{\"PRDATTSEL001\":{\"attrCompleteYn\":\"Y\"}}";
		JsonObject jsonObject = new Gson().fromJson(tempJson, JsonObject.class);
		System.out.println(jsonObject.toString());
		System.out.println(jsonObject.get("data").getAsJsonObject().get("test").getAsString());
		
		
		
		
	}

}
