package pentagon.action;

import javax.servlet.http.HttpServletRequest;

import org.scribe.oauth.OAuthService;

import pentagon.flickrbean.Photo;
import pentagon.model.Model;
import pentagon.model.User;
import pentagon.sdk.TwitterAPI;
import pentagon.twitterbean.Oembed;

public class TwitterSearchByCoordination implements Action {
	private Model model;
	private OAuthService service;

	public TwitterSearchByCoordination(Model model) {
		this.model = model;
		this.service = model.getService();
	}

	@Override
	public String perform(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "twlogin.jsp";
		}

		if ("searchloc_tweet".equals(request.getParameter("searchloc_btn"))) {
			String keyword = request.getParameter("keyword");
			if (keyword != null) {
				TwitterAPI api = new TwitterAPI(user.getAccessToken(), service);
				Photo photo = new Photo();
				photo.latitude = "37.781";
				photo.longitude = "-122.398";
				Oembed[] oembedList = api.getOembeds(api.searchByCoordination(
						photo, keyword));
				if (oembedList.length > 0) {
					request.setAttribute("oembeds_list", oembedList);
				} else {
					request.setAttribute("result", "no result");
				}
			}
		}
		return "twresult.jsp";
	}

	@Override
	public String getName() {
		return "search_tweet_byloc.do";
	}

}
