package pentagon.action;

import javax.servlet.http.HttpServletRequest;

public class getPlace implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "city.jsp";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "getplace.do";
	}

}
