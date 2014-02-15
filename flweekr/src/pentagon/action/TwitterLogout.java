package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TwitterLogout implements Action {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		return "login.do";
	}

	@Override
	public String getName() {
		return "logout.do";
	}

}
