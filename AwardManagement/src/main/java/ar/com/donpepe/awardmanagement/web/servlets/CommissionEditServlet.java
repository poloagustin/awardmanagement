package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(req.getParameter("inputIdCommission"));
			SaleCommission sc = this.saleCommissionService.getById(id);
			req.setAttribute("commission", sc);

			req.getRequestDispatcher("/commission/list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		boolean save = false;
		String error = "";
		
		try {
			Integer id = Integer.parseInt(req.getParameter("inputIdCommission"));
			Float saleCommission = Float.parseFloat(req
					.getParameter("saleCommission"));
			
					
			
			SaleCommission sc = this.saleCommissionService.getById(id);

			if (saleCommission != null && saleCommission > 0) {
				sc.setSaleCommission(saleCommission);
				SaleCommissionDto scDto = new SaleCommissionDto();

				scDto.setId(id);
				scDto.setMaximumSalesAmount(sc.getMaximumSalesAmount());
				scDto.setMinimumSalesAmount(sc.getMinimumSalesAmount());
				scDto.setSaleCommission(saleCommission);

				save = this.saleCommissionService.updateSaleCommission(scDto);
				req.setAttribute("commission", sc);
				req.setAttribute("afterSaveBean", true);
				req.setAttribute("successBean", save == true);
				
			}else{
				error = "No se admiten valores negativos o nulos.";
				req.setAttribute("afterSaveBean", true);
				req.setAttribute("successBean", save);
				req.setAttribute("error", error);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			error = "El valor ingresado debe ser numérico.";
			req.setAttribute("afterSaveBean", true);
			req.setAttribute("successBean", save);
			req.setAttribute("error", error);
		}
		
		List<SaleCommission> commissions = this.saleCommissionService
				.getAll();
		req.setAttribute("commissions", commissions);
		
		req.getRequestDispatcher("/commission/list.jsp").forward(req, resp);
	}

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
