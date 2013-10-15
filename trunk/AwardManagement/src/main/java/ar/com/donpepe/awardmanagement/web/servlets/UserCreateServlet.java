package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.dtos.UserDto;

public class UserCreateServlet extends UserServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7097259503173952341L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<String> roles = this.userService.getRoles();

		request.setAttribute("rolesBean", roles);
		request.getRequestDispatcher("/user/create.jsp").forward(request,
				response);
	}
	
	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Do nothing.
	}
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String password = req.getParameter("password");
		String dni = req.getParameter("dni");
		String role = req.getParameter("role");
				
		UserDto user = new UserDto();
		user.setDni(dni);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setRole(role);
		user.setUserName(username);
		
		Boolean success = this.userService.newUser(user);
		
		req.setAttribute("afterSaveBean", true);
		req.setAttribute("successBean", success);
		
		this.doGet(req, resp);
	}
}
