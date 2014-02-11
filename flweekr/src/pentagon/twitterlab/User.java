package pentagon.twitterlab;

import org.scribe.model.Token;

public class User {
	private String name;
	private String screen_name;
	private Token accessToken;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public Token getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(Token accessToken) {
		this.accessToken = accessToken;
	}

}
