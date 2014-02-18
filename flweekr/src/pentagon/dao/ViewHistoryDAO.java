package pentagon.dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

public class ViewHistoryDAO extends GenericDAO<ViewHistory> {
	public ViewHistoryDAO(String tableName, ConnectionPool cp)
			throws DAOException {
		super(ViewHistory.class, tableName, cp);
	}

	public ViewHistory read(String flickr_id) throws RollbackException {
		if (flickr_id == null || flickr_id.isEmpty()) {
			return null;
		}

		ViewHistory[] result = match(MatchArg.equals("flickr_id", flickr_id));
		if (result == null || result.length == 0) {
			return null;
		} else {
			return result[0];
		}
	}
}
