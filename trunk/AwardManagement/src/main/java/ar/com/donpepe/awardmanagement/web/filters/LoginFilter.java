package ar.com.donpepe.awardmanagement.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.donpepe.awardmanagement.dtos.UserCredentialDto;
import ar.com.donpepe.awardmanagement.utils.BaseLogger;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter extends BaseLogger<LoginFilter> implements Filter{
	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		this.logger.debug("Begin doFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		UserCredentialDto user = (UserCredentialDto)session.getAttribute("user");
		
		boolean doFilter = false;
		if (user == null) {
			this.logger.debug("User not logged.");
			String isLoginRequest = (String)req.getAttribute("isLoginRequest");
			String requestUri = req.getRequestURI();
			
//			if (isLoginRequest != "true") {
			if (!requestUri.contains("/user/login")) {
				this.logger.debug("Redirecting to login page.");
				req.setAttribute("isLoginRequest", "true");
				req.getRequestDispatcher("/user/login").forward(req, resp);
			} else {
				doFilter = true;
			}
		} else {
			this.logger.debug("The user is logged.");
			doFilter = true;
		}
		if (doFilter) {
			chain.doFilter(request, response);
		}
		this.logger.debug("end doFilter");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
