package poker.hands.web.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class HttpSessionUtil {

	private HttpSessionUtil() {

	}

	public static HttpSession getHttpSession() {
		return getHttpSession(false);
	}

	public static HttpSession getHttpSession(boolean create) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return (HttpSession) externalContext.getSession(create);
	}

}
