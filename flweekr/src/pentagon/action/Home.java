package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pentagon.model.Model;

public class Home implements Action {
	
	public Home(Model model){
		
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "home.jsp";
	}

	@Override
	public String getName() {
		return "home.do";
	}

}
