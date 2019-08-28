package com.handashi.common.util.vo;

public enum EnumVo3 {
	TEX("세금") {
		@Override
		int calc(int value) {
			// TODO Auto-generated method stub
			return value / 10;
		}
	}, AMOUNT("원가") {
		@Override
		int calc(int value) {
			// TODO Auto-generated method stub
			return value / 8;
		}
	};
	private String name;
	private int value;
	
	private EnumVo3(String name) {
		this.name = name;
	}
//	private EnumVo3(String name, int value) {
//		this.name = name;
//		this.value = this.calc(value);
//	}
	
	abstract int calc(int value);
	
	public int getCalc(int value) {
		return this.calc(value);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
