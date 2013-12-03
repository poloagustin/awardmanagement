package ar.com.donpepe.awardmanagement.services.impl;

import java.util.ArrayList;
import java.util.List;

import ar.com.donpepe.awardmanagement.daos.UserDao;
import ar.com.donpepe.awardmanagement.domain.Role;
import ar.com.donpepe.awardmanagement.domain.User;
import ar.com.donpepe.awardmanagement.dtos.UserCredentialDto;
import ar.com.donpepe.awardmanagement.dtos.UserDto;
import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;
import ar.com.donpepe.awardmanagement.services.UserService;
import ar.com.donpepe.awardmanagement.services.mappers.UserMapper;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<UserIndexDto> getIndex() {
		List<User> users = this.userDao.getAll();
		List<UserIndexDto> dtos = new ArrayList<UserIndexDto>();

		for (User user : users) {
			dtos.add(UserMapper.getUserIndexDto(user));
		}

		return dtos;
	}

	@Override
	public Integer newUser(UserDto user) {
		Integer result = null;
		try {
			Integer id = this.userDao.save(UserMapper.getUser(user));
			result = id;
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	@Override
	public Boolean updateUser(UserDto user) {
		Boolean success = false;
		try {
			this.userDao.update(UserMapper.getUser(user));;
			success = true;
		} catch (Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	public Boolean deleteUser(UserDto user) {
		Boolean success = false;
		try {
			User u = this.userDao.get(user.getId());
			this.userDao.delete(u);
			success = true;
		} catch (Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	public List<UserIndexDto> getUsersByUsername(String username) {
		List<User> users = this.userDao.getByUsername(username);
		List<UserIndexDto> dtos = new ArrayList<UserIndexDto>();

		for (User user : users) {
			dtos.add(UserMapper.getUserIndexDto(user));
		}

		return dtos;
	}

	@Override
	public List<String> getRoles() {
		Role[] roles = Role.values();
		List<String> values = new ArrayList<String>();

		for (Role role : roles) {
			values.add(UserMapper.getRoleAsString(role));
		}

		return values;
	}

	@Override
	public UserDto getById(Integer id) {
		UserDto user = new UserDto();
		
		try {
			User u =this.userDao.get(id);
			user = UserMapper.getUserFormDto(u);
		} catch (Exception e) {
			user = null;
		}
		
		return user;
	}

	@Override
	public UserCredentialDto getCredentials(String username, String password) {
		User user = this.userDao.getByUsernameAndPassword(username, password);
		UserCredentialDto credential = null;
		if (user != null) {
			credential = UserMapper.getCredentialDto(user);
		}
		return credential;
	}

@Override
	public List<UserIndexDto> getSalerMan() {
		// TODO Auto-generated method stub
		List<UserIndexDto> usersDto = new ArrayList<UserIndexDto>();
		List<User>  users = null;
		try {
			users = this.userDao.getUsersSalerMans();
			
			for (User user : users) {
				if (user!=null) {
					usersDto.add(UserMapper.getUserIndexDto(user));	
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return usersDto;
	}
}
