package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.oauth.OAuthService;

import pentagon.model.Model;
import pentagon.model.User;
import pentagon.sdk.TwitterAPI;
import pentagon.twitterbean.Oembed;
import pentagon.twitterbean.Status;

public class GetDetail implements Action {
	private OAuthService service;

	public GetDetail(Model model) {
		this.service = model.getService();

	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login.do";
		}
		System.out.println("sd");
		// String keyword = request.getParameter("keyword");
		String keyword = "time square";
		if (keyword != null) {
			TwitterAPI twapi = new TwitterAPI(user.getAccessToken(), service);
			Status[] result = twapi.searchKeyWordOnly(keyword);
			Oembed[] oembeds = new Oembed[result.length];
			for (int i = 0; i < result.length; i++) {
				oembeds[i] = twapi.getOembed(result[i]);
			}
			request.setAttribute("oembeds_list", oembeds);
		}

		return "picture2.jsp";
	}

	@Override
	public String getName() {
		return "getplace.do";
	}

}
