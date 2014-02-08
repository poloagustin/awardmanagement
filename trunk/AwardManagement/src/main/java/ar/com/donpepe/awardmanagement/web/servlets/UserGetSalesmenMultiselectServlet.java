package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.com.donpepe.awardmanagement.dtos.*;

public class UserGetSalesmenMultiselectServlet extends UserServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8697280360144421623L;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			List<KeyValueDto> result = this.userService.getSalesmenKeyValues();
			String json = new Gson().toJson(result);
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
