package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ar.com.donpepe.awardmanagement.dtos.SaleIndexDto;
import ar.com.donpepe.awardmanagement.dtos.UserCredentialDto;


public class SalesIndexServlet extends SalesServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2871787194058880288L;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/sale/index.jsp").forward(request,
				response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstDate = request.getParameter("dateFrom");
		String lastDate = request.getParameter("dateTo");
		UserCredentialDto salerMan = (UserCredentialDto)request.getSession().getAttribute("user");
		List<SaleIndexDto> sales = null;		

		try {

			// Parseamos las fecha
			Date dateTo = null;
			Date dateFrom = null;
		
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
			dateFrom = dateFormat.parse(firstDate);
			dateTo = dateFormat.parse(lastDate);

			Date newDateTo = null;
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateTo);
			cal.add(Calendar.DATE, +1);
			newDateTo = cal.getTime();

			sales = this.saleService.getSalesByPeriod(dateFrom, newDateTo,salerMan.getUserId());

			Boolean check = null;
			request.setAttribute("salesBean", sales);

			if (!sales.isEmpty()) {
				check = true;
			} else {
				check = false;
			}

			request.setAttribute("afterSaveBean", true);
			request.setAttribute("succesBean", check);			
			/*
			 * Save sets atribute from user
			 */			
			this.doGet(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
