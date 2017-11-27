package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(array != null && array.length > 1 && rightIndex < array.length
		&& leftIndex >= 0 && rightIndex > leftIndex){
			gnomeSort(array, leftIndex, rightIndex);
		}
	}

	private void gnomeSort(T[] array, int leftIndex, int rightIndex) {
		int indexPivot = leftIndex;

		while (indexPivot < rightIndex) {
			int nextIndex = indexPivot + 1;
			
			if (indexPivot < leftIndex || array[indexPivot].compareTo(array[nextIndex]) <= 0) {
				indexPivot++;
			} else {
				Util.swap(array, indexPivot, nextIndex);
				indexPivot--;
			}
		}
	}
}
