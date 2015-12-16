package poker.hands.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class AutowiredHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 2366480041978767142L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		autowire();
	}

	private void autowire() {
		ServletContext servletContext = getServletContext();
		ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		AutowireCapableBeanFactory factory = appContext.getAutowireCapableBeanFactory();
		factory.autowireBean(this);
	}
}
