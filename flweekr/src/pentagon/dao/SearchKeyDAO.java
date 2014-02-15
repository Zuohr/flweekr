package pentagon.dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

public class SearchKeyDAO extends GenericDAO<SearchKey> {
	public SearchKeyDAO(String tableName, ConnectionPool cp)
			throws DAOException {
		super(SearchKey.class, tableName, cp);
	}

	public SearchKey read(String keyword) throws RollbackException {
		if (keyword == null) {
			keyword = "";
		}
		SearchKey[] results = match(MatchArg.equals("keyword", keyword));
		if (results.length > 0) {
			return results[0];
		} else {
			return null;
		}
	}
}
