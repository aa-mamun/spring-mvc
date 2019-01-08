package com.mamun.service;

import com.mamun.model.User;

import java.util.List;




public interface UserService {
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(int userId);
	List<User> getAllUser();
	public User getUserById(int userId);
}
