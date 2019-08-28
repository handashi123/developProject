/**
 * 
 */
package com.handashi.common.util.vo;

/**
 * @author han
 *
 */
public enum EnumVo {
	NUMBER("1"),
	NAME("홍길동"),
	ADDRESS("인천"),
	PHON_NUMBER("111");
	
	private String param;
	private String param2;

	public String getParam() {
		return this.param;
	}

	private EnumVo(String param) {
		this.param = param;
	}

	private EnumVo(String param, String param2) {
		this.param = param;
		this.param2 = param2;
	}

	public String getParam2() {
		return this.param2;
	}
	
}
