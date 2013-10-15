package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;

public class UserEditServlet extends UserServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8824535506240267663L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		if (userId == "" || userId == null) {
			List<UserIndexDto> users = this.userService.getIndex();
			request.setAttribute("users", users);
			request.getRequestDispatcher("/user/index.jsp").forward(request, response);
		}
	}

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Do nothing
	}
}
