package pentagon.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import pentagon.apibean.FlickrBean;
import pentagon.flickrbean.JsonFlickrApi;
import pentagon.flickrbean.JsonFlickrGetInfo;

import com.google.gson.Gson;

public class FlickrAPI {
	FlickrBean flkBean;

	public FlickrAPI(FlickrBean flkBean) {
		this.flkBean = flkBean;
	}
	
	public JsonFlickrApi getFlickrImage(){
		String url = flkBean.getBaseUrl() + "?method=" + flkBean.getMethod()
				+ "&api_key=" + flkBean.getApiKey() + "&per_page="
				+ flkBean.getPerPage() + "&page="+ flkBean.getFlickPage() + "&format=" + flkBean.getFormat()
				+ "&text=" + flkBean.getFlickrText() + "&sort="
				+ flkBean.getFlickrSort() + "&has_geo="+ flkBean.getFlickrHasGeo()
				+"&extras=url_b";
		
		String data = queryFlickr(url);
		data = data.substring("jsonFlickrApi(".length(),
				data.length() - 1);
		Gson gson = new Gson();
		JsonFlickrApi tagbean = gson.fromJson(data, JsonFlickrApi.class);
		return tagbean;
	}
	
	public JsonFlickrGetInfo getImgInfo(){
		String url = flkBean.getBaseUrl() + "?method="+ flkBean.getMethod()
				+ "&api_key=" +flkBean.getApiKey() +"&photo_id="+flkBean.getFlickrPhotoId()
				+ "&format=" + flkBean.getFormat()+"&nojsoncallback=1";
		String data = queryFlickr(url);
		Gson gson = new Gson();
		JsonFlickrGetInfo tagbean = gson.fromJson(data, JsonFlickrGetInfo.class);
		return tagbean;
	}

	public String queryFlickr(String url) {
		StringBuffer sb = new StringBuffer();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			is = new URL(url).openConnection().getInputStream();
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
			String line = null;
			while (null != (line = br.readLine())) {
				sb.append(line);
			}

			return sb.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != isr) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
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
