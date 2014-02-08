package pentagon.flickrbean;

import com.google.gson.annotations.SerializedName;

public class Photo {
//	private int id;
	@SerializedName("owner")
	private String owner;
	@SerializedName("secret")
	private String secret;
//	private int server;
//	private int farm;
//	private String title;
//	private boolean ispublic;
//	private boolean isfriend;
//	private boolean isfamily;
//	private String originalsecret;
//	private String originalformat;
	
	public String getImgUrl(){
		return owner+"-" + secret;
	}
}
