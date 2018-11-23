package com.handashi.blog.presentation.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.handashi.blog.domain.model.entity.ApiTestVo;

@RestController
@RequestMapping(value = "/api/test")
public class ApiTestController {
	
	@RequestMapping(value = "/apiMappingTest")
	public ApiTestVo apiMappingTest(@RequestHeader HttpHeaders headers, @RequestBody String requestBody) throws Exception  {
		
		System.out.println("headers : " + headers);
		System.out.println("requestBody : " + requestBody);
		
		ObjectMapper objMapper = new ObjectMapper();
		
		ApiTestVo apiTestVo = objMapper.readValue(requestBody, ApiTestVo.class);
		
		System.out.println("apiTestVo : "+ apiTestVo.toString());
			
		
		return apiTestVo;
	}
}
