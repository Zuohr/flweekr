package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.scribe.oauth.OAuthService;

import pentagon.apibean.FlickrBean;
import pentagon.dao.CountryStats;
import pentagon.dao.CountryStatsDAO;
import pentagon.dao.PhotoReview;
import pentagon.dao.PhotoReviewDAO;
import pentagon.dao.Post;
import pentagon.dao.PostDAO;
import pentagon.dao.ViewHistory;
import pentagon.dao.ViewHistoryDAO;
import pentagon.flickrbean.JsonFlickrApi;
import pentagon.flickrbean.JsonFlickrGetInfo;
import pentagon.model.Model;
import pentagon.model.User;
import pentagon.sdk.FlickrAPI;
import pentagon.sdk.TwitterAPI;
import pentagon.twitterbean.Oembed;
import pentagon.twitterbean.Status;

public class GetDetail implements Action {
	private OAuthService service;
	private PostDAO postDAO;
	private PhotoReviewDAO photoReviewDAO;
	private ViewHistoryDAO viewHistoryDAO;
	private CountryStatsDAO countryStatsDAO;
	private static final String URL = "http://localhost:8080/getdetail.do?photo_id=";

	public GetDetail(Model model) {
		this.postDAO = model.getPostDAO();
		this.photoReviewDAO = model.getPhotoReviewDAO();
		this.viewHistoryDAO = model.getViewHistoryDAO();
		this.countryStatsDAO = model.getCountryStatsDAO();
		this.service = model.getService();
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {

		String flickr_id = request.getParameter("photo_id");

		if (flickr_id == null || flickr_id.isEmpty()) {
			flickr_id = (String) request.getSession().getAttribute("flickr_id");
			if (flickr_id == null || flickr_id.isEmpty()) {
				return "search.do";
			}
		}
		request.getSession().setAttribute("flickr_id", flickr_id);

		// update view history
		updateViewHistory(flickr_id);

		// get picture via flickr api
		FlickrBean flkBean = new FlickrBean();
		flkBean.setMethod("flickr.photos.getInfo");
		flkBean.setFlickrPhotoId(flickr_id);
		FlickrAPI flkAPI = new FlickrAPI(flkBean);
		JsonFlickrGetInfo info = flkAPI.getImgInfo();
		request.setAttribute("photo_ob", info.photo);

		// get flickr block list of picture by location
		JsonFlickrApi jfaLoc;
		FlickrBean locBean = new FlickrBean();
		locBean.setMethod("flickr.photos.search");
		locBean.setPerPage("20");
		if (info.photo.location != null) {
			locBean.setFlickrLat(info.photo.location.latitude);
			locBean.setFlickrLon(info.photo.location.longitude);
			FlickrAPI flkLoc = new FlickrAPI(locBean);
			jfaLoc = flkLoc.getImageByLoc();
		} else {
			locBean.setFlickrText("trip");
			FlickrAPI flkLoc = new FlickrAPI(locBean);
			jfaLoc = flkLoc.getFlickrImage();
		}

		request.setAttribute("flk_loc_plist", jfaLoc.photos.photo);

		// set sign with twitter button
		request.setAttribute("flickr_id", flickr_id);

		// set twitter nearby
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			TwitterAPI twapi = new TwitterAPI(user.getAccessToken(), service);
			Status[] statuses = twapi.searchByCoordination(info,
					info.photo.title._content);
			if (statuses != null) {
				String[] tw_nearby = new String[statuses.length];
				for (int i = 0; i < statuses.length; i++) {
					Oembed oembed = twapi.getOembed(statuses[i]).strip();
					tw_nearby[i] = oembed.getHtml();
				}
				request.setAttribute("tw_nearby", tw_nearby);
				if (statuses.length > 0) {
					request.setAttribute("nearby_title",
							"What people tweets around");
				}
			}
		}

		// set twitter discussion
		if (user != null) {
			if ("send_tweet".equals(request.getParameter("send_btn"))) {

				String text = request.getParameter("text");
				if (text != null && !text.isEmpty()) {
					TwitterAPI twApi = new TwitterAPI(user.getAccessToken(),
							service);
					// add website url
					text += String.format(" --from EasyTrip %s%s", URL,
							flickr_id);
					Status status = twApi.sendStatus(text);
					if (status == null) {
						request.setAttribute("result", "Send tweet failed.");
					} else {
						Oembed oembed = twApi.getOembed(status).strip();
						String html = oembed.getHtml();
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
		if (posts != null) {
			String[] tw_discuss = new String[posts.length];
			for (int i = 0; i < posts.length; i++) {
				tw_discuss[i] = posts[i].getTwitter_url();
			}
			request.setAttribute("tw_discuss", tw_discuss);
		}

		// set photo like stats
		PhotoReview pr = new PhotoReview();
		String country = info.photo.location.country._content;
		try {
			Transaction.begin();
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
				// update wish table
				if (country != null && !country.trim().isEmpty()) {
					updateWish(country);
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
				// update been table
				if (country != null && !country.trim().isEmpty()) {
					updateBeen(country);
				}
			}
			if (pr.getFlickr_id() == null) {
				pr = photoReviewDAO.read(flickr_id);
				if (pr == null) {
					pr = new PhotoReview();
					pr.setFlickr_id(flickr_id);
					photoReviewDAO.create(pr);
				}
			}

			Transaction.commit();
		} catch (RollbackException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
		}
		request.setAttribute("wish_num", pr.getWish());
		request.setAttribute("been_num", pr.getBeen_there());
		request.setAttribute("nav_explore", "active");

		return "detail.jsp";
	}

	@Override
	public String getName() {
		return "getdetail.do";
	}

	private void updateBeen(String country) throws RollbackException {
		CountryStats c = countryStatsDAO.read(country);
		if (c == null) {
			c = new CountryStats();
			c.setName(country);
			c.setWished(0);
			c.setBeen(1);
			countryStatsDAO.create(c);
		} else {
			c.setBeen(c.getBeen() + 1);
			countryStatsDAO.update(c);
		}
	}

	private void updateWish(String country) throws RollbackException {
		CountryStats c = countryStatsDAO.read(country);
		if (c == null) {
			c = new CountryStats();
			c.setName(country);
			c.setWished(1);
			c.setBeen(0);
			countryStatsDAO.create(c);
		} else {
			c.setWished(c.getWished() + 1);
			countryStatsDAO.update(c);
		}
	}

	private void updateViewHistory(String flickr_id) throws RollbackException {
		ViewHistory viewHistory = viewHistoryDAO.read(flickr_id);
		if (viewHistory == null) {
			viewHistory = new ViewHistory();
			viewHistory.setFlickr_id(flickr_id);
			viewHistory.setCount(1);
			viewHistoryDAO.create(viewHistory);
		} else {
			viewHistory.setCount(viewHistory.getCount() + 1);
			viewHistoryDAO.update(viewHistory);
		}
	}

}
