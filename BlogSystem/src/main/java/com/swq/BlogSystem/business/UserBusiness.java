package com.swq.BlogSystem.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swq.BlogSystem.dao.UserDao;
import com.swq.BlogSystem.pojo.Cart;
import com.swq.BlogSystem.pojo.CartDto;
import com.swq.BlogSystem.pojo.User;

@Component
public class UserBusiness {
	@Autowired
	UserDao userDao;
	
	public User getUser(String id) {
		User user = userDao.getUser(id);
		return user;
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
		
		return userDao.registerUserInfo(user);
	}
	
}
