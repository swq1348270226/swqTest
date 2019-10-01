package com.swq.BlogSystem.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swq.BlogSystem.dao.UserDao;
import com.swq.BlogSystem.pojo.Cart;
import com.swq.BlogSystem.pojo.CartDto;
import com.swq.BlogSystem.pojo.User;
import com.swq.BlogSystem.util.StringUtils;

@Component
public class UserBusiness {
	@Autowired
	UserDao userDao;
	
	public User getUserById(String id) {
		User user = userDao.getUser(id);
		return user;
	}
	
	public User getUserInfo(User user) {
		if(user == null || (StringUtils.isBlank(user.getId()) && StringUtils.isBlank(user.getUserName()))) {
			return null;
		}
		return user = userDao.getUserInfo(user);
		 
	}
	
	public Cart getCartList(CartDto cat) {
		Cart cart = userDao.getCartList(cat);
		return cart;
	}
	
	public int addCart(Cart cat) {
		int i = userDao.addCart(cat);
		return i;
	}
	
	public int registerUserInfo(User user) {
		if(StringUtils.isBlank(user.getId()) || StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassword())) {
			return 0;
		}
		return userDao.registerUserInfo(user);
	}
	
}
