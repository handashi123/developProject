package com.handashi.blog.infrastructure.dao.impl;

import org.springframework.stereotype.Service;

import com.handashi.blog.infrastructure.dao.RefTest;
@Service
public class RefTestImpl implements RefTest {

	@Override
	public String RefTest(String val) {
		// TODO Auto-generated method stub
		System.out.println("RefTest Dao : " + val);
		return val;
	}

}
