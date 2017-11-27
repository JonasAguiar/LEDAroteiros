package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex < rightIndex && !(array.length == 0 || 
				rightIndex >= array.length || leftIndex < 0 || array == null || rightIndex < 0)) {
			int maior = searchBigger(array, leftIndex, rightIndex);
			Integer[] contador = counter(array, maior, leftIndex, rightIndex);
			Integer[] acumulador = accumulate(contador);
			order(array, leftIndex, rightIndex, acumulador);
		}
	}
	
	private int searchBigger(Integer[] array, int leftIndex, int rightIndex) {
		
		int maior = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}
	
	private Integer[] counter(Integer[] array, int maior, int leftIndex, int rightIndex) {
		
		int tamanhoContador = maior + 1;
		Integer[] contador = new Integer[tamanhoContador];
		for (int i = 0; i < contador.length; i++) {
			contador[i] = 0;
		}
		for (int i = leftIndex; i <= rightIndex; i++) {
			contador[array[i]] += 1;
		}
		return contador;
	}

	private Integer[] accumulate(Integer[] array) {
		
		Integer[] acumulador = Arrays.copyOf(array, array.length);
		for (int i = 1; i < acumulador.length; i++) {
			acumulador[i] += acumulador[i-1];
		}
		return acumulador;
	}
	
	private void order(Integer[] array, int leftIndex, int rightIndex, Integer[] acumulador) {
		
		Integer[] copiaArray = Arrays.copyOf(array, array.length);
		for (int i = leftIndex; i <= rightIndex; i++) {
			int pos = acumulador[copiaArray[i]] - 1;
			array[pos] = copiaArray[i];
			acumulador[copiaArray[i]]--;
		}
	}

}
