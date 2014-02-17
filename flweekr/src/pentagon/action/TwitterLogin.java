package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import pentagon.model.Model;
import pentagon.model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TwitterLogin implements Action {
	private OAuthService service;

	// private OAuthService service;

	public TwitterLogin(Model model) {
		this.service = model.getService();
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// check if session exists
		if (user != null) {
			return "home.do";
		}

		// check if sign_in_with_twitter button is pressed
		if ("twitter_sign_in".equals(request.getParameter("sign_in_button"))) {
			// String callback_id = (String) session.getAttribute("flickr_id");
			// if (callback_id != null) {
			// String callbackUrl = String.format("%login.do?flickr_id=%s",
			// Meta.domain, callback_id);
			// OAuthService service = new ServiceBuilder()
			// .provider(TwitterApi.SSL.class).apiKey(model.getKey())
			// .apiSecret(model.getSecret()).callback(callbackUrl).build();
			Token requestToken = service.getRequestToken();
			// String result = requestToken.getRawResponse();
			// request.setAttribute("result", result);
			session.setAttribute("requestToken", requestToken);
			// session.setAttribute("service", service);

			return service.getAuthorizationUrl(requestToken);
			// }
		}

		// check if token and verifier is provided
		String oauth_token = request.getParameter("oauth_token");
		String oauth_verifier = request.getParameter("oauth_verifier");
		if (oauth_token != null && !oauth_token.isEmpty()
				&& oauth_verifier != null && !oauth_verifier.isEmpty()) {
			Token req_token = (Token) session.getAttribute("requestToken");
			// OAuthService service = (OAuthService) session
			// .getAttribute("service");
			session.removeAttribute("reqeustToken");
			// session.removeAttribute("service");
			if (oauth_token.equals(req_token.getToken())) {
				Token accessToken = service.getAccessToken(req_token,
						new Verifier(oauth_verifier));
				if (accessToken != null) {
					String query = "https://api.twitter.com/1.1/account/verify_credentials.json";
					OAuthRequest tw_request = new OAuthRequest(Verb.GET, query);
					service.signRequest(accessToken, tw_request);
					Response tw_response = tw_request.send();
					Gson gson = new GsonBuilder().create();
					user = gson.fromJson(tw_response.getBody(), User.class);
					user.setAccessToken(accessToken);
					session.setAttribute("user", user);
					// request.setAttribute("result", String
					// .format("token:%s verifier:%s", oauth_token,
					// oauth_verifier));

					return "getdetail.do";
				}
			}
		}
		return "homepage.jsp";
	}

	@Override
	public String getName() {
		return "login.do";
	}

}
