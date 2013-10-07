package ar.com.donpepe.awardmanagement.web.servlets;

import ar.com.donpepe.awardmanagement.services.UserService;

public abstract class UserServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4052365037469132107L;
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
