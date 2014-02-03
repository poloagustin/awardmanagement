package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import ar.com.donpepe.awardmanagement.dtos.SaleReportDto;
import ar.com.donpepe.awardmanagement.services.SalesService;
import ar.com.donpepe.awardmanagement.web.helpers.WebHelper;

import com.google.gson.Gson;

/**
 * Servlet implementation class CommissionReportServlet
 */
@WebServlet("/CommissionReportServlet")
public class CommissionReportServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private SalesService salesService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommissionReportServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			this.salesService = (SalesService) WebHelper.getBean(config,
					"saleService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getRequestDispatcher("/commission/report.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String monthParam = request.getParameter("month");
			String yearParam = request.getParameter("year");
			String[] usersParam = request.getParameter("users").split(",");

			if (monthParam != "" && monthParam != null && yearParam != ""
					&& yearParam != null && usersParam != null) {
				Integer month = Integer.parseInt(monthParam);
				Integer year = Integer.parseInt(yearParam);
				List<Integer> userIds = new ArrayList<Integer>();
				for (String userParam : usersParam) {
					userIds.add(Integer.parseInt(userParam));
				}
				
				List<SaleReportDto> reportItems = this.salesService
						.getSalesReport(userIds, month, year);

				String reportItemsJson = new Gson().toJson(reportItems);

				response.getWriter().write(reportItemsJson);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
