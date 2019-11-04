package com.handashi.test.mybatis.main;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class MybatisRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession = SqlMapClient.getSqlSession();
		List<Map> list = sqlSession.selectList("test.selectTest");
		
		for(Map map:list) {
			System.out.println(map.get("MEMBER_NO"));
			System.out.println(map.get("MEMBER_NAME"));
		}
		
	}

}
