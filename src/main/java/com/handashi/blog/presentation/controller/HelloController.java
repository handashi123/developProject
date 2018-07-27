package com.handashi.blog.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hellovm")
	public String index(Model model){
		model.addAttribute("name", "springBlog from handashi");
		System.out.println("---");
		return "hellovm";
	}
	
}
