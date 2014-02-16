package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;

import pentagon.google.MapBean;

public class Mappic implements Action {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {
		MapBean map = new MapBean();
		map.setLatitude(40.44);
		map.setLongitude(-79.999);
		map.setImgURL("http://upload.wikimedia.org/wikipedia/commons/6/61/Pittsburgh_skyline_night.jpg");
		request.setAttribute("map", map);
		return "mappic.jsp";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "mappic.do";
	}

}
