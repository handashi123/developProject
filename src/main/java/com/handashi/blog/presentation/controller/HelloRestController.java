package com.handashi.blog.presentation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.handashi.blog.domain.model.entity.Hello;
import com.handashi.blog.domain.model.entity.HelloJsonSubVo;
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
	
	// hello json vo test
	@RequestMapping("/getJsonSubVo")
	public HelloJsonSubVo getJsonSubVo() {
				
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://localhost:8080/getHelloList/{num}", String.class, 1);
		
		HelloJsonSubVo subVo = new HelloJsonSubVo();
		try {
//			subVo = new ObjectMapper().readValue(result.toString(), HelloJsonSubVo.class);
			ObjectMapper mapper = new ObjectMapper() ;
			Map<String, Object> map =  mapper.readValue(result, new TypeReference<Map<String, Object>>() {});
			System.out.println(map);
			
			subVo.setHelloName("이름1");
			subVo.setHelloValue("값1");
			
			// json node로 받는 방법
			JsonNode jsonNode = mapper.readTree(result);
			subVo.setHelloJson(jsonNode);
			
			System.out.println("2 : " + jsonNode);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(subVo);
		
		return subVo;
		
		
	}
	
/*	@RequestMapping(value = "/refTest/{className}", method = RequestMethod.POST)
	public String reflectionTest(@PathVariable String className) {
		
		String retVal = "";
		
		System.out.println("className : " + className);
		
//		HelloJsonSubVo
		
		try {
			
			WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
			Class cls = context.getBean(className).getClass();
			System.out.println("--- ' " + cls.toString());
//			 Class.forName(className);
//			Class<?> testClass = Class.forName(className);
//			Object newObj = testClass.newInstance();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return retVal;
	}
*/	
}
