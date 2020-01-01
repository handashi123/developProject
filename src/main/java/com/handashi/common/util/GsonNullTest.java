package com.handashi.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GsonNullTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tempJson = "{\"data\":{\"\":\"\"}}";
//		String tempJson = "123";
		
		System.out.println(new Gson().fromJson(tempJson, JsonObject.class).isJsonObject());
		
		new Gson().fromJson(tempJson, JsonObject.class).has("data");
		
		System.out.println(new Gson().fromJson(tempJson, JsonObject.class).isJsonObject());
		
		JsonObject jsonObject = new Gson().fromJson(tempJson, JsonObject.class);
		
		System.out.println("1 : " + jsonObject);
		
		System.out.println(jsonObject.get("data").isJsonNull());
		System.out.println("2 : " + jsonObject.get("data").toString().equals("{}"));
//		jsonObject.get("data").getAsJsonObject().get;
		System.out.println(jsonObject.get("data").isJsonObject());
		System.out.println(jsonObject.get("data").getAsJsonObject());
		System.out.println("".equals(jsonObject.get("data").getAsJsonObject().toString()));
//		System.out.println("".equals(jsonObject.get("data").getAsString()));
		String val = "";
	}

}
