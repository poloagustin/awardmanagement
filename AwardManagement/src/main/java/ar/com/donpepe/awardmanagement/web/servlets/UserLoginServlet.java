package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.dtos.UserCredentialDto;

public class UserLoginServlet extends UserServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7376632047940534774L;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// request.getRequestDispatcher("/user/login.jsp").forward(request,
		// response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/login.jsp").forward(request,
				response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean loginFailed = true;
		if (username != null && password != null) {
			UserCredentialDto user = this.userService.getCredentials(username,
					password);
			if (user != null) {
				loginFailed = false;
				request.getSession().setAttribute("user", user);
			}
		}
		
		if (!loginFailed) {
			request.getRequestDispatcher("/home/index.jsp").forward(request, response);
		} else {
			this.doGet(request, response);
		}
	}
}
