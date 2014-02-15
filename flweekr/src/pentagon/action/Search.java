package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pentagon.apibean.FlickrBean;
import pentagon.flickrbean.JsonFlickrApi;
import pentagon.model.Model;
import pentagon.sdk.FlickrAPI;

public class Search implements Action {

	public Search(Model model) {

	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		FlickrBean flkBean = new FlickrBean();
		flkBean.setAPIKey("8e2749644cb6405b3ee6a2c7b5f73eef");
		flkBean.setBaseUrl("http://api.flickr.com/services/rest/");
		flkBean.setMethod("flickr.photos.search");
		flkBean.setPerPage("200");
		flkBean.setFormat("json");
		flkBean.setFlickrText("Yellow+Stone");
		// flkBean.setFlickrContent_type("1");
		// flkBean.setFlickrLat("37.779");
		// flkBean.setFlickrLon("-122.420");
		flkBean.setFlickrSort("interestingness-desc");
		
		FlickrAPI flkAPI = new FlickrAPI(flkBean);
		JsonFlickrApi jfa = flkAPI.getFlickrImage();

		request.setAttribute("flk_plist", jfa.photos.photo);

		return "gallery.jsp";
	}

	@Override
	public String getName() {
		return "search.do";
	}

}
