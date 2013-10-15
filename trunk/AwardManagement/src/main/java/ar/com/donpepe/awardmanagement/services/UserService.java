package ar.com.donpepe.awardmanagement.services;

import java.util.List;

import ar.com.donpepe.awardmanagement.dtos.UserDto;
import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;

public interface UserService {
	List<UserIndexDto> getIndex();
	Boolean newUser(UserDto user);
	Boolean updateUser(UserDto user);
	Boolean deleteUser(UserDto user);
	List<UserIndexDto> getUsersByUsername(String username);
	List<String> getRoles();
}
