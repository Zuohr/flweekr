package pentagon.dao;

import org.genericdao.PrimaryKey;

@PrimaryKey("id")
public class SearchKey {
	private String keyword;
	private int number;

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
