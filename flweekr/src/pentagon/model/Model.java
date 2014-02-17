package pentagon.model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.oauth.OAuthService;

import pentagon.dao.PhotoReviewDAO;
import pentagon.dao.PostDAO;
import pentagon.dao.SearchKeyDAO;

public class Model {
	private OAuthService service;
	private static final String callbackUrl = Meta.domain + "login.do";
	private ConnectionPool cp;
	private PostDAO postDAO;
	private PhotoReviewDAO photoReviewDAO;
	private SearchKeyDAO searchKeyDAO;
	public String key;
	public String secret;

	public Model(ServletConfig config) throws ServletException {
		this.key = config.getInitParameter("twitter_key");
		this.secret = config.getInitParameter("twitter_secret");
		this.service = new ServiceBuilder().provider(TwitterApi.SSL.class)
				.apiKey(key).apiSecret(secret).callback(callbackUrl).build();

		String jdbcName = config.getInitParameter("jdbcName");
		String jdbcURL = config.getInitParameter("jdbcURL");
		this.cp = new ConnectionPool(jdbcName, jdbcURL);
		try {
			this.postDAO = new PostDAO("post", cp);
			this.photoReviewDAO = new PhotoReviewDAO("photo_review", cp);
			this.searchKeyDAO = new SearchKeyDAO("search", cp);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

	public OAuthService getService() {
		return service;
	}

	public PostDAO getPostDAO() {
		return postDAO;
	}

	public PhotoReviewDAO getPhotoReviewDAO() {
		return photoReviewDAO;
	}

	public SearchKeyDAO getSearchKeyDAO() {
		return searchKeyDAO;
	}

	public String getKey() {
		return key;
	}

	public String getSecret() {
		return secret;
	}
}
