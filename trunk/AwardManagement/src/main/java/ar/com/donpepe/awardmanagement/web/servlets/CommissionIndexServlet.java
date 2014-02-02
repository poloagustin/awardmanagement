package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.domain.SaleCommission;

public class CommissionIndexServlet extends SaleCommissionServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3893301125710184379L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			List<SaleCommission> commissions = this.saleCommissionService
					.getAll();
			req.setAttribute("commissions", commissions);

			req.getRequestDispatcher("/commission/index.jsp")
					.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			List<SaleCommission> commissions = this.saleCommissionService
					.getAll();
			req.setAttribute("commissions", commissions);

			req.getRequestDispatcher("/commission/index.jsp")
					.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
