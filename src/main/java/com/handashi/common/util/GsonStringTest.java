package com.handashi.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GsonStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sampleString = "";
		
		JsonObject jsonObject = new JsonObject();
		JsonObject data = new JsonObject();
		
		data.addProperty("num", "123");
		data.addProperty("name", "이름");
		data.addProperty("val1", "\"첫번째\"");
		
		String toJson = new Gson().toJson(data);
		
		jsonObject.addProperty("data", toJson);
		
		System.out.println("1: " + jsonObject);
		
		// json 파싱
		
		JsonObject parseJson = new Gson().fromJson(jsonObject, JsonObject.class);
		
		String dataJson = parseJson.get("data").getAsString();
		
		System.out.println("2: " + parseJson);
		System.out.println("3: " + dataJson);
		
		JsonObject inputJson = new Gson().fromJson(dataJson, JsonObject.class);
		System.out.println("4: " +inputJson);
		
		JsonObject retJson = new JsonObject();
		retJson.add("data", inputJson);
		
		System.out.println("5: " + retJson);
		
		// 한방에 파싱
//		jsonObject = new JsonObject();	
//		jsonObject.addProperty("data", "");
//		System.out.println(!jsonObject.has("data"));
		System.out.println(jsonObject.toString());
//		System.out.println(jsonObject.get("data").isJsonNull());
		
		
		JsonObject firstJson = new JsonObject();
		
		if("".equals(new Gson().fromJson(jsonObject, JsonObject.class).get("data").getAsString())) {
			System.out.println("빈값");
		}
		System.out.println("get : " + new Gson().fromJson(new Gson().fromJson(jsonObject, JsonObject.class).get("data").getAsString(), JsonObject.class).get("num").toString());
		
		firstJson.add("data", new Gson().fromJson(new Gson().fromJson(jsonObject, JsonObject.class).get("data").getAsString(), JsonObject.class));
		
		System.out.println("6: " + firstJson.toString());
		
		// data 확인
		String tempString = new Gson().fromJson(jsonObject, JsonObject.class).get("data").getAsString();
		System.out.println("7: " + tempString);
		
	}

}
