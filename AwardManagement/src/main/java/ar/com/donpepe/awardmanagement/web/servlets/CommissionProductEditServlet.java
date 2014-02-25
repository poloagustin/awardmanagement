package ar.com.donpepe.awardmanagement.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.donpepe.awardmanagement.domain.Product;
import ar.com.donpepe.awardmanagement.dtos.ProductDto;

public class CommissionProductEditServlet extends ProductServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1137720204888366318L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean save = false;
		String error = "";

		try {
			Integer id = Integer.parseInt(req
					.getParameter("inputIdProductCommission"));
			Float productCommission = Float.parseFloat(req
					.getParameter("productCommission"));

			ProductDto p = this.productService.getProductById(id);

			if (productCommission != null && productCommission > 0) {

				if (Float.compare(p.getSaleCommission(), productCommission) == 0) {
					error = "La comisión ingresada no puede ser la misma.";
					req.setAttribute("afterSaveBean", true);
					req.setAttribute("successBean", save);
					req.setAttribute("error", error);
				} else {
					p.setSaleCommission(productCommission);

					save = this.productService.updateProduct(p);

					req.setAttribute("producto", p);
					req.setAttribute("afterSaveBean", true);
					req.setAttribute("successBean", save == true);
				}
			} else {
				error = "No se admiten valores negativos o nulos.";
				req.setAttribute("afterSaveBean", true);
				req.setAttribute("successBean", save);
				req.setAttribute("error", error);
			}

		} catch (Exception e) {
			e.printStackTrace();
			error = "El valor ingresado debe ser numérico.";
			req.setAttribute("afterSaveBean", true);
			req.setAttribute("successBean", save);
			req.setAttribute("error", error);
		}

		List<Product> productos = this.productService.getAll();
		req.setAttribute("productos", productos);

		req.getRequestDispatcher("/commission/listproducts.jsp").forward(req,
				resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		boolean save = false;
		String error = "";

		try {
			Integer id = Integer.parseInt(req
					.getParameter("inputIdProductCommission"));
			Float productCommission = Float.parseFloat(req
					.getParameter("productCommission"));

			ProductDto p = this.productService.getProductById(id);

			if (productCommission != null && productCommission > 0) {

				if (Float.compare(p.getSaleCommission(), productCommission) == 0) {
					error = "La comisión ingresada no puede ser la misma.";
					req.setAttribute("afterSaveBean", true);
					req.setAttribute("successBean", save);
					req.setAttribute("error", error);
				} else {

					p.setSaleCommission(productCommission);
					save = this.productService.updateProduct(p);
					req.setAttribute("producto", p);
					req.setAttribute("afterSaveBean", true);
					req.setAttribute("successBean", save == true);
				}
			} else {
				error = "No se admiten valores negativos o nulos.";
				req.setAttribute("afterSaveBean", true);
				req.setAttribute("successBean", save);
				req.setAttribute("error", error);
			}

		} catch (Exception e) {
			e.printStackTrace();
			error = "El valor ingresado debe ser numérico.";
			req.setAttribute("afterSaveBean", true);
			req.setAttribute("successBean", save);
			req.setAttribute("error", error);
		}

		List<Product> productos = this.productService.getAll();
		req.setAttribute("productos", productos);

		req.getRequestDispatcher("/commission/listproducts.jsp").forward(req,
				resp);
	}

	@Override
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
