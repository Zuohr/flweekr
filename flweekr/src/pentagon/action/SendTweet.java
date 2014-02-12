package pentagon.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import pentagon.model.Model;
import pentagon.model.User;

public class SendTweet implements Action {
	private OAuthService service;

	public SendTweet(Model model) {
		service = model.getService();
	}

	@Override
	public String perform(HttpServletRequest request) {
		String text = request.getParameter("text");
		User user = (User) request.getSession().getAttribute("user");
		Token accessToken = user.getAccessToken();

		try {
			System.out.println(text);
			text = StringEscapeUtils.unescapeHtml4(text);
			System.out.println(text);
			text = URLEncoder.encode(text, "UTF-8");
			System.out.println(text);
			OAuthRequest tw_request = new OAuthRequest(Verb.POST,
					"https://api.twitter.com/1.1/statuses/update.json?status="
							+ text);
			service.signRequest(accessToken, tw_request);
			Response tw_response = tw_request.send();
			System.out.println(tw_response.getBody());
			request.setAttribute("result", tw_response.getBody());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "twresult.jsp";
	}

	@Override
	public String getName() {
		return "send_tweet.do";
	}

}
