package pentagon.apibean;

public class FlickrBean {
	private String flickrBaseUrl;
	private String flickrMethod;
	private String flickrAPIKey;
	private String flickrPerPage;
    private String flickrFormat;
    private String flickrTags;
    
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
}
