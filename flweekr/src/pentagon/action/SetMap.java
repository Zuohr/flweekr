package pentagon.action;

import javax.servlet.http.HttpServletRequest;

import pentagon.google.MapBean;

public class SetMap implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub

		String btn = request.getParameter("submit_btn");
		if (btn == null) {
			return "hotmap.jsp";
		} else if ("submit".equals(btn)) {
			MapBean map = new MapBean();
			map.setLatitude(40);
			map.setLongitude(-80);
			map.setImgURL("http://upload.wikimedia.org/wikipedia/commons/6/61/Pittsburgh_skyline_night.jpg");
			request.setAttribute("map", map);

		}
		return "hotmap.jsp";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "setmap.do";
	}

}
