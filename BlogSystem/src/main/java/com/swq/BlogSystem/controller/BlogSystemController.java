package com.swq.BlogSystem.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.swq.BlogSystem.pojo.User;
import com.swq.BlogSystem.util.LoginUtil;
import com.swq.BlogSystem.util.StringUtils;


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
	public String addBlogSystem(HttpServletResponse response,@RequestBody Blog blog) {
		User user = (User)request.getSession().getAttribute("CURRENT_USER");
		if(user == null) {
			return "false";
		}
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
		request.setAttribute("content", blog.getContent());
		request.setAttribute("bid", bid);
		return "/blogDetail";
	}
	
	@RequestMapping("/addReadingCount")
	public String addReadingCount() {
		String result = "false";
		String bid = request.getParameter("bid");
		if(StringUtils.isBlank(bid)) {
			return result;
		}
		if(blogsystemBusiness.addReadingCount(bid)) {
			result = "true";
		}
		return result;
	}
	
	@RequestMapping("/getBlogWeeklyranking")
	@ResponseBody
	public List<Blog> getBlogWeeklyranking() {
		List<Blog> list= blogsystemBusiness.getBlogFeverList();
		return list;
	}
	
	@RequestMapping("/getDropDown2")
	@ResponseBody
	public Map<String,String> getDropDown2(String type){
		if(StringUtils.isBlank(type)) {
			return null;
		}
		Map<String,String> map =new HashMap<>();
		if("type_01".equals(type)) {
			map.put("type_level2_01","Java开发");
			map.put("type_level2_02","Java基础");
			map.put("type_level2_03","JavaWeb");
			map.put("type_level2_04","Java进阶");
			map.put("type_level2_05","工具类");
			map.put("type_level2_06","技术架构");
			return map;
		}
		if("type_02".equals(type)) {
			map.put("type_level2_08", "框架与技术");
			map.put("type_level2_09", "分布式微服务");
			map.put("type_level2_10", "Spring家族");
			map.put("type_level2_11", "ORM框架");
			map.put("type_level2_12", "搜索引擎框架");
			map.put("type_level2_13", "缓存技术");
			map.put("type_level2_14", "第三方依赖");
			return map;
		}
		if("type_03".equals(type)) {
			map.put("type_level2_28","JavaScript");
			map.put("type_level2_29","jQuery");
			map.put("type_level2_30","HTML");
			map.put("type_level2_31","CSS");
			map.put("type_level2_32","VUE");
			map.put("type_level2_33","前端组件");
			return map;
		}
		if("type_04".equals(type)) {
			map.put("type_level2_17", "数据库");
			map.put("type_level2_18", "人工智能");
			map.put("type_level2_19", "安全");
			map.put("type_level2_20", "云计算/大数据");
			map.put("type_level2_21", "物联网");
			map.put("type_level2_22", "其他");
			return map;
		}
		return null;
	}
	
	@RequestMapping("/getDropDown3")
	@ResponseBody
	public Map<String,String> getDropDown3(String type){
		if(StringUtils.isBlank(type)) {
			return null;
		}
		Map<String,String> map =new HashMap<>();
		if("type_level2_04".equals(type)) {
			map.put("type_level3_01", "Java源码");
			map.put("type_level3_02", "多线程");
			return map;
		}
		if("type_level2_10".equals(type)) {
			map.put("type_level3_08", "SpringBoot");
			map.put("type_level3_09", "SpringMVC");
			map.put("type_level3_10", "SpringCloud");
			return map;
		}
		return null;
	}
	
}
