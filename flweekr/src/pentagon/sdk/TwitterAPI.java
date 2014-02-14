package pentagon.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringEscapeUtils;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import pentagon.flickrbean.Photo;
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

	public Status[] searchByCoordination(Photo photo, String keyword) {
		if (photo == null || keyword == null) {
			return null;
		}
		String latitude = photo.getLatitude();
		String longitude = photo.getLongitude();
		if (latitude == null || latitude.isEmpty() || longitude == null || longitude.isEmpty()) {
			return null;
		}
		String range = "1mi";
		String geocode = String.format("%s,%s,%s", latitude, longitude, range);

		try {
			keyword = URLEncoder.encode(keyword, "UTF-8");
			geocode = URLEncoder.encode(geocode, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String query = String.format("q=%s&geocode=%s", keyword, geocode);
		return search(query);
	}

	public Status[] searchKeyWordOnly(String keyword) {
		try {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String query = String.format("q=%s", keyword);
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
			e.printStackTrace();
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
}
