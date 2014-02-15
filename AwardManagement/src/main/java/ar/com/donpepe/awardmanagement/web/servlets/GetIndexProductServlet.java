package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.com.donpepe.awardmanagement.dtos.ProductoIndexDto;

public class GetIndexProductServlet extends ProductServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9065533496158713490L;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ProductoIndexDto> products = new ArrayList<ProductoIndexDto>();
		
		try {
			
			products = this.productService.getProductIndex();
			String json = new Gson().toJson(products);
			response.getWriter().write(json);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
}
