package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.dtos.UserDto;

public class UserDeleteServlet extends UserServlet {

	@Override
	protected void doAction(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("id");
		Integer id = null;
		try {
			id = Integer.parseInt(userId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (id != null) {
			UserDto user = new UserDto();
			user.setId(id);
			this.userService.deleteUser(user);
		}
		req.getRequestDispatcher("/user/index").forward(req, resp);
	}

}
