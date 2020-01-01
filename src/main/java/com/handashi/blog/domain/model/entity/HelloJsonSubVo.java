package com.handashi.blog.domain.model.entity;

import com.fasterxml.jackson.databind.JsonNode;

public class HelloJsonSubVo {
	private String helloName;
	private String helloValue;
	private JsonNode helloJson;
	
	public String getHelloName() {
		return helloName;
	}
	public void setHelloName(String helloName) {
		this.helloName = helloName;
	}
	public String getHelloValue() {
		return helloValue;
	}
	public void setHelloValue(String helloValue) {
		this.helloValue = helloValue;
	}
	public JsonNode getHelloJson() {
		return helloJson;
	}
	public void setHelloJson(JsonNode helloJson) {
		this.helloJson = helloJson;
	}
	@Override
	public String toString() {
		return "HelloJsonSubVo [helloName=" + helloName + ", helloValue=" + helloValue + ", helloJson=" + helloJson
				+ ", getHelloName()=" + getHelloName() + ", getHelloValue()=" + getHelloValue() + ", getHelloJson()="
				+ getHelloJson() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
