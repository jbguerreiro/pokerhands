package poker.hands.web.util;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import lombok.Data;
import poker.hands.service.util.LanguageUtil;

@ManagedBean(name = "languageMB")
@SessionScoped
@Data
public class LanguageMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private String language;
	// protected String localeCode;

	protected static Map<String, Object> countries;

	// private String localeCode;
	static {
		LanguageUtil.getInstance("pt_BR");

		countries = new LinkedHashMap<String, Object>();
		countries.put(LanguageUtil.getDescriptionProperties("pt_BR"),
				new Locale("pt_BR"));
		countries.put(LanguageUtil.getDescriptionProperties("en"), new Locale(
				"en"));
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	// value change event listener
	public void countryLocaleCodeChanged(ValueChangeEvent e) {
		String newLocaleValue = e.getNewValue().toString();
		// loop country map to compare the locale code
		for (Map.Entry<String, Object> entry : countries.entrySet()) {
			if (entry.getValue().toString().equals(newLocaleValue)) {
				FacesContext.getCurrentInstance().getViewRoot()
						.setLocale((Locale) entry.getValue());
			}
		}
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public static Map<String, Object> getCountries() {
		return countries;
	}

	public static void setCountries(Map<String, Object> countries) {
		LanguageMB.countries = countries;
	}
}