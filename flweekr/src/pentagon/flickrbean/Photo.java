package pentagon.flickrbean;

public class Photo {
//	private int id;
	private String owner;
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
