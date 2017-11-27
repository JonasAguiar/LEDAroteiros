package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex) {
			int pivot = particiona(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}

	private int particiona(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];
		int indiceinicial = leftIndex + 1;
		int indicefinal = rightIndex;

		while (indiceinicial <= indicefinal) {
			if (array[indiceinicial].compareTo(pivot) <= 0)
				indiceinicial++;
			else if (pivot.compareTo(array[indicefinal]) < 0)
				indicefinal--;
			else {
				Util.swap(array, indiceinicial, indicefinal);
				indiceinicial++;
				indicefinal--;
			}
		}
		array[leftIndex] = array[indicefinal];
		array[indicefinal] = pivot;
		return indicefinal;
	}
}
