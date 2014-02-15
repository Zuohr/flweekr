package pentagon.dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

public class PhotoReviewDAO extends GenericDAO<PhotoReview> {
	public PhotoReviewDAO(String tableName, ConnectionPool cp)
			throws DAOException {
		super(PhotoReview.class, tableName, cp);
	}

	public PhotoReview read(String flickr_id) throws RollbackException {
		if (flickr_id == null) {
			flickr_id = "";
		}
		PhotoReview[] results = match(MatchArg.equals("flickr_id", flickr_id));
		if (results.length > 0) {
			return results[0];
		} else {
			return null;
		}
	}
}
