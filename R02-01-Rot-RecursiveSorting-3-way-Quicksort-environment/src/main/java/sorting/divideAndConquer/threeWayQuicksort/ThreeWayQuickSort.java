package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && !(array.length == 0 ||  rightIndex >= array.length || leftIndex < 0 || array == null || rightIndex < 0 )) {
			int[] position = this.particiona(array, leftIndex, rightIndex);
 			sort(array, leftIndex, position[0]-1);
			sort(array, position[1], rightIndex);
		}
	}
	
	private int[] particiona(T[] array, int leftIndex, int rightIndex){
		int pivot = leftIndex;
		int firstdivision = leftIndex + 1;
		int seconddivision = leftIndex + 1;
		
		for (int indice = leftIndex+1; indice <= rightIndex; indice++) {
			if (array[indice].compareTo(array[pivot]) < 0) {
				Util.swap(array, indice, firstdivision);
				if (seconddivision > firstdivision) {
					Util.swap(array, indice, seconddivision);
				}
				firstdivision++;
				seconddivision++;
			} else if (array[indice].compareTo(array[pivot]) == 0) {
				Util.swap(array, indice, seconddivision);
				seconddivision++;
			}
		}
		
		Util.swap(array, firstdivision -1, pivot);
		
		int[] limit = {firstdivision, seconddivision};
		return limit;
	}

}
