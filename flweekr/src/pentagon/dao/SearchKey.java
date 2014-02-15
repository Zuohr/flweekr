package pentagon.dao;

import org.genericdao.PrimaryKey;

@PrimaryKey("id")
public class SearchKey {
	private int id;
	private String keyword;
	private int number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}