package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.dtos.ProductDto;
import ar.com.donpepe.awardmanagement.dtos.ProductoIndexDto;
import ar.com.donpepe.awardmanagement.services.ProductService;

public class ProductServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -168287285418817717L;
	
	private ProductService productService;

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			List<ProductoIndexDto> products = new ArrayList<ProductoIndexDto>();
			products = this.productService.getProductIndex();
			request.setAttribute("productBean", products);
			request.getRequestDispatcher("/sale/AddSaleItem.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String product = request.getParameter("products");
			String cantProduct = request.getParameter("txtCantidad");
			
			if ((!product.isEmpty())&&(!cantProduct.isEmpty())) {
				
				try {
					
					ProductDto productDto = new ProductDto();
					Integer cant = new Integer(cantProduct);
					Integer productId = new Integer(product);
					productDto = this.productService.getProductById(productId);
					
					request.setAttribute("productBean", productDto);
					request.setAttribute("cantBean", cant);
					
					request.getRequestDispatcher("/sale/create").forward(request, response);
				} catch (Exception e) {				
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
