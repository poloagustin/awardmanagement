package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserIndexServlet extends UserServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5250065469548655862L;
	
	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getRequestDispatcher("/user/index.jsp").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
