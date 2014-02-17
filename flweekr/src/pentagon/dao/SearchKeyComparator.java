package pentagon.dao;

import java.util.Comparator;

public class SearchKeyComparator implements Comparator<SearchKey> {

	@Override
	public int compare(SearchKey o1, SearchKey o2) {
		return o2.getNumber() - o1.getNumber();
	}

}
