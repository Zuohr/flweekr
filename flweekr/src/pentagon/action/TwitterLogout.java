package pentagon.action;

import javax.servlet.http.HttpServletRequest;

public class TwitterLogout implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "login.tw";
	}

	@Override
	public String getName() {
		return "logout.tw";
	}

}
