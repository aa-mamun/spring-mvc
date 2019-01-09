package com.mamun.dao;

import java.util.List;


import com.mamun.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}


	public void saveUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	public void deleteUser(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User id = (User) sessionFactory.getCurrentSession().load(
				User.class, userId);
		if (null != id) {
			this.sessionFactory.getCurrentSession().delete(id);
		}

	}

	public List<User> getAllUser() {
		return this.sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public User getUserById(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		return (User) session.get(User.class, userId);
	}
}
