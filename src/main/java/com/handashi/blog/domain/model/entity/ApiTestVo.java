package com.handashi.blog.domain.model.entity;

import java.util.List;

public class ApiTestVo {
	private String id;
	private String name;
	private List<ApiTestSubListVo> apiTestSubList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ApiTestSubListVo> getApiTestSubList() {
		return apiTestSubList;
	}
	public void setApiTestSubList(List<ApiTestSubListVo> apiTestSubList) {
		this.apiTestSubList = apiTestSubList;
	}
	@Override
	public String toString() {
		return "ApiTestVO [id=" + id + ", name=" + name + ", apiTestSubList=" + apiTestSubList + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getApiTestSubList()=" + getApiTestSubList() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
