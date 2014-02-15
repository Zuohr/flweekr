package pentagon.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.scribe.oauth.OAuthService;

import pentagon.apibean.FlickrBean;
import pentagon.flickrbean.Photo;
import pentagon.model.Model;
import pentagon.model.User;
import pentagon.sdk.FlickrAPI;
import pentagon.sdk.TwitterAPI;
import pentagon.twitterbean.Oembed;
import pentagon.twitterbean.Status;



public class GetPlace implements Action {
	private Model model;
	private OAuthService service;

	public GetPlace(Model model){
		this.service = model.getService();

	}
	@Override
	public String perform(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login.do";
		}

			
			String keyword = "time square";
			if (keyword != null) {
				TwitterAPI twapi = new TwitterAPI(user.getAccessToken(),
						service);
				Status[] result = twapi.searchKeyWordOnly(keyword);
				Oembed[] oembeds = new Oembed[result.length];
				for (int i = 0; i < result.length; i++) {
					oembeds[i] = twapi.getOembed(result[i]);
				}
				request.setAttribute("oembeds_list", oembeds);
			}
			
			String pid = request.getParameter("photo_id");
			HashMap<String, String> map = (HashMap<String, String>) request.getSession().getAttribute("imgUrlMap");
			
			request.setAttribute("imgUrl", map.get(pid));
			
		
		return "picture2.jsp";
	}
		

	@Override
	public String getName() {
		return "getplace.do";
	}

}
