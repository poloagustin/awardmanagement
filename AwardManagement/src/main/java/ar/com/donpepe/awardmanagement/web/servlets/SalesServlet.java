package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.services.SalesService;
import ar.com.donpepe.awardmanagement.services.UserService;
import ar.com.donpepe.awardmanagement.web.servlets.helpers.ServletHelper;

public abstract class SalesServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7850525604995169511L;
	
	protected SalesService saleService;
	protected UserService userService;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.saleService = (SalesService)ServletHelper.getBean(config,"saleService");
		this.userService = (UserService)ServletHelper.getBean(config,"userService");
	}

	
	
}
