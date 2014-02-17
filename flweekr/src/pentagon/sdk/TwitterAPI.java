package pentagon.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringEscapeUtils;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import pentagon.flickrbean.JsonFlickrGetInfo;
import pentagon.model.Model;
import pentagon.twitterbean.Oembed;
import pentagon.twitterbean.SearchResult;
import pentagon.twitterbean.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TwitterAPI {
	private OAuthService service;
	private Token accessToken;
	private static final String GET_SEARCH = "https://api.twitter.com/1.1/search/tweets.json?";
	private static final String GET_OEMBED = "https://api.twitter.com/1.1/statuses/oembed.json?align=none&id=";
	private static final String POST_STATUS = "https://api.twitter.com/1.1/statuses/update.json?status=";

	public TwitterAPI(Token accessToken, OAuthService service) {
		this.service = service;
		this.accessToken = accessToken;
	}

	public Status[] searchByCoordination(JsonFlickrGetInfo info, String keyword) {
		if (info == null || keyword == null || keyword.isEmpty()) {
			return null;
		}
		
		String latitude = info.photo.location.latitude;
		String longitude = info.photo.location.longitude;
		if (latitude == null || latitude.isEmpty() || longitude == null || longitude.isEmpty()) {
			return searchKeyWordOnly(keyword);
		}
		String range = "1mi";
		String geocode = String.format("%s,%s,%s", latitude, longitude, range);

		try {
			keyword = URLEncoder.encode(keyword, "UTF-8");
			geocode = URLEncoder.encode(geocode, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		String query = String.format("q=%s&geocode=%s&count=5", keyword, geocode);
		return search(query);
	}

	public Status[] searchKeyWordOnly(String keyword) {
		if (keyword == null || keyword.isEmpty()) {
			return null;
		}
		try {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		String query = String.format("q=%s&count=5", keyword);
		return search(query);
	}

	private Status[] search(String query) {
		String url = GET_SEARCH + query;
		OAuthRequest req = new OAuthRequest(Verb.GET, url);
		service.signRequest(accessToken, req);
		Response rsp = req.send();

		Gson gson = new GsonBuilder().create();
		SearchResult searchResult = gson.fromJson(rsp.getBody(),
				SearchResult.class);
		if (searchResult.getStatuses() == null) {
			return null;
		} else {
			return searchResult.getStatuses();
		}
	}

	public Oembed[] getOembeds(Status[] statuses) {
		if (statuses == null) {
			return new Oembed[] {};
		}
		
		int len = statuses.length;
		Oembed[] result = new Oembed[len];
		for (int i = 0; i < len; i++) {
			result[i] = getOembed(statuses[i]);
		}

		return result;
	}

	public Oembed getOembed(Status status) {
		if (status == null) {
			return null;
		}

		String url = GET_OEMBED + status.getId_str();
		OAuthRequest req = new OAuthRequest(Verb.GET, url);
		service.signRequest(accessToken, req);
		Response rsp = req.send();

		Gson gson = new GsonBuilder().create();
		Oembed oembed = gson.fromJson(rsp.getBody(), Oembed.class);

		return oembed;
	}

	public Status sendStatus(String text) {
		if (text == null || text.isEmpty()) {
			return null;
		}

		try {
			text = StringEscapeUtils.unescapeHtml4(text);
			text = URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		String query = POST_STATUS + text;
		OAuthRequest req = new OAuthRequest(Verb.POST, query);
		service.signRequest(accessToken, req);
		Response rsp = req.send();

		Gson gson = new GsonBuilder().create();
		Status result = gson.fromJson(rsp.getBody(), Status.class);
		if (result.getId_str() == null) {
			return null;
		} else {
			return result;
		}
	}
	
//	public static OAuthService getService (Model model, String callbackUrl) {
//		String key = model.getKey();
//		String secret = model.getSecret();
//		OAuthService service = null;
//		try {
//			service = new ServiceBuilder().provider(TwitterApi.SSL.class)
//				.apiKey(key).apiSecret(secret).callback(callbackUrl).build();
//		} catch (Exception e) {
//			// Do nothing
//		}
//		return service;
//	}
}
