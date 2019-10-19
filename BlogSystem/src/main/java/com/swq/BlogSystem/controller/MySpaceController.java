package com.swq.BlogSystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swq.BlogSystem.business.IdGenerateBusiness;
import com.swq.BlogSystem.business.UserBusiness;
import com.swq.BlogSystem.pojo.Cart;
import com.swq.BlogSystem.pojo.CartDto;
import com.swq.BlogSystem.pojo.IdDto;
import com.swq.BlogSystem.pojo.User;
import com.swq.BlogSystem.util.StringUtils;

@Controller
public class MySpaceController {
	
	@Autowired
	IdGenerateBusiness idGenerateBusiness;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/getMyspace")
	public String getMyspace() {
		return "mySpace";
	}
	
	
}
