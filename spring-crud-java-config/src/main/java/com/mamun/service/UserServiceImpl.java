package com.mamun.service;

import java.util.List;

import com.mamun.dao.UserDao;
import com.mamun.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;


	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}
}
