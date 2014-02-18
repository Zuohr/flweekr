package pentagon.dao;

import org.genericdao.PrimaryKey;

@PrimaryKey("id")
public class ViewHistory {
	private int id;
	private String flickr_id;
	private int count;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
