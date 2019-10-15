package com.swq.BlogSystem.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.swq.BlogSystem.dao.CommentDao;
import com.swq.BlogSystem.pojo.Comment;
import com.swq.BlogSystem.pojo.Reply;
import com.swq.BlogSystem.util.StringUtils;

@Component
public class CommentBusiness {
	
	@Autowired
	CommentDao commentDao;
	
	public String createComent(String json) {
		if(StringUtils.isBlank(json)) {
			return "false";
		}
		Map<String,String> map = new HashMap<>();
		map = (Map)JSON.parse(json);
		int result = commentDao.createComent(map);
		if(result == 1) {
			return "success";
		}
		return "false";
	}
	
	public List<Comment> getCommentList(String json,boolean boo) throws Exception{
		if(StringUtils.isBlank(json)) {
			throw new IllegalArgumentException("參數非法");
		}
		Map<String,String> map = (Map)JSON.parse(json);
		List<Comment> list = commentDao.getCommentList(map);
		if(!boo) {
			return list;
		}
		if(list == null) {
			return list;
		}
		List<Comment> listNew = new ArrayList<>();
		if(boo) {
			List<Reply> replyList = null;
			for(Comment coment : list) {
				if(!StringUtils.isBlank(coment.getBid())) {
					replyList = commentDao.getReplyList(coment.getCommentId());
					coment.setReplyList(replyList);
				}
				listNew.add(coment);
			}
		}
		return listNew;
	}

	public String createReply(String json) {
		Map<String,String> map = (Map)JSON.parse(json);
		
		if(map.isEmpty() || StringUtils.isBlank(map.get("commentId")) || 
				StringUtils.isBlank(map.get("replyContent")) || StringUtils.isBlank(map.get("replyId"))) {
			return "false";
		}
		int result = commentDao.createReply(map);
		if(result == 1) {
			return "success";
		}
		return "false";
	}
	
}
