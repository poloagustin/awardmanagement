package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.services.SalesService;
import ar.com.donpepe.awardmanagement.services.UserService;
import ar.com.donpepe.awardmanagement.web.helpers.WebHelper;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private SalesService salesService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.salesService = (SalesService)WebHelper.getBean(config, "salesService");
	}

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		List<ReportDto> dtos = this.salesService.getSalesReport(ids, period, year)
	}

}
