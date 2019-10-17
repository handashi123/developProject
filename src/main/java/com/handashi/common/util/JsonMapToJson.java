package com.handashi.common.util;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapToJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("msg", "111");
		map.put("value", "222");
		map.put("retVal", "333");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			String value = mapper.writeValueAsString(map);
			
			System.out.println(value);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
