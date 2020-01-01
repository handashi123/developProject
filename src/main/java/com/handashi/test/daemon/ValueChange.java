package com.handashi.test.daemon;

public class ValueChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CommonCount cnt = new CommonCount();
		cnt.commonCount = 55;
		while(cnt.commonCount > 0) {
			System.out.println("*** " + cnt.commonCount);
		}
		
	}

}
