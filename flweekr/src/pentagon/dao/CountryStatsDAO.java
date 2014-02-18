package pentagon.dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

public class CountryStatsDAO extends GenericDAO<CountryStats> {
	public CountryStatsDAO(String tableName, ConnectionPool cp)
			throws DAOException {
		super(CountryStats.class, tableName, cp);
	}
}
