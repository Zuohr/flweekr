package pentagon.apibean;

public class FlickrBean {
	private String flickrBaseUrl;
	private String flickrMethod;
	private String flickrAPIKey;
	private String flickrPerPage;
    private String flickrFormat;
    private String flickrTags;
    private String flickrText;
    private String flickrContent_type;
    private String flickrLat;
    private String flickrLon;
    private String flickrSort;
    private String flickrPhotoId;
    private String flickrHasGeo;
    private String flickPage;
    
    public String getFlickPage() {
		return flickPage;
	}

	public void setFlickPage(String flickPage) {
		this.flickPage = flickPage;
	}

	public String getFlickrHasGeo() {
		return flickrHasGeo;
	}

	public void setFlickrHasGeo(String flickrHasGeo) {
		this.flickrHasGeo = flickrHasGeo;
	}

	public String getFlickrPhotoId() {
		return flickrPhotoId;
	}

	public void setFlickrPhotoId(String flickrPhotoId) {
		this.flickrPhotoId = flickrPhotoId;
	}

	public String getFlickrSort() {
		return flickrSort;
	}

	public void setFlickrSort(String flickrSort) {
		this.flickrSort = flickrSort;
	}

	public String getFlickrLat() {
		return flickrLat;
	}

	public void setFlickrLat(String flickrLat) {
		this.flickrLat = flickrLat;
	}

	public String getFlickrLon() {
		return flickrLon;
	}

	public void setFlickrLon(String flickrLon) {
		this.flickrLon = flickrLon;
	}

	public String getFlickrContent_type() {
		return flickrContent_type;
	}

	public void setFlickrContent_type(String flickrContent_type) {
		this.flickrContent_type = flickrContent_type;
	}

	public String getBaseUrl(){
    	return flickrBaseUrl;
    }
    
    public String getMethod(){
    	return flickrMethod;
    }
    
    public String getApiKey(){
    	return flickrAPIKey;
    }
    
    public String getPerPage(){
    	return flickrPerPage;
    }
    
    public String getFormat(){
    	return flickrFormat;
    }
    
    public String getTags(){
    	return flickrTags;
    }
    
    public void setBaseUrl(String s){
    	flickrBaseUrl = s;
    }
    
    public void setMethod(String s){
    	flickrMethod = s;
    }
    
    public void setAPIKey(String s){
    	flickrAPIKey = s;
    }
    
    public void setPerPage(String s){
    	flickrPerPage = s;
    }
    
    public void setFormat(String s){
    	flickrFormat = s;
    }
    
    public void setTags(String s){
    	flickrTags = s;
    }

	public String getFlickrText() {
		return flickrText;
	}

	public void setFlickrText(String flickrText) {
		this.flickrText = flickrText;
	}
    
}
