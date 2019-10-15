package com.swq.BlogSystem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swq.BlogSystem.business.IdGenerateBusiness;
import com.swq.BlogSystem.business.UserBusiness;
import com.swq.BlogSystem.pojo.Cart;
import com.swq.BlogSystem.pojo.CartDto;
import com.swq.BlogSystem.pojo.User;
import com.swq.BlogSystem.util.StringUtils;

@Controller
public class LoginController {
	
	@Autowired
	UserBusiness userBusiness;
	
	@Autowired
	IdGenerateBusiness idGenerateBusiness;
	
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
	
	//登录验证
	@ResponseBody
	@RequestMapping("/validateLogin")
	public String validateLogin() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || username =="" || password==null || password ==""){
			return "false";
		}
		User user1 = new User();
		user1.setUserName(username);
		User user = userBusiness.getUserInfo(user1);
		
		if(user == null) {
			return "false";
		}
		if(password.equals(user.getPassword())) {
			//去掉密碼
			user.setPassword("");
			
			HttpSession session = request.getSession();
			session.setAttribute("CURRENT_USER", user);
			
			return "true";
		}

		return "false";
	}
	
	//验证是否登录
	@ResponseBody
	@RequestMapping("/checkIsLogin")
	public Map<String,String> checkIsLogin() {
		 Map<String,String> map = new HashMap<>();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("CURRENT_USER");
		if(user == null) {
			map.put("status", "noLogin");
			map.put("url", "/BlogSystem/login/BlogSystem/login?redirect=http://localhost:8080/BlogSystem/blogDetail?bid=BL100016");
			return map;
		}
		map.put("status", "login");
		map.put("name", user.getUserName());
		return map;
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
	
	//注册
	@RequestMapping("/registerUserInfo")
	@ResponseBody
	public String registerUserInfo() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username == null || username =="" || password==null || password ==""){
			return "false";
		}
		//验证账号是否存在
		User user1 = new User();
		user1.setUserName(username);
		User user2 = userBusiness.getUserInfo(user1);
		if(user2 != null) {
			return "repeat";
		}
		
		User user = new User();
		String id = idGenerateBusiness.getIdGenerate("SU");
		if(StringUtils.isBlank(id)) {
			return "false";
		}
		user.setId(id);
		user.setUserName(username);
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
		
	@RequestMapping("/checkUser")
	@ResponseBody
	public String checkUser(String username) {
		if(StringUtils.isBlank(username)) {
			return "false";
		}
		User user1 = new User();
		user1.setUserName(username);
		User user = userBusiness.getUserInfo(user1);
		if(user != null) {
			return "repeat";
		}
		return "success";
	}
	
	//路劲地址改变了
	@RequestMapping("/cancellation")
	public void cancellationLogin(HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("CURRENT_USER");
		try {
			response.sendRedirect("/BlogSystem/index");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
