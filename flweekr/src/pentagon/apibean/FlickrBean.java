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
