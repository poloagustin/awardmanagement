package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import ar.com.donpepe.awardmanagement.dtos.UserDto;
import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;

public class UserIndexServlet extends UserServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5250065469548655862L;
	
	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<UserIndexDto> users = super.userService.getIndex();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/user/index.jsp").forward(request, response);
	}
}
