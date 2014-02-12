package pentagon.model;

import javax.servlet.ServletConfig;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.oauth.OAuthService;

public class Model {
	private OAuthService service;
	private static final String callbackUrl = "http://localhost:8080/flweekr/login.do";

	public Model(ServletConfig config) {
		String key = config.getInitParameter("API_key");
		String secret = config.getInitParameter("API_secret");
		this.service = new ServiceBuilder().provider(TwitterApi.SSL.class)
				.apiKey(key).apiSecret(secret).callback(callbackUrl).build();
	}

	public OAuthService getService() {
		return service;
	}
}
