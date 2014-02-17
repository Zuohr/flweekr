package pentagon.flickrbean;

public class PhotoInfo {
	public String imgUrl;
	public String imgUrl_b;
	public Location location;
	public Title title;



	public Description description;
	public String secret;
	public String server;
	public String farm;
	public String id;
	
	public String getImgUrl() {
		imgUrl = "http://farm" + farm + ".static.flickr.com/" + server + "/" + id + "_" + secret + ".jpg";
		return imgUrl;
	}
	
	public String getImgUrl_b() {
		imgUrl_b = "http://farm" + farm + ".static.flickr.com/" + server + "/" + id + "_" + secret + "_b.jpg";
		return imgUrl_b;
	}
	
	public Location getLocation() {
		return location;
	}
	public Title getTitle() {
		return title;
	}
}
