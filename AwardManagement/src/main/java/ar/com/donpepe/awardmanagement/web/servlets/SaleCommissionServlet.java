package ar.com.donpepe.awardmanagement.web.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import ar.com.donpepe.awardmanagement.services.SaleCommissionService;
import ar.com.donpepe.awardmanagement.services.UserService;
import ar.com.donpepe.awardmanagement.web.helpers.WebHelper;

public abstract class SaleCommissionServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8095527817084266702L;

	protected SaleCommissionService saleCommissionService;
	protected UserService userService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.saleCommissionService = (SaleCommissionService)WebHelper.getBean(config, "saleCommissionService");
	}	
	
		
}
