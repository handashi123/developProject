/**
 * 
 */
package com.handashi.common.util.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author han
 *	ENUM 을 Map으로 담아 사용
 */
public enum EnumCodeMapVo {
	HAMBURGER(1, "햄버거", 5000)
	, HOTDOG(2, "핫도그", 3000)
	, COFFEE(3, "커피", 4500)
	, TEA(4, "차", 4000)
	, UNKNOWN(0, "", 0);
	
	private int code;
	private String name;
	private long price;
	
	public int getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public long getPrice() {
		return this.price;
	}
	
	private EnumCodeMapVo(int code, String name, long price) {
		this.code = code;
		this.name = name;
		this.price = price;
		
	}
	
	// map 선언
	private static final Map<Integer, EnumCodeMapVo> map = new HashMap<Integer, EnumCodeMapVo>();
	
	static {
		for(EnumCodeMapVo vo:values()) {
			map.put(vo.code, vo);
		}
	}
	
	public static EnumCodeMapVo getEnumByCode(int code) {
		return map.get(code);
	}
}
