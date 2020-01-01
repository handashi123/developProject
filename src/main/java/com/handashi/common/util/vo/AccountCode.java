/**
 * 
 */
package com.handashi.common.util.vo;

/**
 * @author han
 *
 */
public enum AccountCode {
	SYSTEM_EMPTY("시스템계정 없음")
	, USER_EMPTY("사용자계정 없음")
	, ACCOUNT_OK("계정비교 정상")
	, ACCOUNT_EXCEPT("계정비교 비정상")
	, EMPTY("");	
	
	private String codeDesc;
	
	private AccountCode(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	
	public String getCodeDesc() {
		return this.codeDesc;
	}
	/**
	 * 인입된 코드로 코드 비교해서 해당 enum객체를 가져온다.
	 * 해당하지 않는 코드일때는 null 반환
	 * @param code 해당되는 코드
	 * @return 정상 : 해당코드, 예외 : 빈값코드
	 */
	public static AccountCode findCode(String code) {
		
		AccountCode retObject = EMPTY;
		
		for(AccountCode accountCode:values()) {
			if(code.equals(accountCode.name())) {
				retObject = accountCode;
			}
		}
		
		return retObject;
		
	}
	
}
