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
import javax.servlet.http.HttpSession;

//import org.apache.catalina.Session;

//import ar.com.donpepe.awardmanagement.domain.User;
import ar.com.donpepe.awardmanagement.dtos.ProductoIndexDto;
import ar.com.donpepe.awardmanagement.dtos.SaleDto;
import ar.com.donpepe.awardmanagement.dtos.SaleItemDto;
import ar.com.donpepe.awardmanagement.dtos.UserDto;
import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;

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
		List<UserIndexDto> users = new ArrayList<UserIndexDto>();
		List<ProductoIndexDto> products = new ArrayList<ProductoIndexDto>();

		users = this.userService.getSalerMan();
		products = this.productService.getProductIndex();

		// get current date time with Date()
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateSale = dateFormat.format(cal.getTime());
		
		HttpSession session = request.getSession(true);
		session.setAttribute("txtNumberSaleSave", " ");

		request.setAttribute("dateBean", dateSale);
		request.setAttribute("UsersBean", users);
		request.setAttribute("ProductsBean", products);

		request.getRequestDispatcher("/sale/create.jsp").forward(request,
				response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String saler = request.getParameter("salerman");
		String number = request.getParameter("txtNumberSale");
		String dateSale = request.getParameter("dateSale");
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

			// insertamos fecha de creacion de venta
			
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = dateFormat.parse(dateSale);
			// fin

			sale.setNumber(number);
			sale.setSalesmanId(Integer.parseInt(saler));
			sale.setDate(date);
			List<SaleItemDto> items = new ArrayList<SaleItemDto>();

			for (String[] strings : paramsProd) {
				SaleItemDto dto = new SaleItemDto();
				dto.setProductId(Integer.parseInt(strings[0]));
				dto.setAmount(Integer.parseInt(strings[1]));
				items.add(dto);
			}
			sale.setSaleItems(items);
			boolean check = false;

			/*
			 * Verifico que no exita una venta registrada
			 */
			if (this.saleService.verifySaleNumber(number)) {
				check = this.saleService.addSale(sale);
				System.out.println(check);
			} else {

				SaleDto saleExist = this.saleService.getSaleByNumber(number);
				UserDto salerMan = this.userService.getById(saleExist.getSalesmanId());
				request.setAttribute("SaleBean", saleExist);
				request.setAttribute("SalerManExist", salerMan);

				HttpSession session = request.getSession(true);
				session.setAttribute("txtNumberSaleSave", number);
				session.setAttribute("paramsProd", paramsProd);

			}
			
			request.setAttribute("afterSaveBean", true);
			request.setAttribute("succesBean", check);

			this.doGet(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
