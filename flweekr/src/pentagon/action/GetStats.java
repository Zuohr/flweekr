package pentagon.action;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;

import pentagon.dao.SearchKey;
import pentagon.dao.SearchKeyComparator;
import pentagon.dao.SearchKeyDAO;
import pentagon.model.Model;

public class GetStats implements Action {
	private SearchKeyDAO skDAO;

	public GetStats(Model model) {
		this.skDAO = model.getSearchKeyDAO();
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {
		// get top search key
		SearchKey[] skeys = getTopSearchKeys();
		if (skeys != null) {
			request.setAttribute("top_search_title", "Most Searched Topic");
			request.setAttribute("top_search_data", skeys);
		}

		// get wished to
		

		// get been to

		// get most viewed

		return "stats.jsp";
	}

	private SearchKey[] getTopSearchKeys() throws RollbackException {
		SearchKey[] keys = skDAO.match();
		if (keys != null && keys.length > 0) {
			Arrays.sort(keys, new SearchKeyComparator());
			int len = Math.min(10, keys.length);
			SearchKey[] popular_keys = Arrays.copyOfRange(keys, 0, len);
			return popular_keys;
		}
		return null;
	}

	@Override
	public String getName() {
		return "getstats.do";
	}

}
