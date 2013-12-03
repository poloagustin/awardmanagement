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

import ar.com.donpepe.awardmanagement.dtos.SaleIndexDto;
import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;

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
		List<UserIndexDto> users = null;
		users = this.userService.getSalerMan();
		request.setAttribute("UsersBean", users);
		request.getRequestDispatcher("/sale/index.jsp").forward(request,
				response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstDate = request.getParameter("dateFrom");
		String lastDate = request.getParameter("dateTo");
		String salerMan = request.getParameter("salerMan");
		List<SaleIndexDto> sales = null;

		try {
			
		// paresamos fecha
		Date dateFrom = new Date();
		Date dateTo = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String firstDateFormated = dateFormat.format(new Date());
		String lastDateFormated = dateFormat.format(new Date());
		
		dateFrom = dateFormat.parse(firstDateFormated);
		dateTo = dateFormat.parse(lastDateFormated);
		
		Integer userId = new Integer(salerMan);
		
		sales = this.saleService.getSalesByPeriod(dateFrom, dateTo, userId);
		
		boolean check = false;
		
		if (sales !=null) {
			request.setAttribute("salesBean", sales);
			check = true;
		}
		
		request.setAttribute("afterSaveBean", true);
		request.setAttribute("succesBean", check);

		this.doGet(request, response);

		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
