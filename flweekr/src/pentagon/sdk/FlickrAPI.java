package pentagon.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import pentagon.apibean.FlickrBean;
import pentagon.flickrbean.JsonFlickrApi;

import com.google.gson.Gson;

public class FlickrAPI {
    FlickrBean flkBean;
    public FlickrAPI(FlickrBean flkBean){
    	this.flkBean = flkBean;
    }
    
    public JsonFlickrApi getFlickrImage(){
    	String url =  flkBean.getBaseUrl() + "?method=" + flkBean.getMethod() + "&api_key=" + flkBean.getApiKey() + "&per_page=" 
    			+ flkBean.getPerPage() + "&format=" + flkBean.getFormat() + /*"&lat="+flkBean.getFlickrLat()+ "&lon="+flkBean.getFlickrLon()+ "&content_type="+flkBean.getFlickrContent_type()+*/"&text=" + flkBean.getFlickrText() + "&sort="+ flkBean.getFlickrSort()+ "&extras=original_format";  
    	
    	StringBuffer sb = new StringBuffer();
    	InputStream is = null;
    	InputStreamReader isr = null;
    	BufferedReader br = null;
    	try{
    		is = new URL(url).openConnection().getInputStream();
    		isr = new InputStreamReader(is, "UTF-8");
    		br = new BufferedReader(isr);
    		String line = null;
    		while(null!=(line = br.readLine())){
    			sb.append(line);
    		}
    		String str = sb.toString().substring("jsonFlickrApi(".length(), sb.length()-1);
    		Gson gson = new Gson();
    		JsonFlickrApi tagbean = gson.fromJson(str, JsonFlickrApi.class);
    		return tagbean;
    	} catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            if(null != br){  
                try {  
                    br.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            if(null != isr){  
                try {  
                    isr.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            if(null != is){  
                try {  
                    is.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        } 
    	return null;
    }
    
    
}
