/**
 * 
 */
package ar.com.donpepe.awardmanagement.web.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import ar.com.donpepe.awardmanagement.services.ProductService;
import ar.com.donpepe.awardmanagement.web.helpers.WebHelper;

/**
 * @author Fernando
 *
 */
public abstract class ProductServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4111547262275856078L;
	protected ProductService productService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.productService = (ProductService) WebHelper.getBean(config,
				"productService");
	}

}
