package pentagon.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;

import pentagon.apibean.FlickrBean;
import pentagon.dao.SearchKey;
import pentagon.dao.SearchKeyDAO;
import pentagon.flickrbean.JsonFlickrApi;
import pentagon.model.Model;
import pentagon.sdk.FlickrAPI;

public class Search implements Action {
	private SearchKeyDAO searchKeyDAO;

	public Search(Model model) {
		this.searchKeyDAO = model.getSearchKeyDAO();
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {

		String keyWord = request.getParameter("key");
		if (keyWord != null && !keyWord.isEmpty()) {
			// set cookie
			Cookie cookie = new Cookie("last_search", keyWord);
			cookie.setMaxAge(30 * 24 * 60 * 60); // 30 days max age
			response.addCookie(cookie);
			// update database
			SearchKey searchKey = searchKeyDAO.read(keyWord);
			if (searchKey == null) {
				searchKey = new SearchKey();
				searchKey.setKeyword(keyWord);
				searchKey.setNumber(1);
				searchKeyDAO.create(searchKey);
			} else {
				searchKey.setNumber(searchKey.getNumber() + 1);
				searchKeyDAO.update(searchKey);
			}
		} else {
			keyWord = "discover";
		}
		
		String[] keySet = keyWord.split("\\s");
		StringBuilder keyBuilder = new StringBuilder();
		for (int i = 0; i < keySet.length; i++) {
			keyBuilder.append(keySet[i] + "+");
		}

		String pageNum = "1";
		request.setAttribute("pageNum", pageNum);
		pageNum = request.getParameter("page");
		if (pageNum!=null && Integer.parseInt(pageNum) > 1) {
			request.setAttribute("pageNum", pageNum);
		}
		FlickrBean flkBean = new FlickrBean();
		flkBean.setAPIKey("8e2749644cb6405b3ee6a2c7b5f73eef");
		flkBean.setBaseUrl("http://api.flickr.com/services/rest/");
		flkBean.setMethod("flickr.photos.search");
		flkBean.setPerPage("50");
		flkBean.setFormat("json");
		flkBean.setFlickrText(keyBuilder.toString() + "trip");
		flkBean.setFlickrHasGeo("1");
		flkBean.setFlickPage(pageNum);
		flkBean.setFlickrSort("interestingness-desc");//

		FlickrAPI flkAPI = new FlickrAPI(flkBean);
		JsonFlickrApi jfa = flkAPI.getFlickrImage();

		request.setAttribute("flk_plist", jfa.photos.photo);
		request.setAttribute("term", keyWord);

		return "gallery.jsp";
	}

	@Override
	public String getName() {
		return "search.do";
	}

}
