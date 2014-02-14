package pentagon.dao;

import org.genericdao.PrimaryKey;

@PrimaryKey("id")
public class Post {
	private int id;
	private String flickr_id;
	private String twitter_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlickr_id() {
		return flickr_id;
	}

	public void setFlickr_id(String flickr_id) {
		this.flickr_id = flickr_id;
	}

	public String getTwitter_id() {
		return twitter_id;
	}

	public void setTwitter_id(String twitter_id) {
		this.twitter_id = twitter_id;
	}
}
