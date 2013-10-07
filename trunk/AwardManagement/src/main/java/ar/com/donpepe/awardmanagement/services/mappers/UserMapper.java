package ar.com.donpepe.awardmanagement.services.mappers;

import ar.com.donpepe.awardmanagement.domain.Role;
import ar.com.donpepe.awardmanagement.domain.User;
import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;

public class UserMapper {
	public static UserIndexDto getUserIndexDto(User user) {
		UserIndexDto dto = new UserIndexDto();
		dto.setDni(user.getDni());
		dto.setFirstName(user.getFullName());
		dto.setLastName(user.getLastName());
		dto.setRole(getRoleAsString(user.getRole()));
		dto.setUsername(user.getUsername());
		return dto;
	}

	private static String getRoleAsString(Role role) {
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
	
	private static Role getRoleAsEnum(String role) {
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
}
