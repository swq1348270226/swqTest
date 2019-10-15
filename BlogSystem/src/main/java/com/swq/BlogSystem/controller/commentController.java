package com.swq.BlogSystem.controller;

import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.swq.BlogSystem.business.CommentBusiness;
import com.swq.BlogSystem.business.IdGenerateBusiness;
import com.swq.BlogSystem.pojo.Comment;
import com.swq.BlogSystem.pojo.User;
import com.swq.BlogSystem.util.LoginUtil;
import com.swq.BlogSystem.util.StringUtils;

@Controller
public class commentController {
	
	@Autowired
	CommentBusiness commentBusiness;
	
	@Autowired
	IdGenerateBusiness idGenerateBusiness;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/getCommentHtml")
	public String getCommentHtml() {
		return "/comment";
	}
	
	@RequestMapping("/submitComment")
	@ResponseBody
	public String submitComment(HttpServletResponse response,String bid,String score,String comment) {
		String id = idGenerateBusiness.getIdGenerate("RP");
		if(StringUtils.isBlank(bid) || StringUtils.isBlank(comment) || StringUtils.isBlank(score) || StringUtils.isBlank(id)) {
			return "false";
		}
		User user = (User)request.getSession().getAttribute("CURRENT_USER");
		if(user == null) {
			return "false";
		}
		Map<String,String> map = new HashMap<>();
		map.put("bid",bid );
		map.put("score", score);
		map.put("comment", comment);
		map.put("comment_id",id);
		map.put("user_id",user.getUserName());
		map.put("sysuser_id",user.getId());
		return commentBusiness.createComent(JSON.toJSONString(map));
	}
	
	@RequestMapping("/getCommentList")
	@ResponseBody
	public List<Comment> getCommentList(String bid){
		if(StringUtils.isBlank(bid)) {
			return null;
		}
		Map<String,String> map = new HashMap<>();
		map.put("bid", bid);
		List<Comment> list = null;
		try {
			list = commentBusiness.getCommentList(JSON.toJSONString(map),true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping("/getNewestComment")
	@ResponseBody
	public List<Comment> getNewestComment(){
		Map<String,Object> map = new HashMap<>();
		User user = (User)request.getSession().getAttribute("CURRENT_USER");
		if(user!=null) {
			map.put("sysuserId", user.getId());
		}
		map.put("pageIndex", 0);
		map.put("pageSize", 10);
		List<Comment> list = null;
		try {
			list = commentBusiness.getCommentList(JSON.toJSONString(map),false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping("/replySubmit")
	@ResponseBody
	public String replySubmit(String commentId,String replyContent) {
		String replyId = idGenerateBusiness.getIdGenerate("ORP");
		if(StringUtils.isBlank(commentId) || StringUtils.isBlank(replyContent) || StringUtils.isBlank(replyId)) {
			return "false";
		}
		Map<String,Object> map = new HashMap<>();
		User user = (User)request.getSession().getAttribute("CURRENT_USER");
		if(user == null) {
			return "false";
		}
		map.put("sysuserId", user.getId());
		map.put("userId", user.getUserName());
		
		map.put("replyId", replyId);
		map.put("commentId", commentId);
		map.put("replyContent", replyContent);
		return commentBusiness.createReply(JSON.toJSONString(map));
		 
	}
	
}
