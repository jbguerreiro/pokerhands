package poker.hands.service.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;

import lombok.extern.log4j.Log4j;

@Log4j
public class LanguageUtil {

	// private static final String EN_DESCRIPTION_PROPERTIES=
	// "en.description.properties";
	private static String resourceBundleName;

	private static LanguageUtil instance = null;

	public static LanguageUtil getInstance(String locale) {
		loadNacionality(locale);
		instance = new LanguageUtil();
		return instance;
	}

	public static String getDescriptionProperties(String resourceBundleKey) throws MissingResourceException {
		Properties properties = new Properties();
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceBundleName);
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return (String) properties.get(resourceBundleKey);
	}

	private static void loadNacionality(String locale) {
		if (locale != null) {
			switch (locale) {
			case "pt_BR":
				resourceBundleName = "description_pt_BR.properties";
				break;
			case "en":
				resourceBundleName = "description_en.properties";
				break;
			default:
				resourceBundleName = "description_pt_BR.properties";
				break;
			}
		} else {
			resourceBundleName = "description_pt_BR.properties";
		}
	}
}
