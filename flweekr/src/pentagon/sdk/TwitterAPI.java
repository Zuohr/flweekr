package pentagon.sdk;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import pentagon.twitterbean.SearchResult;
import pentagon.twitterbean.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TwitterAPI {
	private OAuthService service;
	private Token accessToken;
	private static final String SEARCH_URL = "https://api.twitter.com/1.1/search/tweets.json?q=";

	public TwitterAPI(Token accessToken, OAuthService service) {
		this.service = service;
		this.accessToken = accessToken;
	}

	// send twitter

	// search
	public Status[] search(String keyword) {
		SearchResult searchResult = new SearchResult();
		String query = SEARCH_URL + keyword;
		OAuthRequest req = new OAuthRequest(Verb.GET, query);
		service.signRequest(accessToken, req);
		Response rsp = req.send();

		Gson gson = new GsonBuilder().create();
		searchResult = gson.fromJson(rsp.getBody(), SearchResult.class);
		return searchResult.getStatuses();
	}

	// timeline
}
