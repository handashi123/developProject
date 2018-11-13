package com.handashi.blog.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloJsonVo {
	@JsonProperty("id")
	private int memberNum;
	
	@JsonProperty("name")
	private String memberName;

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "HelloJsonVo [memberNum=" + memberNum + ", memberName=" + memberName + ", getMemberNum()="
				+ getMemberNum() + ", getMemberName()=" + getMemberName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
