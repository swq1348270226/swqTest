package com.swq.BlogSystem.dao;

import java.util.List;
import java.util.Map;

import com.swq.BlogSystem.pojo.Comment;
import com.swq.BlogSystem.pojo.Reply;

public interface CommentDao {
	public int createComent(Map<String,String> map);

	public List<Comment> getCommentList(Map<String,String> map );

	public int createReply(Map<String,String> map);

	public List<Reply> getReplyList(String commentId);
}
