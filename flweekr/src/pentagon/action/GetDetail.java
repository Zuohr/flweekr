package pentagon.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.scribe.oauth.OAuthService;

import pentagon.dao.PhotoReview;
import pentagon.dao.PhotoReviewDAO;
import pentagon.dao.Post;
import pentagon.dao.PostDAO;
import pentagon.model.Model;
import pentagon.model.User;
import pentagon.sdk.TwitterAPI;
import pentagon.twitterbean.Oembed;
import pentagon.twitterbean.Status;

public class GetDetail implements Action {
	private OAuthService service;
	private PostDAO postDAO;
	private PhotoReviewDAO photoReviewDAO;
	private static final String URL = "http://localhost:8080/getdetail.do?photo_id=";

	public GetDetail(Model model) {
		this.service = model.getService();
		this.postDAO = model.getPostDAO();
		this.photoReviewDAO = model.getPhotoReviewDAO();
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {

		String flickr_id = request.getParameter("photo_id");
		flickr_id = "4675986645";// TODO test
		if (flickr_id == null || flickr_id.isEmpty()) {
			return "search.do";
		}

		// set picture
		String imgUrl = "http://farm6.staticflickr.com/5348/9436623932_20b5af089b_o.jpg";
		/*
		 * get picture via flickr api
		 */
		request.setAttribute("pic_url", imgUrl);

		// set twitter discussion
		if ("send_tweet".equals(request.getParameter("send_btn"))) {
			User user = (User) request.getSession().getAttribute("user");

			if (user != null) {
				String text = request.getParameter("text");
				if (text != null && !text.isEmpty()) {
					TwitterAPI twApi = new TwitterAPI(user.getAccessToken(),
							service);
					// add website url
					text += String.format(" from easy trip %s%s", URL,
							flickr_id);
					Status status = twApi.sendStatus(text);
					if (status == null) {
						request.setAttribute("result", "Send tweet failed.");
					} else {
						Oembed oembed = twApi.getOembed(status);
						String html = oembed.getHtml();
						Pattern p = Pattern.compile("<p>.*</a>");
						Matcher m = p.matcher(html);
						if (m.find()) {
							html = m.group();
						}
						String twitter_id = status.getId_str();
						Post post = new Post();
						post.setFlickr_id(flickr_id);
						post.setTwitter_id(twitter_id);
						post.setTwitter_url(html);
						postDAO.create(post);
					}
				}
			}
		}

		Post[] posts = postDAO.read(flickr_id);
		String[] oembeds = new String[posts.length];
		for (int i = 0; i < posts.length; i++) {
			oembeds[i] = posts[i].getTwitter_url();
		}
		request.setAttribute("oembeds_list", oembeds);

		// set photo like stats
		try {
			Transaction.begin();
			PhotoReview pr = null;
			if ("submit".equals(request.getParameter("wish_btn"))) {
				pr = photoReviewDAO.read(flickr_id);
				if (pr == null) {
					pr = new PhotoReview();
					pr.setFlickr_id(flickr_id);
					pr.setWish(1);
					photoReviewDAO.create(pr);
				} else {
					pr.setWish(pr.getWish() + 1);
					photoReviewDAO.update(pr);
				}
			} else if ("submit".equals(request.getParameter("been_btn"))) {
				pr = photoReviewDAO.read(flickr_id);
				if (pr == null) {
					pr = new PhotoReview();
					pr.setFlickr_id(flickr_id);
					pr.setBeen_there(1);
					photoReviewDAO.create(pr);
				} else {
					pr.setBeen_there(pr.getBeen_there() + 1);
					photoReviewDAO.update(pr);
				}
			}
			if (pr == null) {
				pr = photoReviewDAO.read(flickr_id);
				if (pr == null) {
					pr = new PhotoReview();
					pr.setFlickr_id(flickr_id);
					photoReviewDAO.create(pr);
				}
			}
			request.setAttribute("wish_num", pr.getWish());
			request.setAttribute("benn_num", pr.getBeen_there());

			Transaction.commit();
		} catch (RollbackException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
		}

		// set statistics

		return "detail.jsp";
	}

	@Override
	public String getName() {
		return "getdetail.do";
	}

}
