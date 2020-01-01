package com.handashi.common.util;

import java.util.EnumSet;
import java.util.Iterator;

import com.handashi.common.util.vo.AccountCode;

public class EnumAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String code = "ACCOUNT_OK1";
		
		System.out.println(AccountCode.findCode(code).getCodeDesc());
		
		// EnumSet Test
		EnumSet<AccountCode> eSet = EnumSet.allOf(AccountCode.class);
		
		System.out.println(eSet.size());
		System.out.println(eSet.of(AccountCode.SYSTEM_EMPTY, AccountCode.USER_EMPTY));
		
		Iterator<AccountCode> iter = eSet.iterator();
		
		while(iter.hasNext()) {
			AccountCode ac = iter.next();
			System.out.println("EnumSet : " + ac.name());
		}
		
		
		
	}

}
