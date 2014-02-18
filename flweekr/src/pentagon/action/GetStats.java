package pentagon.action;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;

import pentagon.dao.CountryStats;
import pentagon.dao.CountryStatsDAO;
import pentagon.dao.SearchKey;
import pentagon.dao.SearchKeyComparator;
import pentagon.dao.SearchKeyDAO;
import pentagon.dao.ViewHistory;
import pentagon.dao.ViewHistoryComparator;
import pentagon.dao.ViewHistoryDAO;
import pentagon.model.Model;

public class GetStats implements Action {
	private SearchKeyDAO searchKeyDAO;
	private ViewHistoryDAO viewHistoryDAO;
	private CountryStatsDAO countryStatsDAO;

	public GetStats(Model model) {
		this.searchKeyDAO = model.getSearchKeyDAO();
		this.viewHistoryDAO = model.getViewHistoryDAO();
		this.countryStatsDAO = model.getCountryStatsDAO();
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {
		// get top search key
		// SearchKey -> kewy
		SearchKey[] skeys = getTopSearchKeys();
		if (skeys != null) {
			request.setAttribute("top_search_title", "Hottest Topic");
			request.setAttribute("top_search_data", skeys);
		}

		// get wished to & been to
		CountryStats[] cStats = getCountryStats();
		if (cStats != null) {
			request.setAttribute("wish_title", "People Wish To Go");
			request.setAttribute("been_title", "People Have Been To");
			request.setAttribute("wish_list", cStats);
		}

		// get most viewed
		ViewHistory[] topView = getViewHistory();
		if (topView != null) {
			request.setAttribute("history_title", "Most Viewed Places");
			/*
			 * get photo info fro Flickr API
			 */
		}

		return "chart.jsp";
	}

	@Override
	public String getName() {
		return "getstats.do";
	}

	private ViewHistory[] getViewHistory() throws RollbackException {
		ViewHistory[] all = viewHistoryDAO.match();
		if (all != null && all.length > 0) {
			Arrays.sort(all, new ViewHistoryComparator());
			int len = Math.min(10, all.length);
			ViewHistory[] result = Arrays.copyOfRange(all, 0, len);
			return result;
		} else {
			return null;
		}
	}

	private CountryStats[] getCountryStats() throws RollbackException {
		CountryStats[] result = countryStatsDAO.match();
		if (result != null && result.length > 0) {
			return result;
		} else {
			return null;
		}
	}

	private SearchKey[] getTopSearchKeys() throws RollbackException {
		SearchKey[] keys = searchKeyDAO.match();
		if (keys != null && keys.length > 0) {
			Arrays.sort(keys, new SearchKeyComparator());
			int len = Math.min(10, keys.length);
			SearchKey[] popular_keys = Arrays.copyOfRange(keys, 0, len);
			return popular_keys;
		} else {
			return null;
		}
	}

}
