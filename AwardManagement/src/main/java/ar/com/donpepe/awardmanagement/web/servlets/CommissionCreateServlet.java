package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.dtos.SaleCommissionDto;

public class CommissionCreateServlet extends SaleCommissionServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8271470663941149494L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getRequestDispatcher("/commission/create.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Integer maximumSalesAmount = Integer.parseInt(req
					.getParameter("maximumSalesAmount"));
			Integer minimumSalesAmount = Integer.parseInt(req
					.getParameter("minimumSalesAmount"));
			Float saleCommission = Float.parseFloat(req
					.getParameter("saleCommission"));

			SaleCommissionDto sc = new SaleCommissionDto();
			sc.setMaximumSalesAmount(maximumSalesAmount);
			sc.setMinimumSalesAmount(minimumSalesAmount);
			sc.setSaleCommission(saleCommission);

			Integer id = this.saleCommissionService.newSaleCommission(sc);
			req.setAttribute("afterSaveBean", true);
			req.setAttribute("successBean", id != null);

			this.doGet(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
