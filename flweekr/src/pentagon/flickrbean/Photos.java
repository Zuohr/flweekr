package pentagon.flickrbean;

public class Photos {
	private String page;
	private String pages;
	private String perpage;
	private String total;
	private Photo[] photo;
	
	public Photo[] getPhotos(){
		return photo;
	}
}


//[{"id":"12392750014", "owner":"34540272@N08", "secret":"91c6d52bbf", "server":"3754", "farm":4, "title":"Longfellow", 
//"ispublic":1, "isfriend":0, "isfamily":0, "originalsecret":"1511e6db52", "originalformat":"jpg"}