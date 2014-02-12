/**
 * 
 */
package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.com.donpepe.awardmanagement.dtos.SaleDto;

import ar.com.donpepe.awardmanagement.dtos.UserDto;

/**
 * @author Fernando
 *
 */
public class GetSalerManServlet extends SalesServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -574086340221072646L;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDto user = new UserDto();
		SaleDto sale = new SaleDto();
		try {
			String salenumber = request.getParameter("number");
			sale = this.saleService.getSaleByNumber(salenumber);
			user = this.userService.getById(sale.getSalesmanId());
			List<String> list = new ArrayList<String>(); 
			
			list.add(user.getFirstName());
			list.add(user.getLastName());
			list.add(sale.getDate().toString());
			
			String json = new Gson().toJson(list);
			response.getWriter().write(json);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	

}
