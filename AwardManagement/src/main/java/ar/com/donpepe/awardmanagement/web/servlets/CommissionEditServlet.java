package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.domain.SaleCommission;
import ar.com.donpepe.awardmanagement.dtos.SaleCommissionDto;

public class CommissionEditServlet extends SaleCommissionServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1137720204888366318L;



	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		SaleCommission sc = this.saleCommissionService.getById(id);
		req.setAttribute("commission", sc);
				
		req.getRequestDispatcher("/commission/edit.jsp").forward(req,
				resp);
	}



	@Override
	protected void doPost(HttpServletRequest req,
		HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		Float saleCommission = Float.parseFloat(req.getParameter("saleCommission"));
		boolean save = false;
		SaleCommission sc = this.saleCommissionService.getById(id);
		
		if (saleCommission != null){
			
		sc.setSaleCommission(saleCommission);
		SaleCommissionDto scDto = new SaleCommissionDto();
		
		scDto.setId(id);
		scDto.setMaximumSalesAmount(sc.getMaximumSalesAmount());
		scDto.setMinimumSalesAmount(sc.getMinimumSalesAmount());
		scDto.setSaleCommission(saleCommission);
		
		
		save = this.saleCommissionService.updateSaleCommission(scDto);
		}
		
		
		req.setAttribute("commission", sc);
		req.setAttribute("afterSaveBean", true);
		req.setAttribute("successBean", save == true);
		
		req.getRequestDispatcher("/commission/edit.jsp").forward(req,
				resp);
			
	}



	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//Do nothing 
		}

}
