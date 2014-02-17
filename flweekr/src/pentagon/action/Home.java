package pentagon.action;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;

import pentagon.apibean.FlickrBean;
import pentagon.dao.PhotoComparator;
import pentagon.dao.PhotoReview;
import pentagon.dao.PhotoReviewDAO;
import pentagon.flickrbean.JsonFlickrApi;
import pentagon.flickrbean.JsonFlickrGetInfo;
import pentagon.model.Model;
import pentagon.sdk.FlickrAPI;

public class Home implements Action {
	private PhotoReviewDAO photoReviewDAO;

	public Home(Model model) {
		this.photoReviewDAO = model.getPhotoReviewDAO();
	}

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {
		// set default pictures
		String[] imgs = {
				"http://farm6.staticflickr.com/5348/9436623932_20b5af089b_o.jpg",
				"http://farm9.staticflickr.com/8177/8011151933_8366e9340e_o.png",
				"http://farm5.staticflickr.com/4016/4444574582_767aae7a99_o.jpg", };
		String[] img_links = { "9436623932",
				"8011151933",
				"4444574582", };

		String last_search = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("last_search".equals(cookie.getName())) {
				last_search = cookie.getValue();
			}
		}
		if (last_search == null) {
			PhotoReview[] prs = photoReviewDAO.match();
			if (prs != null && prs.length > 3) {
				Arrays.sort(prs, new PhotoComparator());
				for (int i = 0; i < 3; i++) {
					String flickr_id = prs[i].getFlickr_id();
					/*
					 * get pic detail via flickr
					 * */
					FlickrBean flkBean = new FlickrBean();
					flkBean.setMethod("flickr.photos.getInfo");
					flkBean.setFlickrPhotoId(flickr_id);
					FlickrAPI flkAPI = new FlickrAPI(flkBean);
					JsonFlickrGetInfo info = flkAPI.getImgInfo();
					imgs[i] = info.photo.getImgUrl();
					img_links[i] = flickr_id; 
				}
			}
		} else {
			FlickrBean flkBean = new FlickrBean();
			flkBean.setMethod("flickr.photos.search");
			flkBean.setPerPage("3");
			flkBean.setFlickrText(last_search+"+trip");
			flkBean.setFlickrHasGeo("1");
			flkBean.setFlickrExtra("url_o");
			flkBean.setFlickrSort("relevance");
			FlickrAPI flkAPI = new FlickrAPI(flkBean);
			JsonFlickrApi jfa = flkAPI.getFlickrImage();
			
			for(int i = 0; i < 3; i++) {
				imgs[i] = jfa.photos.photo.get(i).getImgUrl();
				img_links[i] = jfa.photos.photo.get(i).getId();
			}
		}

		request.setAttribute("imgs", imgs);
		request.setAttribute("img_links", img_links);

		return "home.jsp";
	}

	@Override
	public String getName() {
		return "home.do";
	}

}
