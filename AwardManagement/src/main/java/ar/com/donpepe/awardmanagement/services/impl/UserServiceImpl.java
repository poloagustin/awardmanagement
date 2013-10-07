package ar.com.donpepe.awardmanagement.services.impl;

import java.util.List;

import ar.com.donpepe.awardmanagement.daos.UserDao;
import ar.com.donpepe.awardmanagement.domain.User;
import ar.com.donpepe.awardmanagement.services.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	@Override
	public List<User> getAll() {
		return this.userDao.getAll();
	}

	@Override
	public void newUser(User user) {
		this.userDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		this.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		this.userDao.delete(user);
	}

	@Override
	public List<User> getUsersByUsername(String username) {
		return this.userDao.getByUsername(username);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
