package pentagon.action;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;

import pentagon.dao.PhotoComparator;
import pentagon.dao.PhotoReview;
import pentagon.dao.PhotoReviewDAO;
import pentagon.model.Model;

public class Home implements Action {
	private PhotoReviewDAO photoReviewDAO;

	public Home(Model model) {
		this.photoReviewDAO = model.getPhotoReviewDAO();
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {
		
		
		String last_search = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("last_search".equals(cookie.getName())) {
				last_search = cookie.getValue();
			}
		}
		if (last_search == null) {
			PhotoReview[] prs = photoReviewDAO.match();
			if (prs.length > 0) {
				Arrays.sort(prs, new PhotoComparator());
			}
		}

		return "home.jsp";
	}

	@Override
	public String getName() {
		return "home.do";
	}

}
