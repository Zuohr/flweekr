package pentagon.dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

public class PostDAO extends GenericDAO<Post> {
	public PostDAO(String tableName, ConnectionPool cp) throws DAOException {
		super(Post.class, tableName, cp);
	}

	public Post[] read(String flickr_id) throws RollbackException {
		if (flickr_id == null) {
			flickr_id = "";
		}
		return match(MatchArg.equals("flickr_id", flickr_id));
	}
}
