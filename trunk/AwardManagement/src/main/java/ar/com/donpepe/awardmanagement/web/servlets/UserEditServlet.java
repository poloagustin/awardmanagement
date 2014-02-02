package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.dtos.UserDto;

public class UserEditServlet extends UserServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8824535506240267663L;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDto dto = new UserDto();
			String userId = request.getParameter("id");
			Integer id = Integer.parseInt(userId);
			String username = request.getParameter("username");
			if (username != null) {
				dto.setDni(request.getParameter("dni"));
				dto.setFirstName(request.getParameter("firstName"));
				dto.setId(id);
				dto.setLastName(request.getParameter("lastName"));
				dto.setPassword(request.getParameter("password"));
				dto.setRole(request.getParameter("role"));
				dto.setUserName(username);

				Boolean success = this.userService.updateUser(dto);

				request.setAttribute("afterSaveBean", true);
				request.setAttribute("successBean", success);
			}

			UserDto user = this.userService.getById(id);
			request.setAttribute("userBean", user);
			request.getRequestDispatcher("/user/edit.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
