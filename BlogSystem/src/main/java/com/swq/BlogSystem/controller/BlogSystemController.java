package com.swq.BlogSystem.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swq.BlogSystem.business.BlogsystemBusiness;
import com.swq.BlogSystem.business.IdGenerateBusiness;
import com.swq.BlogSystem.pojo.Blog;
import com.swq.BlogSystem.util.StringUtils;
import com.swq.BlogSystem.util.UUIDUtil;


@Controller
public class BlogSystemController {
	
	@Autowired
	BlogsystemBusiness blogsystemBusiness;
	
	@Autowired
	IdGenerateBusiness idGenerateBusiness;
	
	@Autowired
	HttpServletRequest request;
	
/*	@Autowired
	HttpServletResponse response;*/
	
	@RequestMapping("/addBlogSystem")
	@ResponseBody
	public String addBlogSystem(@RequestBody Blog blog) {
		if(blog ==null) {
			return "false";
		}
		String bid = idGenerateBusiness.getIdGenerate("BL");
		if(StringUtils.isBlank(bid)) {
			return "false";
		}
		blog.setBid(bid);
		blog.setIsDelete("0");
		blog.setCommit("test1");
		boolean b = blogsystemBusiness.createBlog(blog);
		if(b) {
			return "true";
		}
		
		return "false";
	}
	
	@RequestMapping("/createBlogSystem")
	public String index() {
		return "/createBlogSystem";
	}
	
	@RequestMapping("/index51")
	public String index2() {
		return "/test111111111111";
	}
	
	@RequestMapping("/blogDetail")
	public String blogDetail() {
		Blog blog = new Blog();
		String bid = request.getParameter("bid");
		if(StringUtils.isBlank(bid)) {
			return "error";
		}
		blog = blogsystemBusiness.getBlogById(bid);
/*		request.setAttribute("blog", blog);
		request.setAttribute("111", 111);*/
		request.setAttribute("content", blog.getContent());
		return "/blogDetail";
	}
	
	
}