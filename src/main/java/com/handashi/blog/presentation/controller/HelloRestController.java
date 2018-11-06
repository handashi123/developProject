package com.handashi.blog.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handashi.blog.domain.model.entity.Hello;
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
}
