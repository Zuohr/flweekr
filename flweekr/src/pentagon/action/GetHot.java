package pentagon.action;

import javax.servlet.http.HttpServletRequest;

import pentagon.apibean.FlickrBean;
import pentagon.flickrbean.JsonFlickrApi;
import pentagon.flickrbean.Photo;
import pentagon.flickrbean.Photos;
import pentagon.sdk.FlickrAPI;



public class GetHot implements Action {

	public GetHot(){
		
	}
	@Override
	public String perform(HttpServletRequest request) {
		FlickrBean flkBean = new FlickrBean();
		flkBean.setAPIKey("8e2749644cb6405b3ee6a2c7b5f73eef");
		flkBean.setBaseUrl("http://api.flickr.com/services/rest/");
		flkBean.setMethod("flickr.photos.search");
		flkBean.setPerPage("200");
		flkBean.setFormat("json");
		flkBean.setFlickrText("Yellow+Stone");
//		flkBean.setFlickrContent_type("1");
//		flkBean.setFlickrLat("37.779");
//		flkBean.setFlickrLon("-122.420");
		flkBean.setFlickrSort("interestingness-desc");
		
		FlickrAPI flkAPI = new FlickrAPI(flkBean);
		JsonFlickrApi jfa = flkAPI.getFlickrImage();
		
		System.out.println(jfa.photos.photo.get(0).getImgUrl());
		request.setAttribute("flk_plist", jfa.photos.photo);
		
		return "gallery.jsp";
	}

	@Override
	public String getName() {
		return "gethot.do";
	}

}
