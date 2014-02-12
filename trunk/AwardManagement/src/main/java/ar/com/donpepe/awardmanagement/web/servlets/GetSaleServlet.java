/**
 * 
 */
package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.com.donpepe.awardmanagement.dtos.SaleDto;

/**
 * @author Fernando
 *
 */
public class GetSaleServlet extends SalesServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8305494790887897209L;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SaleDto sale = new SaleDto();
		
		try {
			String salenumber = request.getParameter("number");
			sale = this.saleService.getSaleByNumber(salenumber);
			String json = new Gson().toJson(sale);
			response.getWriter().write(json);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
