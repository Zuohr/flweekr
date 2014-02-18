package pentagon.dao;

import org.genericdao.PrimaryKey;

@PrimaryKey("id")
public class CountryStats {
	private int id;
	private String name;
	private int wished;
	private int been;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWished() {
		return wished;
	}

	public void setWished(int wished) {
		this.wished = wished;
	}

	public int getBeen() {
		return been;
	}

	public void setBeen(int been) {
		this.been = been;
	}

}
