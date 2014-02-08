package pentagon.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pentagon.apibean.FlickrBean;
import pentagon.flickrbean.Photos;

public class FlickrAPI {
    FlickrBean flkBean;
    public FlickrAPI(FlickrBean flkBean){
    	this.flkBean = flkBean;
    }
    
    public String getFlickrImage(){
    	String url =  flkBean.getBaseUrl() + "?method=" + flkBean.getMethod() + "&api_key=" + flkBean.getApiKey() + "&per_page=" 
    			+ flkBean.getPerPage() + "&format=" + flkBean.getFormat() + "&tags=" + flkBean.getTags() + "&extras=original_format";  
    	
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
    		Gson gson = new GsonBuilder().create();
    		Photos tagbean = gson.fromJson(isr, Photos.class);
    		System.out.println(tagbean.getPhotos()[0].getImgUrl());
    		System.out.println("111");
    		return sb.toString();
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
    	return "";
    }
    
    
}
