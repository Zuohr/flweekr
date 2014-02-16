package pentagon.dao;

import java.util.Comparator;

public class PhotoComparator implements Comparator<PhotoReview> {

	@Override
	public int compare(PhotoReview o1, PhotoReview o2) {
		return o2.getWish() - o1.getWish();
	}

}