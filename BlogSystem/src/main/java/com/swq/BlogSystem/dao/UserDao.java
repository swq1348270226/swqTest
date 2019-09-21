package com.swq.BlogSystem.dao;

import com.swq.BlogSystem.pojo.Cart;
import com.swq.BlogSystem.pojo.CartDto;
import com.swq.BlogSystem.pojo.User;

public interface UserDao {
	
	public User getUser(String id);
	
	public Cart getCartList(CartDto cat);
	
	public int addCart(Cart cart);

	public int registerUserInfo(User user);
}
