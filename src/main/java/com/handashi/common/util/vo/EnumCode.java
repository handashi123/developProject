/**
 * 
 */
package com.handashi.common.util.vo;

import java.util.HashMap;

/**
 * @author han
 *
 */
public enum EnumCode {
	HAMBURGER(1, "햄버거"), HOTDOG(2, "핫도그");
	
	private int code;
	private String name;
	private static final HashMap<Integer, EnumCode> map = new HashMap<>();
	
	private EnumCode(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	static {
		System.out.println("EnumCode 처음");
		for(EnumCode enumCode:EnumCode.values()) {
			map.put(enumCode.code, enumCode);
		}
	}
	
	public static EnumCode enumCodeByCode(int code) {
		return map.get(code);
	}
}
