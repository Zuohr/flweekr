package pentagon.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import pentagon.twitterbean.Oembed;
import pentagon.twitterbean.SearchResult;
import pentagon.twitterbean.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TwitterAPI {
	private OAuthService service;
	private Token accessToken;
	private static final String GET_SEARCH = "https://api.twitter.com/1.1/search/tweets.json?q=";
	private static final String GET_OEMBED = "https://api.twitter.com/1.1/statuses/oembed.json?align=none&id=";

	public TwitterAPI(Token accessToken, OAuthService service) {
		this.service = service;
		this.accessToken = accessToken;
	}

	// send twitter

	public Status[] search(String keyword) {
		try {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url = GET_SEARCH + keyword;
		OAuthRequest req = new OAuthRequest(Verb.GET, url);
		service.signRequest(accessToken, req);
		Response rsp = req.send();

		Gson gson = new GsonBuilder().create();
		SearchResult searchResult = gson.fromJson(rsp.getBody(), SearchResult.class);
		return searchResult.getStatuses();
	}
	
	public Oembed getOembed(Status status) {
		String url = GET_OEMBED + status.getId_str();
		OAuthRequest req = new OAuthRequest(Verb.GET, url);
		service.signRequest(accessToken, req);
		Response rsp = req.send();
		
		Gson gson = new GsonBuilder().create();
		Oembed oembed = gson.fromJson(rsp.getBody(), Oembed.class);
		
		return oembed;
	}

	// timeline
}
