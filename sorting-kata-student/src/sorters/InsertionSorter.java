package sorters;

import java.util.Comparator;

import comparators.IntegerComparator;
import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	
	@Override
	public SwapList<T> sort() {
		int out, in;
		
		for(out = 1; out < list.size(); out++){
			in = out;
			
			while(in > 0 && list.compare(in-1, in, comparator) > 0){
				list.swap(in, in -1);
				in--;
			}

		}

      return list;
      
	}    
}
