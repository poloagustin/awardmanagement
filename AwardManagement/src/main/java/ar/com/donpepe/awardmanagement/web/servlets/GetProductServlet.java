package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import ar.com.donpepe.awardmanagement.dtos.ProductDto;

public class GetProductServlet extends ProductServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6416828511992382456L;
	/**
	 * 
	 */
	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idProd = request.getParameter("idProd");
		if (idProd!=null) {
			Integer id = new Integer(idProd);
			ProductDto product = this.productService.getProductById(id);
			String json = new Gson().toJson(product);
			response.getWriter().write(json);
			}
	}
}
