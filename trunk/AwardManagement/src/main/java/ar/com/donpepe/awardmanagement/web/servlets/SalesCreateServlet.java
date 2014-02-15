package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ar.com.donpepe.awardmanagement.dtos.SaleDto;
import ar.com.donpepe.awardmanagement.dtos.SaleItemDto;
import ar.com.donpepe.awardmanagement.dtos.UserCredentialDto;

public class SalesCreateServlet extends SalesServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2992374604900630184L;

	/**
	 * 
	 */
	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub			
		UserCredentialDto user = (UserCredentialDto) request.getSession().getAttribute("user");

		// get current date time with Date()
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateSale = dateFormat.format(cal.getTime());
		
		request.setAttribute("dateBean", dateSale);
		request.setAttribute("UsersBean", user);
		request.getRequestDispatcher("/sale/create.jsp").forward(request,
				response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserCredentialDto salerMan = (UserCredentialDto)request.getSession().getAttribute("user");
		String number = request.getParameter("txtNumberSale");
		//String dateSale = request.getParameter("dateSale");
		List<String[]> paramsProd = new ArrayList<String[]>();
		boolean prodEnded = false;
		Integer i = 0;
		SaleDto sale = new SaleDto();

		while (!prodEnded) {
			String prod = request.getParameter("prod" + i.toString());
			String cant = request.getParameter("cant" + i.toString());
			if (prod != null && cant != null) {
				paramsProd.add(new String[] { prod, cant });
				i++;
			} else {
				prodEnded = true;
			}
		}

		try {

			// Parse Date from Sale
		
			// get current date time with Date()
			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String dateSale = dateFormat.format(cal.getTime());
			Date date = dateFormat.parse(dateSale);

			//Insert Atributes
			sale.setNumber(number);
			sale.setSalesmanId(salerMan.getUserId());
			sale.setDate(date);
			
			//Insert SaleItems to Sale
			List<SaleItemDto> items = new ArrayList<SaleItemDto>();

			for (String[] strings : paramsProd) {
				SaleItemDto dto = new SaleItemDto();
				dto.setProductId(Integer.parseInt(strings[0]));
				dto.setAmount(Integer.parseInt(strings[1]));
				items.add(dto);
			}
			
			sale.setSaleItems(items);
			/*
			 * Save Sale
			 */
			Boolean check = this.saleService.addSale(sale);
				
			request.setAttribute("afterSaveBean", true);
			request.setAttribute("succesBean", check);

			this.doGet(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
