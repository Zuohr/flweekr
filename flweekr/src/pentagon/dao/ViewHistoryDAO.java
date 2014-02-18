package pentagon.dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

public class ViewHistoryDAO extends GenericDAO<ViewHistory> {
	public ViewHistoryDAO(String tableName, ConnectionPool cp)
			throws DAOException {
		super(ViewHistory.class, tableName, cp);
	}
}
