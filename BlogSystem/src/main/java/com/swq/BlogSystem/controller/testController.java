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
public class testController {
	
	@Autowired
	IdGenerateBusiness idGenerateBusiness;
	
	@Autowired
	HttpServletRequest request;
	
	@ResponseBody
	@RequestMapping("/test16")
	public boolean test1() {
		IdDto idDto = new IdDto();
		String id = request.getParameter("id");
		int length =Integer.parseInt(request.getParameter("length"));
		String value= request.getParameter("value");
		if(!StringUtils.isBlank(id)) {
			idDto.setPrefix(id);
		}
		if(length>0) {
			idDto.setLength(length);
		}
		if(!StringUtils.isBlank(value)) {
			idDto.setValue(value);
		}
		
		return idGenerateBusiness.createId(idDto);
	}
	
	@ResponseBody
	@RequestMapping("/test17")
	public IdDto test2() {
		String id = request.getParameter("id");
		return idGenerateBusiness.getId(id);
	}
		
	@ResponseBody
	@RequestMapping("/test18")
	public String test3() {
		String id = request.getParameter("id");
		return idGenerateBusiness.getIdGenerate(id);
	}
	
	@RequestMapping("/test19")
	public String test19() {
		return "/index2";
	}
	
	@RequestMapping("/test20")
	public String test20() {
		return "/index3";
	}
	
/*	@RequestMapping("/test20")
	@ResponseBody
	public String test20() {
		String s = "{"list": [{"img":"img/dingwei.png","manager": "新店开业刷刷送豪礼"}, {"img": "img/dingwei.png","manager": "文史楼108"},{"img": "img/dingwei.png","manager": "文史楼108"},{"img": "img/dingwei.png","manager": "文史楼108"},{"img": "img/dingwei.png","manager": "文史楼108"}]}";
		return s;
	}*/
	
	
}
