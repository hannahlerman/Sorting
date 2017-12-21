package sorters;

import java.util.Comparator;

import comparators.IntegerComparator;
import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {

	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
      for(int i = (list.size()/2) - 1; i >= 0; i--){
    	  bubbleDown(i, list.size() -1);
      }
      
      for(int l = list.size() -1; l >= 1; l--){
    	 list.swap(0, l);
    	 bubbleDown(0, l-1);
      }
      
      return list;
      
	}


	public void bubbleDown(int first, int last){
		
		while(first*2 +1 <= last){
			int child1 = first*2 +1;
			int child2 = first*2 +2;
			int temp = child1;
			
		if(first*2+2 <= last && list.compare(child1, child2, comparator) < 0){
			temp = child2;
			}

				if(list.compare(first, temp, comparator) < 0){
					list.swap(first, temp);
					first = temp;
				}
				
				else first = last;
				
			}
		}
	}
	


