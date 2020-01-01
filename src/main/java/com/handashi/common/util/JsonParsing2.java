package com.handashi.common.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonParsing2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonObject obj = new JsonObject();
		obj.addProperty("name", "이름1");
		obj.addProperty("value", "값1");

		JsonObject obj2 = new JsonObject();
		obj2.addProperty("name", "이름1");
		obj2.addProperty("value", "값1");

		JsonArray jArray = new JsonArray();
		jArray.add(obj);
		jArray.add(obj2);

		JsonObject objt = new JsonObject();
		objt.add("list", jArray);

		System.out.println(objt.toString());
	}

}
