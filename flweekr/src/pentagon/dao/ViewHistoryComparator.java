package pentagon.dao;

import java.util.Comparator;

public class ViewHistoryComparator implements Comparator<ViewHistory> {

	@Override
	public int compare(ViewHistory o1, ViewHistory o2) {
		return o2.getCount() - o1.getCount();
	}

}
