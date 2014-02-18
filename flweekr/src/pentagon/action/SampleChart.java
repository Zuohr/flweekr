package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;

public class SampleChart implements Action {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException {
//		    Item[] items = new Item[2];
//		
//			items[0] =new Item();
//			items[0].setName("China");
//			items[0].setValue(50);
//			items[1] =new Item();
//			items[1].setName("Canada");
//			items[1].setValue(150);
//			
//			
//			
//				
//		request.setAttribute("rows", items);
		
		return "chart.jsp";
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
