package com.handashi.blog.presentation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.handashi.blog.domain.model.entity.Hello;
import com.handashi.blog.domain.model.entity.HelloJsonVo;
import com.handashi.blog.infrastructure.dao.HelloDao;

@RestController
public class HelloRestController {
	
	@Autowired
	private HelloDao helloDao;
	
	@RequestMapping("/add")
	public Hello add(Hello hello){
		
		Hello helloData = helloDao.save(hello);
		
		return helloData;
	}
	@RequestMapping("/list")
	public List<Hello> list(Model model){
		
		List<Hello> helloList = helloDao.findAll();
		
		return helloList;
		
	}
	
	//hello json test
	@RequestMapping("/helloList")
	public List<Hello> helloList(Model model){
		
		List<Hello> helloList = new ArrayList<Hello>();
		
		Hello h1 = new Hello();
		Hello h2 = new Hello();
		
		h1.setId(1);
		h1.setName("name1");
		
		h2.setId(2);
		h2.setName("name2");
		
		helloList.add(h1);
		helloList.add(h2);
		
		
		return helloList;
	}
	
	@RequestMapping("/")
	public String index(){
		return "helloworld!";
	}
	
	// hello json get test
	@RequestMapping("/getHelloList/{num}")
	public Hello getHelloList(@PathVariable int num){
		
		List<Hello> helloList = new ArrayList<Hello>();
		
		Hello h1 = new Hello();
		Hello h2 = new Hello();
				
		h1.setId(1);
		h1.setName("name1");
		
		h2.setId(2);
		h2.setName("name2");
		
		helloList.add(h1);
		helloList.add(h2);
		
		Hello retHello = new Hello();
		
		for(Hello hello: helloList) {
			if(hello.getId() == num) {
				retHello = hello;
				break;
			}
		}
		
		return retHello;
	}
	
	// hello get api test
	@RequestMapping("/getApiHello/{num}")
	public String getApiHello(@PathVariable int num) {
		
		// api get
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://localhost:8080/getHelloList/{num}", String.class, num);
		// String result = restTemplate.getForObject("http://localhost:8080/helloList", String.class);
		
		System.out.println(result);
		
		String retVal = "";
		
		try {
			// json to map
//			HashMap<String, Object> rs = new ObjectMapper().readValue(result.toString(), HashMap.class);
//			System.out.println(rs.toString());
			
			// json to vo
			HelloJsonVo helloJsonVo = new ObjectMapper().readValue(result.toString(), HelloJsonVo.class);
			System.out.println(helloJsonVo.toString());
			retVal = new ObjectMapper().writeValueAsString(helloJsonVo);
			
			// map to json
//			retVal = new ObjectMapper().writeValueAsString(rs);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retVal;
	}
	
}
