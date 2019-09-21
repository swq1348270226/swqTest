package com.swq.BlogSystem.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swq.BlogSystem.dao.BlogDao;
import com.swq.BlogSystem.pojo.Blog;
import com.swq.BlogSystem.pojo.BlogParm;
import com.swq.BlogSystem.util.StringUtils;

@Component
public class BlogsystemBusiness {
	
	@Autowired
	BlogDao blogDao;
	
	public boolean createBlog(Blog blog) {
		if(blog == null || blog.getBid().equals("") || blog.getBid() == null || blog.getTitle() == null || blog.getTitle().equals("")) {
			return false;
		}
		int result = blogDao.createBlog(blog);
		if(result==1) {
			return true;
		}
		return false;
	}
	
	public List<Blog> getBlogList(BlogParm blogParm) throws Exception{
		List<Blog> blogList = new ArrayList<>();
		if(blogParm == null || blogParm.getPageIndex() < 0 || blogParm.getPageSize() < 0 || blogParm.getPageSize()>50 ) {
			throw new IllegalArgumentException("參數非法");
		}
		blogList = blogDao.getBlogList(blogParm);
		return blogList;
	}
	
	public int getBlogCount(BlogParm blogParm) throws Exception{
		int count = 0;
		if(blogParm == null) {
			throw new IllegalArgumentException("參數非法");
		}
		count = blogDao.getBlogCount(blogParm);
		return count;
	}
	
	public Blog getBlogById(String bid) {
		if(StringUtils.isBlank(bid)) {
			throw new IllegalArgumentException("参数非法");
		}
		return blogDao.getBlogById(bid);
	}
	
	
	

}
