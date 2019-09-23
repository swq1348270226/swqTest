package com.swq.BlogSystem.dao;

import java.util.List;

import com.swq.BlogSystem.pojo.Blog;
import com.swq.BlogSystem.pojo.BlogParm;

public interface BlogDao {
	public int createBlog(Blog blog);
	
	public List<Blog> getBlogList(BlogParm parm);
	
	public int getBlogCount(BlogParm blogParm);
	
	public Blog getBlogById(String bid);
	
	public boolean addReadingCount(String bid);
	
	public List<Blog> getBlogFeverList();
}
