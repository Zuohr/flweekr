package pentagon.action;

import javax.servlet.http.HttpServletRequest;

import org.scribe.oauth.OAuthService;

import pentagon.model.Model;
import pentagon.model.User;

public class TwitterSearch implements Action {
	private OAuthService service;
	
	public TwitterSearch(Model model) {
		this.service = model.getService();
	}
	
	@Override
	public String perform(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login.do";
		}

		if ("search_tweet".equals(request.getParameter("search_btn"))) {
			
		} else {
			return "twresult.jsp";
		}
		
		return null;
	}

	@Override
	public String getName() {
		return "search_tweet.do";
	}

}
