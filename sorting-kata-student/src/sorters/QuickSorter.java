package sorters;

import java.util.Comparator;

import comparators.IntegerComparator;
import structures.SwapList;

public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	
	@Override
	public SwapList<T> sort() {
        quickhelper(0, list.size() -1);
        return list;
	}

	private void quickhelper(int low, int high){
		if(low < high){
			int part = partition(low,high);
			quickhelper(low, part -1);
			quickhelper(part +1, high);
		}
	}
	
	public int partition(int low, int high){
		list.swap((low + high)/2, high);
		int piv = high;
		int store = low;
		int j;
		
		for(j = low; j <= high - 1; j++){
			if(list.compare(j, piv, comparator) <= 0){
				list.swap(j, store);
				store++;
			}
		}
		
		list.swap(store, high);
		return store;
	}
	
}
