package pentagon.action;

import javax.servlet.http.HttpServletRequest;

import pentagon.google.MapBean;

public class SetMap implements Action {


	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MapBean map=new MapBean();
		map.setLatitude(40);
		map.setLongitude(-80);
		map.setImgURL("http://img.9so.cc/timg/703204536572916331.jpg");
		request.setAttribute("map", map);
		
		
		return "index.jsp";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "setmap.do";
	}

}
