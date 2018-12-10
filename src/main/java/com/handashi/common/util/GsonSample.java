package com.handashi.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GsonSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("시작");

		String tempJson = "{\r\n" + "	\"custList\": [{\r\n" + "		\"seq\": \"1\",\r\n" + "		\"custNm\": \"홍길동\"		\r\n" + "	},\r\n"
				+ "	{\r\n" + "		\"seq\": \"2\",\r\n" + "		\"custNm\": \"임꺽정\"		\r\n" + "	},\r\n" + "	{\r\n"
				+ "		\"seq\": \"3\",\r\n" + "		\"custNm\": \"아무개\"		\r\n" + "	}]\r\n" + "}";

		JsonObject jsonObject = new Gson().fromJson(tempJson, JsonObject.class);
		JsonArray jsonArray = jsonObject.getAsJsonArray("custList");

//		String[] arrName = new Gson().fromJson(jsonArray, String[].class);

		System.out.println("jsonArray : " + jsonArray.toString());
		String seq = "";
		String custNm = "";
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject tempJb = (JsonObject) jsonArray.get(i);
			seq = tempJb.get("seq").toString().replace("\"", "");
			custNm = tempJb.get("custNm").toString().replace("\"", "");
			System.out.println("seq : " + seq);
			System.out.println("custNm : " + custNm);
		}

		//----------------------------------------------------------
		// Gson 을 이용해 Json 만들기
		// JsonObject 에 추가해서 만들면 된다. List나 다른 객체도 되는것 같다.
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
//		obj.add("jsonList", jsonArray);
		obj.addProperty("name", "list1");
		obj.add("array1", jsonArray);

		System.out.println("obj : " + obj.toString());

//		System.out.println("arrName : " + arrName);
	}

}
