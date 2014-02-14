package pentagon.model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.oauth.OAuthService;

import pentagon.dao.PostDAO;

public class Model {
	private OAuthService service;
	private static final String callbackUrl = "http://localhost:8080/flweekr/login.do";
	private ConnectionPool cp;
	private PostDAO postDAO;

	public Model(ServletConfig config) throws ServletException {
		String key = config.getInitParameter("API_key");
		String secret = config.getInitParameter("API_secret");
		this.service = new ServiceBuilder().provider(TwitterApi.SSL.class)
				.apiKey(key).apiSecret(secret).callback(callbackUrl).build();

		String jdbcName = config.getInitParameter("jdbcName");
		String jdbcURL = config.getInitParameter("jdbcURL");
		this.cp = new ConnectionPool(jdbcName, jdbcURL);
		try {
			this.postDAO = new PostDAO("post", cp);
		} catch (DAOException e) {
			throw new ServletException();
		}
	}

	public OAuthService getService() {
		return service;
	}

	public PostDAO getPostDAO() {
		return postDAO;
	}
}
