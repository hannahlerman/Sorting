package sorters;

import java.util.Comparator;

import comparators.IntegerComparator;
import structures.SwapList;

public class SelectionSorter<T> extends AbstractSorter<T> {

	public SelectionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		for (int i = 0; i < list.size() - 1; i++) {
			list.swap(i, minIndex(i));
		}
		return list;
	}
	
	IntegerComparator comparator = new IntegerComparator();

	private int minIndex(int startIndex) {
		int minIndex = startIndex;
		for (int i = startIndex + 1; i < list.size(); i++) {
			if (comparator.compare(i, minIndex) <= 0) {
				minIndex = i;
			}
		}
		return minIndex;
	}
}
