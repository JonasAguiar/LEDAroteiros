package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && !(array.length == 0 || 
				rightIndex >= array.length || leftIndex < 0 || array == null || rightIndex < 0 )) {
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		T[] arrayAuxiliar = Arrays.copyOf(array, array.length);
		int indiceinicial = leftIndex;
		int indicedomeio = middle + 1;
		int i = leftIndex;

		while (indiceinicial <= middle && indicedomeio <= rightIndex) {
			
			if (arrayAuxiliar[indiceinicial].compareTo(arrayAuxiliar[indicedomeio]) < 0) {
				array[i] = arrayAuxiliar[indiceinicial];
				indiceinicial++;
			} else {
				array[i] = arrayAuxiliar[indicedomeio];
				indicedomeio++;
			}
			i++;
		}while (indiceinicial <= middle) {
			array[i] = arrayAuxiliar[indiceinicial];
			indiceinicial++;
			i++;
		}}
	
}
