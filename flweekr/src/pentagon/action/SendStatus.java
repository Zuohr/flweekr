package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import pentagon.model.Model;
import pentagon.model.User;
import pentagon.sdk.TwitterAPI;
import pentagon.twitterbean.Oembed;
import pentagon.twitterbean.Status;

public class SendStatus implements Action {
	private OAuthService service;

	public SendStatus(Model model) {
		service = model.getService();
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "homepage.jsp";
		}

		String text = request.getParameter("text");
		if (text != null && text.length() > 0) {
			Token accessToken = user.getAccessToken();
			if (accessToken != null) {
				TwitterAPI api = new TwitterAPI(accessToken, service);
				Status status = api.sendStatus(text);
				if (status == null) {
					request.setAttribute("result", "failed");
				} else {
					Oembed oembed = api.getOembed(status);
					request.setAttribute("status", oembed);
				}
				return "twresult.jsp";
			}
		}
		return "homepage.jsp";
	}

	@Override
	public String getName() {
		return "send_tweet.do";
	}

}
