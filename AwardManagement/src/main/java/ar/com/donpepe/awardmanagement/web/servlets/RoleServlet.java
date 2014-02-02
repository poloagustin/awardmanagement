package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.com.donpepe.awardmanagement.services.UserService;
import ar.com.donpepe.awardmanagement.web.helpers.WebHelper;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	try {
			this.userService = (UserService)WebHelper.getBean(config, "userService");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<String> roles = this.userService.getRoles();
			String resp = new Gson().toJson(roles); 

			response.getWriter().write(resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
