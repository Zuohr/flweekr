package pentagon.flickrbean;

import com.google.gson.annotations.SerializedName;

public class Photo {
	private String id;
	private String owner;
	private String secret;
	private int server;
	private int farm;
	private String title;
	private boolean ispublic;
	private boolean isfriend;
	private boolean isfamily;
	private String originalsecret;
	private String originalformat;
	public String getId() {
		return id;
	}
	public String getOwner() {
		return owner;
	}
	public String getSecret() {
		return secret;
	}
	public int getServer() {
		return server;
	}
	public int getFarm() {
		return farm;
	}
	public String getTitle() {
		return title;
	}
	public boolean isIspublic() {
		return ispublic;
	}
	public boolean isIsfriend() {
		return isfriend;
	}
	public boolean isIsfamily() {
		return isfamily;
	}
	public String getOriginalsecret() {
		return originalsecret;
	}
	public String getOriginalformat() {
		return originalformat;
	}
	
}
