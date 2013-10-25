package ar.com.donpepe.awardmanagement.web.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import ar.com.donpepe.awardmanagement.services.UserService;
import ar.com.donpepe.awardmanagement.web.helpers.WebHelper;

public abstract class UserServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4052365037469132107L;

	protected UserService userService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.userService = (UserService)WebHelper.getBean(config, "userService");
	}	
}
