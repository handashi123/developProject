package com.handashi.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class GsonPrettyJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jsonStr = "{\"data\":{\"name\":\"aaa\", \"value\":\"111\"}}";
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = gson.toJson(new Gson().fromJson(jsonStr, JsonObject.class));
		
		System.out.println(prettyJson);
		
		
	}

}
