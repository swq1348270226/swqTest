package com.swq.BlogSystem.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swq.BlogSystem.business.BlogsystemBusiness;
import com.swq.BlogSystem.pojo.Blog;
import com.swq.BlogSystem.pojo.BlogParm;
import com.swq.BlogSystem.util.StringUtils;
import com.swq.BlogSystem.util.UUIDUtil;


@Controller
public class IndexController {
	
	@Autowired
	BlogsystemBusiness blogsystemBusiness;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/getHead")
	public String getHead() {
		return "/head";
	}

	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("/getBlogList")
	@ResponseBody
	public List<Blog> getBlogList() {
		
		BlogParm blogParm = new BlogParm();
		String pageIndex = request.getParameter("pageIndex");
		String pageSize = request.getParameter("pageSize");
		if(!StringUtils.isBlank(pageSize)) {
			blogParm.setPageSize(Integer.valueOf(pageSize));
		}
		if(!StringUtils.isBlank(pageSize)) {
			blogParm.setPageIndex((Integer.valueOf(pageIndex)-1)*Integer.valueOf(pageSize));
		}
		
		List<Blog> list = new ArrayList<>();
		try {
			list = blogsystemBusiness.getBlogList(blogParm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping("/getBlogCount")
	@ResponseBody
	public int getBlogCount() {
		int count = 0;
		BlogParm blogParm = new BlogParm();
		try {
			count = blogsystemBusiness.getBlogCount(blogParm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	private BlogParm setParm() {
		BlogParm blogParm = new BlogParm();
		return blogParm;
	}
	


}
