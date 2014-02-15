package pentagon.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pentagon.model.User;

public class SetCookie implements Action {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			c.setValue(c.getValue() + "new");
		}
		
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "twresult.jsp";
		}

		if ("submit".equals(request.getParameter("add_cookie_btn"))) {
			String key = request.getParameter("key");
			String value = request.getParameter("value");
			if (key != null && !key.isEmpty() && value != null
					&& !value.isEmpty()) {
				Cookie cookie = new Cookie(key, value);
				cookie.setMaxAge(30 * 60);
				response.addCookie(cookie);
				request.setAttribute("result", "cookie set");
			}
		}
		return "twresult.jsp";
	}

	@Override
	public String getName() {
		return "add_cookie.do";
	}

}
