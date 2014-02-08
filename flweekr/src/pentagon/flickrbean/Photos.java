package pentagon.flickrbean;

import com.google.gson.annotations.SerializedName;

public class Photos {
	@SerializedName("page")
	private String page;
	@SerializedName("pages")
	private String pages;
	@SerializedName("perpage")
	private String perpage;
	@SerializedName("total")
	private String total;
	@SerializedName("photo")
	private Photo[] photo;
	
	public Photo[] getPhotos(){
		return photo;
	}
}


//[{"id":"12392750014", "owner":"34540272@N08", "secret":"91c6d52bbf", "server":"3754", "farm":4, "title":"Longfellow", 
//"ispublic":1, "isfriend":0, "isfamily":0, "originalsecret":"1511e6db52", "originalformat":"jpg"}