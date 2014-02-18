package pentagon.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Meta {
	public static final String domain = "http://theeasytrip.com:8080/easytrip/";

	public static String replaceSpecial(String text) {
		text = text.replace("+", "%20");
		text = text.replace("*", "%2A");
		text = text.replace("_", "%5F");
		text = text.replace(".", "%2E");
		text = text.replace("-", "%2D");
		return text;
	}

	public static String getCookieValue(String key, HttpServletRequest request) {
		if (key == null || request == null) {
			return null;
		}

		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (key.equals(cookie.getName())) {
					value = cookie.getValue();
				}
			}
		}
		return value;
	}
}
