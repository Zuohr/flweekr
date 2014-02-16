package pentagon.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;

import pentagon.google.MapBean;

public class Weather implements Action{

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {
		MapBean map= (MapBean) request.getSession().getAttribute("map");
		request.setAttribute("map", map);
		
	    request.getSession().removeAttribute("map");
		return "weather.jsp";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "weather.do";
	}

}
