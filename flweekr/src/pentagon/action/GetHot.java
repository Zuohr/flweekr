package pentagon.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import pentagon.apibean.FlickrBean;
import pentagon.flickrbean.JsonFlickrApi;
import pentagon.flickrbean.Photo;
import pentagon.flickrbean.Photos;
import pentagon.model.Model;
import pentagon.sdk.FlickrAPI;



public class GetHot implements Action {

	public GetHot(Model model){
		
	}
	@Override
	public String perform(HttpServletRequest request) {
		int num = 30;
		FlickrBean flkBean = new FlickrBean();
		flkBean.setAPIKey("8e2749644cb6405b3ee6a2c7b5f73eef");
		flkBean.setBaseUrl("http://api.flickr.com/services/rest/");
		flkBean.setMethod("flickr.photos.search");
		flkBean.setPerPage(Integer.toString(num));
		flkBean.setFormat("json");
		flkBean.setFlickrText("Pittsburgh");
//		flkBean.setFlickrContent_type("1");
//		flkBean.setFlickrLat("37.779");
//		flkBean.setFlickrLon("-122.420");
		flkBean.setFlickrSort("interestingness-desc");
		
		FlickrAPI flkAPI = new FlickrAPI(flkBean);
		JsonFlickrApi jfa = flkAPI.getFlickrImage();
		
		request.setAttribute("flk_plist", jfa.photos.photo);
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<num; i++){
			Photo p = jfa.photos.photo.get(i);
			map.put(p.id, p.getImgUrl());
		}
		request.getSession().setAttribute("imgUrlMap", map);
		
		return "gallery.jsp";
	}

	@Override
	public String getName() {
		return "gethot.do";
	}

}
