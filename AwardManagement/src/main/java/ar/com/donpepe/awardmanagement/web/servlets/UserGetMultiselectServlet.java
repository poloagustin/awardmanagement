package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.com.donpepe.awardmanagement.dtos.KeyValueDto;

public class UserGetMultiselectServlet extends UserServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3475866215680060623L;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			List<KeyValueDto> users = this.userService.getKeyValues();
			String json = new Gson().toJson(users);
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
