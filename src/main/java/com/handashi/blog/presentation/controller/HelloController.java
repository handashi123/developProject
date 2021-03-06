package com.handashi.blog.presentation.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.handashi.blog.presentation.service.ExcelDownService;
import com.handashi.test.db.TestDbService;

@Controller
public class HelloController {
	
	@Autowired
	@Qualifier("excelPoiDownServiceImpl")
	private ExcelDownService excelPoiDownServiceImpl;
	
	@Autowired
	@Qualifier("excelJxlDownServiceImpl")
	private ExcelDownService excelJxlDownServiceImpl;
	
	@Autowired
	private TestDbService testDbImpl;
	
	@RequestMapping("/hello")
	public String index(Model model){
		model.addAttribute("name", "springBlog from handashi");
		System.out.println("---");
		return "hello";
	}
	@RequestMapping("/blog")
	public String blog(Model model){
	    return "blog";
	}
	@RequestMapping("/excelDown")
	public void ExcelDown(HttpServletResponse response) throws Exception {
		
		excelPoiDownServiceImpl.excelDown(response);
	}
	@RequestMapping("/excelJxlDown")
	public void ExcelJxlDown(HttpServletResponse response) throws Exception {
		excelJxlDownServiceImpl.excelDown(response);
	}
	
	@RequestMapping("/testdb")
	@ResponseBody
	public String testDb() {
		return testDbImpl.selectTest();
	}
	
}
