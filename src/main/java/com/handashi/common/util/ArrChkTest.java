package com.handashi.common.util;

public class ArrChkTest {
	public static void main(String[] args) {
		
		// 배열체크
		String[] deptMvSeqArr = {"51", "22"}; 	// 부서이동 seq
    	String[] appSysIdArr = {"2", "33"}; 	// 시스템id
    	String[] cmpNbArr = {"1", "aa"}; 			// 통합id
		
    	boolean retBool = arrayCheck(deptMvSeqArr, appSysIdArr, cmpNbArr);
    	
    	System.out.println(retBool);
    	
	}
	/**
	 * 배열체크
	 * 배열안에 ""값이나 null 값이 있는지 체크
	 * @param strArrs 배열(가변인자)
	 * @return true : 빈값없음, false : 빈값있음.
	 */
	public static boolean arrayCheck(String[]... strArrs) {
		
		boolean retBool = true;
		
		for(String[] strArr:strArrs) {
			
			for(int i = 0; i < strArr.length; i++) {
				
				if("".equals(strArr[i]) || null == strArr[i]) {
					retBool = false;
				}
			}
			
		}
		
		return retBool;
	}
	
	
	
}
