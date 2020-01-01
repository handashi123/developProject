package com.handashi.test.daemon;

public class CommonCount {
	public static int commonCount = 0;

	int getCommonCount() {
		return commonCount;
	}

	void setCommonCount(int commonCount) {
		this.commonCount = commonCount;
	}
	
	void minusCount() {
		commonCount = commonCount -1;
	}
	
	
}
