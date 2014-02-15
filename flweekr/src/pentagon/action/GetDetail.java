package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.oauth.OAuthService;

import pentagon.model.Model;
import pentagon.model.User;
import pentagon.sdk.FlickrAPI;
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
		
		String flickr_id = request.getParameter("flickr_id");
		if (flickr_id == null || flickr_id.isEmpty()) {
			return "search.do";
		}
		
		// get flickr api
		return "picture2.jsp";
	}

	@Override
	public String getName() {
		return "getplace.do";
	}

}
