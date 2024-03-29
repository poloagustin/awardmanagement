package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.services.ProductService;
import ar.com.donpepe.awardmanagement.services.SalesService;
import ar.com.donpepe.awardmanagement.services.UserService;
import ar.com.donpepe.awardmanagement.web.helpers.WebHelper;

public abstract class SalesServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7850525604995169511L;
	
	protected SalesService saleService;
	protected UserService userService;
	protected ProductService productService;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			this.saleService = (SalesService)WebHelper.getBean(config,"saleService");
			this.userService = (UserService)WebHelper.getBean(config,"userService");
			this.productService = (ProductService)WebHelper.getBean(config,"productService");
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}	
}
