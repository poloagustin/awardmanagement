package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;

import com.google.gson.*;

public class GetUsersServlet extends UserServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8277480079214312734L;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<UserIndexDto> users = this.userService.getIndex();
		String json = new Gson().toJson(users);
		response.getWriter().write(json);
	}

}
