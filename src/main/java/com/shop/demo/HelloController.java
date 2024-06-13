package com.shop.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloController {
	@GetMapping("/")
	public String index() {
		log.info("index controller");
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("data","hello!");
		return "hello";
	}
}
