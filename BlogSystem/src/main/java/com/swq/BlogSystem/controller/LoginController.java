package com.swq.BlogSystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swq.BlogSystem.business.UserBusiness;
import com.swq.BlogSystem.pojo.Cart;
import com.swq.BlogSystem.pojo.CartDto;
import com.swq.BlogSystem.pojo.User;

@Controller
public class LoginController {
	
	@Autowired
	UserBusiness userBusiness;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/register")
	public String register() {
		return "/register";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
	
	
	@ResponseBody
	@RequestMapping("/validateLogin")
	public String validateLogin() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || username =="" || password==null || password ==""){
			return "false";
		}
		
		User user = userBusiness.getUser(username);
		if(user == null) {
			return "false";
		}
		if(password.equals(user.getPassword())) {
			return "true";
		}

		return "false";
	}
	
	@ResponseBody
	@RequestMapping("/checkCode")
	public String checkCode(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		String sessionCode=(String)request.getSession().getAttribute("code");
		if(sessionCode.equals(code)) {
			return "success";
		}
		return "false";
	}
	
	@RequestMapping("/registerUserInfo")
	@ResponseBody
	public String registerUserInfo() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username == null || username =="" || password==null || password ==""){
			return "false";
		}
		User user = new User();
		user.setId(username);
		user.setPassword(password);
		int i = userBusiness.registerUserInfo(user);
		if(i!=1) {
			return "false";
		}
		return "true";
	}
	
	@ResponseBody
	@RequestMapping("/validateCode")
	public boolean validateCode() {
		String str = request.getParameter("code");
		String code =(String)request.getSession().getAttribute(request.getParameter("modelName"));
		if(str == null || str =="" ||code == null || code == "") {
			return false;
		}
		if(str.equalsIgnoreCase(code)) {
			return true;
		}
		return false;
	}
		
}
