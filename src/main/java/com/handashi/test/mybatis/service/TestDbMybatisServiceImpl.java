package com.handashi.test.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handashi.test.db.TestDbService;
import com.handashi.test.mybatis.mapper.MybatisTestMapper;
import com.handashi.test.mybatis.vo.MybatisTestVo;
@Service
public class TestDbMybatisServiceImpl implements TestDbService {
	
	@Autowired
	MybatisTestMapper mapper;
	
	@Override
	public String selectTest() {
		// TODO Auto-generated method stub
		String retVal = "";
		
		MybatisTestVo vo = mapper.selectTest();
		
		System.out.println("vo number : " + vo.getMemberNo());
		System.out.println("vo name : " + vo.getMemberName());
		
		retVal = vo.getMemberName();
		
		return retVal;
	}

}
