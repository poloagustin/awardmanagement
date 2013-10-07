package ar.com.donpepe.awardmanagement.services;

import java.util.List;

import ar.com.donpepe.awardmanagement.domain.User;

public interface UserService {
	List<User> getAll();
	void newUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	List<User> getUsersByUsername(String username);
}
