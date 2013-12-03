package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.domain.SaleCommission;
import ar.com.donpepe.awardmanagement.dtos.SaleCommissionDto;

public class CommissionIndexServlet extends SaleCommissionServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3893301125710184379L;

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
//		List<String> roles = this.userService.getRoles();
//		request.setAttribute("rolesBean", roles);
		List<SaleCommission> commissions = this.saleCommissionService.getAll();
		req.setAttribute("commissions", commissions);
		
		req.getRequestDispatcher("/commission/index.jsp").forward(req, resp);
	}



	@Override
	protected void doPost(HttpServletRequest req,
		HttpServletResponse resp) throws ServletException, IOException {
//		Integer maximumSalesAmount = Integer.parseInt(req.getParameter("maximumSalesAmount"));
//		Integer minimumSalesAmount = Integer.parseInt(req.getParameter("minimumSalesAmount"));
//		Float saleCommission = Float.parseFloat(req.getParameter("saleCommission"));
//		
//		SaleCommissionDto sc = new SaleCommissionDto();
//		sc.setMaximumSalesAmount(maximumSalesAmount);
//		sc.setMinimumSalesAmount(minimumSalesAmount);
//		sc.setSaleCommission(saleCommission);
//		
//		Integer id = this.saleCommissionService.newSaleCommission(sc);
//		req.setAttribute("afterSaveBean", true);
//		req.setAttribute("successBean", id != null);
//		
		List<SaleCommission> commissions = this.saleCommissionService.getAll();
		req.setAttribute("commissions", commissions);
		
		req.getRequestDispatcher("/commission/index.jsp").forward(req, resp);
			
	}




	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
