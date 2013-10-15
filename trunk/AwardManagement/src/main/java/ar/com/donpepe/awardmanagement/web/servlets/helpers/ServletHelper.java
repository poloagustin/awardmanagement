package ar.com.donpepe.awardmanagement.web.servlets.helpers;

import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ServletHelper {
	public static Object getBean(ServletConfig config, String beanName) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		return ctx.getBean(beanName);
	}
}
