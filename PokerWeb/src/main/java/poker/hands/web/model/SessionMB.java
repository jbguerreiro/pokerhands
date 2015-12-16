package poker.hands.web.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import lombok.Data;
import poker.hands.web.main.DefaultMB;

@SessionScoped
@ManagedBean(name = "sessionMB")
@Data
public class SessionMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{loginMB}")
	private DefaultMB loginMB;

	private String locale;

	public DefaultMB getLoginMB() {
		return loginMB;
	}

	public void setLoginMB(DefaultMB loginMB) {
		this.loginMB = loginMB;
		/*
		 * if (loginMB.getUser().getLanguage() != null) { switch
		 * (loginMB.getUser().getLanguage()) { case "PORTUGUES":
		 * FacesContext.getCurrentInstance().getViewRoot().setLocale(new
		 * Locale("pt", "BR")); break; case "INGLES":
		 * FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.
		 * ENGLISH); break; default:
		 * 
		 * FacesContext.getCurrentInstance().getViewRoot().setLocale(new
		 * Locale(loginMB.getUser().getLanguage())); } } else {
		 * FacesContext.getCurrentInstance().getViewRoot().setLocale(new
		 * Locale("pt", "BR")); }
		 */
		this.getLocale();
	}

}
