package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;

public class SampleChart implements Action {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {
		Item[] items = new Item[5];
		for (int i = 0; i < 5; i++) {
			items[i].setName("name" + i);
			items[i].setValue(i);
		}
		request.setAttribute("items", items);
		return "test.jsp";
	}

	@Override
	public String getName() {
		return "chart.do";
	}
	
	public class Item {
		private String name;
		private int value;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

}
