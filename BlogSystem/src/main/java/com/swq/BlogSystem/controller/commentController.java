package com.swq.BlogSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class commentController {
	
	@RequestMapping("/getCommentHtml")
	public String getCommentHtml() {
		return "/comment";
	}
	

}
