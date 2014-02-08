package ar.com.donpepe.awardmanagement.services;

import java.util.List;

import ar.com.donpepe.awardmanagement.dtos.KeyValueDto;
import ar.com.donpepe.awardmanagement.dtos.UserDto;
import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;
import ar.com.donpepe.awardmanagement.dtos.UserCredentialDto;

public interface UserService {
	List<UserIndexDto> getIndex();
	Integer newUser(UserDto user);
	Boolean updateUser(UserDto user);
	Boolean deleteUser(UserDto user);
	List<UserIndexDto> getUsersByUsername(String username);
	List<String> getRoles();
	UserDto getById(Integer id);
	UserCredentialDto getCredentials(String username, String password);
	List<UserIndexDto> getSalerMan();
	List<KeyValueDto> getKeyValues();
	List<KeyValueDto> getSalesmenKeyValues();
}
