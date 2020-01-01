package com.handashi.blog.domain.model.entity;

public class ApiTestSubListVo {
	String apiName;
	String apiValue;
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getApiValue() {
		return apiValue;
	}
	public void setApiValue(String apiValue) {
		this.apiValue = apiValue;
	}
	@Override
	public String toString() {
		return "ApiTestSubListVo [apiName=" + apiName + ", apiValue=" + apiValue + ", getApiName()=" + getApiName()
				+ ", getApiValue()=" + getApiValue() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
