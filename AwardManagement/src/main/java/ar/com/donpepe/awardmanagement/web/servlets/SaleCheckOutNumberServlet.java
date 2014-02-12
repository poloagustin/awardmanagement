/**
 * 
 */
package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 * @author Fernando
 *
 */
public class SaleCheckOutNumberServlet extends SalesServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5774885414036420658L;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean check = null;
		try {
			String saleNumber = request.getParameter("number");
			check = this.saleService.verifySaleNumber(saleNumber);
			String json = new Gson().toJson(check);
			response.getWriter().write(json);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
