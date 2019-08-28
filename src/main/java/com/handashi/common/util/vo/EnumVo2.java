/**
 * 
 */
package com.handashi.common.util.vo;

/**
 * @author han
 *
 */
public enum EnumVo2 {
	DOUBLE("두배", 2)
	, TRIPPLE("세배", 3);
	
	private String name;
	private int value;
	
	private EnumVo2(String name, int value) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.value = value;		
	}
	
	public int getRetVal(int value) {
		return value * this.value;
	}
	
	
}
