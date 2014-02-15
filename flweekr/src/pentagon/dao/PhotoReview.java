package pentagon.dao;

import org.genericdao.PrimaryKey;

@PrimaryKey("id")
public class PhotoReview {
	private int id;
	private String flickr_id;
	private int wish;
	private int been_there;
	private int num_like;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlickr_id() {
		return flickr_id;
	}

	public void setFlickr_id(String flickr_id) {
		this.flickr_id = flickr_id;
	}

	public int getWish() {
		return wish;
	}

	public void setWish(int wish) {
		this.wish = wish;
	}

	public int getBeen_there() {
		return been_there;
	}

	public void setBeen_there(int been_there) {
		this.been_there = been_there;
	}

	public int getNum_like() {
		return num_like;
	}

	public void setNum_like(int num_like) {
		this.num_like = num_like;
	}

}