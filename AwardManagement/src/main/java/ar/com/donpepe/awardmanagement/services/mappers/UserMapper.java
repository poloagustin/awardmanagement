package ar.com.donpepe.awardmanagement.services.mappers;

import ar.com.donpepe.awardmanagement.domain.Role;
import ar.com.donpepe.awardmanagement.domain.User;
import ar.com.donpepe.awardmanagement.dtos.KeyValueDto;
import ar.com.donpepe.awardmanagement.dtos.UserCredentialDto;
import ar.com.donpepe.awardmanagement.dtos.UserDto;
import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;

public class UserMapper {
	public static UserIndexDto getUserIndexDto(User user) {
		UserIndexDto dto = new UserIndexDto();
		dto.setId(user.getId());
		dto.setDni(user.getDni());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setRole(getRoleAsString(user.getRole()));
		dto.setUsername(user.getUsername());
		return dto;
	}
	
	public static User getUsersIndexDto(UserIndexDto users){
		User user = new User();
		user.setDni(users.getDni());
		user.setFirstName(users.getFirstName());
		user.setId(users.getId());
		user.setLastName(users.getLastName());
		user.setRole(UserMapper.getRoleAsEnum(users.getRole()));
		user.setUsername(users.getUsername());
		
		return user;
	}

	public static String getRoleAsString(Role role) {
		switch (role) {
			case ADMINISTRATOR:
				return "Administrador";
			case HHRR:
				return "RRHH";
			case SALESMAN:
				return "Vendedor";
			default:
				return "";
		}
	}
	
	public static Role getRoleAsEnum(String role) {
		switch (role) {
			case "Administrador":
				return Role.ADMINISTRATOR;
			case "RRHH":
				return Role.HHRR;
			case "Vendedor":
				return Role.SALESMAN;
			default:
				return null;
		}
	}

	public static User getUser(UserDto user) {
		User dom = new User();
		dom.setDni(user.getDni());
		dom.setFirstName(user.getFirstName());
		dom.setId(user.getId());
		dom.setLastName(user.getLastName());
		dom.setPassword(user.getPassword());
		dom.setRole(getRoleAsEnum(user.getRole()));
		dom.setUsername(user.getUserName());
		return dom;
	}

	public static UserDto getUserFormDto(User user) {
		UserDto dto = new UserDto();
		dto.setDni(user.getDni());
		dto.setFirstName(user.getFirstName());
		dto.setId(user.getId());
		dto.setLastName(user.getLastName());
		dto.setPassword(user.getPassword());
		dto.setRole(getRoleAsString(user.getRole()));
		dto.setUserName(user.getUsername());
		return dto;
	}
	public static UserCredentialDto getCredentialDto(User user) {
		UserCredentialDto credential = new UserCredentialDto();
		credential.setUserId(user.getId());
		credential.setUsername(user.getUsername());
		credential.setPassword(user.getPassword());
		credential.setRole(user.getRole().ordinal());
		
		return credential;
	}

	public static KeyValueDto getKeyValueDto(User user) {
		KeyValueDto keyValue = new KeyValueDto();
		keyValue.setKey(user.getId());
		keyValue.setValue(user.getFullName());
		return keyValue;
	}
}
