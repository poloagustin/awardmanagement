package ar.com.donpepe.awardmanagement.web.helpers;

import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebHelper {
	public static Object getBean(ServletConfig config, String beanName) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		return ctx.getBean(beanName);
	}

	public static Object getBean(FilterConfig config, String beanName) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		return ctx.getBean(beanName);
	}
}
