package pentagon.dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

public class CountryStatsDAO extends GenericDAO<CountryStats> {
	public CountryStatsDAO(String tableName, ConnectionPool cp)
			throws DAOException {
		super(CountryStats.class, tableName, cp);
	}
	
	public CountryStats read(String name) throws RollbackException {
		if (name == null || name.isEmpty()) {
			return null;
		}
		
		CountryStats[] result = match(MatchArg.equals("name", name));
		if (result != null && result.length > 0) {
			return result[0];
		} else {
			return null;
		}
	}
}
