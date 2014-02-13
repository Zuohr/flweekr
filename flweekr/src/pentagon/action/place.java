package pentagon.action;

import javax.servlet.http.HttpServletRequest;

import pentagon.apibean.FlickrBean;
import pentagon.sdk.FlickrAPI;



public class place implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "city.jsp";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "place.do";
	}


}
