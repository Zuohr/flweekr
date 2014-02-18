package pentagon.flickrbean;

public class Photo {
	public String id;
	public String owner;
	public String secret;
	public String server;
	public String farm;
	public String title;
	public String ispublic;
	public String isfriend;
	public String isfamily;
	public String originalsecret;
	public String originalformat;
	public String imgUrl;
	public String imgUrl_b;
	public String imgUrl_m;
	public String url_o;



	public String getUrl_o() {
		return url_o;
	}

	public String latitude;
	public String longitude;
	
	public String getLatitude() {
		return latitude;
	}

	public String getTitle() {
		return title;
	}

	public String getLongitude() {
		return longitude;
	}



	public String getImgUrl() {
		imgUrl = "http://farm" + farm + ".static.flickr.com/" + server + "/" + id + "_" + secret + ".jpg";
		return imgUrl;
	}
	
	public String getImgUrl_b() {
		imgUrl_b = "http://farm" + farm + ".static.flickr.com/" + server + "/" + id + "_" + secret + "_b.jpg";
		return imgUrl_b;
	}

	public String getImgUrl_m() {
		imgUrl_b = "http://farm" + farm + ".static.flickr.com/" + server + "/" + id + "_" + secret + "_m.jpg";
		return imgUrl_m;
	}
	
	public String getId() {
		return id;
	}
}

/*
http://farm" + photo.farm + ".static.flickr.com/" + 
        photo.server + "/" + photo.id + "_" + photo.secret + "_" + "t.jpg";
*/

//[{"id":"12392750014", "owner":"34540272@N08", "secret":"91c6d52bbf", "server":"3754", "farm":4, "title":"Longfellow", 
//"ispublic":1, "isfriend":0, "isfamily":0, "originalsecret":"1511e6db52", "originalformat":"jpg"}

//"id":"12507937913", "owner":"76833726@N05", "secret":"715638a3e9", "server":"7311", "farm":8, "title":"PAT M-210 on 2-14-73", "ispublic":1, "isfriend":0, "isfamily":0, "originalsecret":"548ab5159b", "originalformat":"jpg"}