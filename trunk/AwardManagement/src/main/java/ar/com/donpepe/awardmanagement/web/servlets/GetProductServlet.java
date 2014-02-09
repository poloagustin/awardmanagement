package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.com.donpepe.awardmanagement.dtos.ProductDto;
import ar.com.donpepe.awardmanagement.dtos.ProductoIndexDto;

import ar.com.donpepe.awardmanagement.services.ProductService;
import ar.com.donpepe.awardmanagement.web.helpers.WebHelper;

public class GetProductServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6416828511992382456L;
	/**
	 * 
	 */

	protected ProductService productService;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		/*List<ProductoIndexDto> product = this.productService.getProductIndex();
		String json = new Gson().toJson(product);
		response.getWriter().write(json);*/
	String idProd = request.getParameter("idProd");
	if (idProd!=null) {
		Integer id = new Integer(idProd);
		ProductDto product = this.productService.getProductById(id);
		String json = new Gson().toJson(product);
		response.getWriter().write(json);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
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

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.productService = (ProductService) WebHelper.getBean(config,
				"productService");
	}

}
