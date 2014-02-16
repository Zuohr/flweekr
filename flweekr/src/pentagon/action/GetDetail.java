package pentagon.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;
import org.scribe.oauth.OAuthService;

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

	public GetDetail(Model model) {
		this.service = model.getService();
		this.postDAO = model.getPostDAO();
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {

		String flickr_id = request.getParameter("flickr_id");
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
					Status status = twApi.sendStatus(text);
					if (status == null) {
						request.setAttribute("result", "failed");
					} else {
						Oembed oembed = twApi.getOembed(status);
						String html = oembed.getHtml();
						System.out.println(html);
						Pattern p = Pattern.compile("<blockquote class=\"twitter-tweet\" lang=\"en\">(.*)</blockquote>");
						Matcher m = p.matcher(html);
						if (m.find()) {
							html = m.group(1);
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
		
		// set statistics

		return "detail.jsp";
	}

	@Override
	public String getName() {
		return "getdetail.do";
	}

}
