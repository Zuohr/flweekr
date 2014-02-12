package pentagon.action;

import javax.servlet.http.HttpServletRequest;

import org.scribe.oauth.OAuthService;

import pentagon.model.Model;
import pentagon.model.User;
import pentagon.sdk.TwitterAPI;
import pentagon.twitterbean.Status;

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
			String keyword = request.getParameter("keyword");
			if (keyword != null) {
				TwitterAPI twapi = new TwitterAPI(user.getAccessToken(),
						service);
				Status[] result = twapi.search(keyword);
				request.setAttribute("result_list", result);
			}
		}
		return "twresult.jsp";
	}

	@Override
	public String getName() {
		return "search_tweet.do";
	}

}
