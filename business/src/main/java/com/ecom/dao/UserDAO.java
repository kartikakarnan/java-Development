package com.ecom.dao;
import java.util.List;

import com.ecom.model.User;

public interface UserDAO
{
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public User getUser(int user);
	public List<User> getUser();
	


	
}
