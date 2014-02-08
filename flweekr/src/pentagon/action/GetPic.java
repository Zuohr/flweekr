package pentagon.action;

import javax.servlet.http.HttpServletRequest;

import pentagon.apibean.FlickrBean;
import pentagon.sdk.FlickrAPI;



public class GetPic implements Action {

	public GetPic(){
		
	}
	@Override
	public String perform(HttpServletRequest request) {
		FlickrBean flkBean = new FlickrBean();
		flkBean.setAPIKey("8e2749644cb6405b3ee6a2c7b5f73eef");
		flkBean.setBaseUrl("http://api.flickr.com/services/rest/");
		flkBean.setMethod("flickr.photos.search");
		flkBean.setPerPage("200");
		flkBean.setFormat("json");
		flkBean.setTags("pittsburgh");
		
		FlickrAPI flkAPI = new FlickrAPI(flkBean);
		
		String jsonData = flkAPI.getFlickrImage();
		
		//String img = "http://farm8.static.flickr.com/7356/12351753145_3b4ffc01c2_t.jpg"
		System.out.println(jsonData);
		
		return "index.jsp";
	}

	@Override
	public String getName() {
		return "getpic.do";
	}

}
