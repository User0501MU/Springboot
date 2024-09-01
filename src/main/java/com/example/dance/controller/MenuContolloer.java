package com.example.dance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuContolloer {
	@GetMapping("/menu")
	public String view() {

		return "menu";
	}

}
