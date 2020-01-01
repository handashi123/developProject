package com.handashi.common.util.vo;

public class TestEnumVo {
	
	// ENUM이 포함된 VO 클래스
	private String productName;
	private int price; //판매가
	private EnumVo2 enumVo2;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public EnumVo2 getEnumVo2() {
		return enumVo2;
	}
	public void setEnumVo2(EnumVo2 enumVo2) {
		this.enumVo2 = enumVo2;
	}
	public TestEnumVo(String productName, int price, EnumVo2 enumVo2) {
		super();
		this.productName = productName;
		this.price = price;
		this.enumVo2 = enumVo2;
	}
	@Override
	public String toString() {
		return "TestEnumVo [productName=" + productName + ", price=" + price + ", enumVo2=" + enumVo2 + "]";
	}
	public TestEnumVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDoubleRetVal() {
		return this.enumVo2.DOUBLE.getRetVal(this.price);
	}
	
	public int getTrippleRetVal() {
		return this.enumVo2.TRIPPLE.getRetVal(this.price);
	}
	
	
}
