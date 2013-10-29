package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ar.com.donpepe.awardmanagement.domain.User;
import ar.com.donpepe.awardmanagement.dtos.SaleDto;
import ar.com.donpepe.awardmanagement.dtos.UserIndexDto;
import ar.com.donpepe.awardmanagement.services.mappers.UserMapper;

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
		request.setAttribute("usersBean", getSalerMans());
		request.getRequestDispatcher("/sale/create.jsp").forward(request,
				response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String saler = request.getParameter("salerman");
		String number = request.getParameter("txtNumberSale");
		String date = request.getParameter("datetime");

		if ((!saler.isEmpty()) && (!number.isEmpty()) && (!date.isEmpty())) {

			try {

				SaleDto sale = new SaleDto();
				
				// converting date
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");				
				Date nuevo = (Date)formatter.parse(date);
				
				// finding user
				List<UserIndexDto> users = null;
				users = this.userService.getUsersByUsername(saler);

				User user = new User();
				user = UserMapper.getUsersIndexDto(users.get(0));

				sale.setNumber(number);
				sale.setSalesMan(user);

				// check sale existent
				Boolean check = null;
				//this.saleService.verifySaleNumber(number);

				//if (!this.saleService.verifySaleNumber(number)) {
					check = this.saleService.addSale(sale);
				//}
				
				request.setAttribute("afterSaveBean", true);
				request.setAttribute("succesBean", check != null);

				this.doGet(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * Agrego los usuarios vendedores para mostrar despues
	 */
	public List<UserIndexDto> getSalerMans(){
		List<UserIndexDto> salerMans = new ArrayList<UserIndexDto>();
		List<UserIndexDto> users = this.userService.getIndex();
		
		for (UserIndexDto userIndexDto : users) {
			if (userIndexDto.getRole().equals("Vendedor"))
				salerMans.add(userIndexDto);
			}
		
		return salerMans;
	}
}
